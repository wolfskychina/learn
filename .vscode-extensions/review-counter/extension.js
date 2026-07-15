const vscode = require('vscode');
const path = require('path');
const fs = require('fs');

const INCREMENT_COMMAND = 'reviewCounter.increment';
const FALLBACK_DIR = 'src/leetcode/util';
const FALLBACK_FILE = '.review-counts.csv';

let outputChannel;

function activate(context) {
    outputChannel = vscode.window.createOutputChannel('Review Counter');
    outputChannel.appendLine('Review Counter 扩展已激活');

    const storage = new ReviewStorage(context);

    const hoverProvider = vscode.languages.registerHoverProvider('java', {
        provideHover(document, position) {
            outputChannel.appendLine(`Hover 触发: ${document.uri.fsPath}, 语言: ${document.languageId}`);

            const range = document.getWordRangeAtPosition(position);
            if (!range) {
                outputChannel.appendLine('未获取到单词范围');
                return;
            }

            const word = document.getText(range);
            const lineText = document.lineAt(position.line).text;
            outputChannel.appendLine(`当前单词: ${word}, 当前行: ${lineText.trim()}`);

            // 仅在类名位置触发：当前行包含 class 关键字且当前单词匹配类名
            if (!lineText.includes('class')) {
                outputChannel.appendLine('当前行不含 class 关键字，跳过');
                return;
            }

            const classNameMatch = lineText.match(/class\s+(\w+)/);
            if (!classNameMatch || classNameMatch[1] !== word) {
                outputChannel.appendLine(`未匹配类名: 捕获=${classNameMatch ? classNameMatch[1] : 'null'}, 单词=${word}`);
                return;
            }

            const filePath = document.uri.fsPath;
            const count = storage.getCount(filePath);
            outputChannel.appendLine(`显示 Hover: ${filePath}, count=${count}`);

            const commandUri = vscode.Uri.parse(
                `command:${INCREMENT_COMMAND}?${encodeURIComponent(JSON.stringify({ filePath }))}`
            );

            const markdown = new vscode.MarkdownString(
                `Review 次数：**${count}** [➕](${commandUri} "增加 review 次数") 增加 review 次数`
            );
            markdown.isTrusted = true;
            markdown.supportHtml = true;

            return new vscode.Hover(markdown, range);
        }
    });

    const incrementCommand = vscode.commands.registerCommand(
        INCREMENT_COMMAND,
        async (args) => {
            const filePath = args?.filePath;
            if (!filePath) {
                vscode.window.showWarningMessage('未能识别当前文件路径');
                return;
            }
            const newCount = storage.increment(filePath);
            vscode.window.showInformationMessage(
                `已增加 Review 次数，当前为 ${newCount} 次`
            );
        }
    );

    context.subscriptions.push(hoverProvider, incrementCommand);
}

class ReviewStorage {
    constructor(context) {
        this.context = context;
    }

    getCount(filePath) {
        const data = this.loadData();
        return data[filePath] ?? 0;
    }

    increment(filePath) {
        const data = this.loadData();
        const newCount = (data[filePath] ?? 0) + 1;
        data[filePath] = newCount;
        this.saveData(data);
        return newCount;
    }

    loadData() {
        // 优先尝试插件工作区存储
        const workspaceState = this.context.workspaceState.get('reviewCounts');
        if (workspaceState) {
            return workspaceState;
        }

        // 回退到工程目录下的 CSV 文件
        const fallbackPath = this.getFallbackPath();
        if (fallbackPath && fs.existsSync(fallbackPath)) {
            try {
                const raw = fs.readFileSync(fallbackPath, 'utf-8');
                const lines = raw.split(/\r?\n/).filter(line => line.trim() !== '');
                const result = {};
                for (let i = 0; i < lines.length; i++) {
                    if (i === 0) {
                        // 跳过表头
                        continue;
                    }
                    const { filePath, count } = parseCsvLine(lines[i]);
                    if (filePath && !Number.isNaN(count)) {
                        result[filePath] = count;
                    }
                }
                return result;
            } catch {
                return {};
            }
        }
        return {};
    }

    saveData(data) {
        // 优先使用插件工作区存储
        try {
            this.context.workspaceState.update('reviewCounts', data);
            return;
        } catch {
            // 回退到工程目录文件
        }

        const fallbackPath = this.getFallbackPath();
        if (!fallbackPath) {
            return;
        }
        try {
            const dir = path.dirname(fallbackPath);
            if (!fs.existsSync(dir)) {
                fs.mkdirSync(dir, { recursive: true });
            }

            const lines = ['filePath,count'];
            for (const [filePath, count] of Object.entries(data)) {
                lines.push(`${csvEscape(filePath)},${count}`);
            }
            fs.writeFileSync(fallbackPath, lines.join('\n') + '\n', 'utf-8');
        } catch (err) {
            vscode.window.showErrorMessage(`Review 计数保存失败: ${err}`);
        }
    }

    getFallbackPath() {
        const workspaceFolders = vscode.workspace.workspaceFolders;
        if (!workspaceFolders || workspaceFolders.length === 0) {
            return undefined;
        }
        return path.join(workspaceFolders[0].uri.fsPath, FALLBACK_DIR, FALLBACK_FILE);
    }
}

function csvEscape(value) {
    if (value.includes('"') || value.includes(',') || value.includes('\n') || value.includes('\r')) {
        return '"' + value.replace(/"/g, '""') + '"';
    }
    return value;
}

function parseCsvLine(line) {
    const result = [];
    let current = '';
    let inQuotes = false;
    for (let i = 0; i < line.length; i++) {
        const char = line[i];
        const nextChar = line[i + 1];
        if (inQuotes) {
            if (char === '"' && nextChar === '"') {
                current += '"';
                i++;
            } else if (char === '"') {
                inQuotes = false;
            } else {
                current += char;
            }
        } else {
            if (char === '"') {
                inQuotes = true;
            } else if (char === ',') {
                result.push(current);
                current = '';
            } else {
                current += char;
            }
        }
    }
    result.push(current);
    return {
        filePath: result[0] || '',
        count: result.length > 1 ? parseInt(result[1], 10) : NaN
    };
}

function deactivate() {}

module.exports = { activate, deactivate };
