$source = "$PSScriptRoot"
$dest = "$PSScriptRoot\review-counter-0.0.1.vsix"
$temp = "$env:TEMP\review-counter-vsix"

# 清理临时目录
if (Test-Path $temp) {
    Remove-Item -Path $temp -Recurse -Force
}
New-Item -ItemType Directory -Path "$temp\extension" | Out-Null

# 复制必要文件
Copy-Item "$source\extension.js" "$temp\extension\extension.js"
Copy-Item "$source\package.json" "$temp\extension\package.json"
Copy-Item "$source\README.md" "$temp\extension\README.md"

# 删除旧的 vsix
if (Test-Path $dest) {
    Remove-Item -Path $dest -Force
}

# 先打包成 zip，再重命名为 vsix
$zip = "$PSScriptRoot\review-counter-0.0.1.zip"
if (Test-Path $zip) {
    Remove-Item -Path $zip -Force
}
Compress-Archive -Path "$temp\extension" -DestinationPath $zip -Force
Rename-Item -Path $zip -NewName $dest -Force

Write-Host "已生成: $dest"
