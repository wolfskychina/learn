# Review Counter

一个 VS Code 扩展插件，用于统计每个源代码文件被 Review 的次数。

## 功能

- 当鼠标悬停在 Java 源文件中的类名上时，显示当前文件的 Review 次数。
- 提供一个 ➕ 按钮，点击后可将该文件的 Review 次数加 1。

## 安装方式

1. 打开 VS Code。
2. 按 `Ctrl+Shift+P`（macOS：`Cmd+Shift+P`）打开命令面板。
3. 输入并执行 `Extensions: Install from VSIX...`（如果需要打包）或 `Extensions: Open Extensions Folder`。
4. 将整个 `review-counter` 文件夹复制到 VS Code 扩展目录：
   - Windows：`%USERPROFILE%\.vscode\extensions\`
   - macOS：`~/.vscode/extensions/`
   - Linux：`~/.vscode/extensions/`
5. 重启 VS Code。

> **注意**：扩展目录中的文件夹名建议为 `review-counter-0.0.1`（名称-版本号），但 `review-counter` 也可以。复制后请确保目录结构为 `extensions/review-counter/extension.js` 和 `extensions/review-counter/package.json`。

## 使用方式

1. 打开任意 Java 源文件。
2. 将鼠标悬停在类名上。
3. 在弹出的提示框中查看当前 Review 次数。
4. 点击 ➕ 按钮，增加该文件的 Review 次数。

## 数据存储

- 优先使用 VS Code 插件自身的 `workspaceState` 存储空间。
- 如果插件存储不可用，则回退到工程目录下的 `src/leetcode/util/.review-counts.csv` 文件，便于导入 Excel 或数据库分析。

CSV 文件格式示例：

```csv
filePath,count
"h:\VS-workspace\learn\src\leetcode\a0\_1Solution.java",5
"h:\VS-workspace\learn\src\leetcode\a1100\_1129Solution.java",3
```

## 问题排查

如果插件没有生效，请按以下步骤检查：

1. **确认扩展已加载**
   - 打开 VS Code 扩展面板（左侧图标或 `Ctrl+Shift+X`）。
   - 搜索 `Review Counter`，查看是否出现在已安装扩展列表中，且已启用。

2. **查看运行中的扩展**
   - 按 `Ctrl+Shift+P` 打开命令面板。
   - 执行 `Developer: Show Running Extensions`。
   - 查看列表中是否有 `review-counter`。如果没有，说明扩展未被加载。

3. **查看扩展日志**
   - 按 `Ctrl+Shift+P` 打开命令面板。
   - 执行 `Developer: Toggle Developer Tools`，切换到 Console 标签查看错误。
   - 或执行 `View: Toggle Output`，在输出面板右上角选择 `Review Counter` 或 `Log (Extension Host)`，查看启动日志。

4. **检查文件语言 ID**
   - 打开 Java 文件后，查看右下角状态栏显示的语言是否为 `Java`。
   - 如果不是，点击语言标识，手动选择 `Java`。

5. **重新复制扩展**
   - 完全关闭 VS Code。
   - 删除扩展目录中的 `review-counter` 文件夹。
   - 重新复制最新版本的 `review-counter` 文件夹到扩展目录。
   - 重启 VS Code。

