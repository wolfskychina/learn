# 实现一个文本文件的行转列
head -1 file.txt | wc -w | xargs seq | xargs -n1 -I{} sh -c "cut -d' ' -f{} file.txt | xargs"

# 使用awk逐行处理，这个速度更快
awk '
{
    for (i = 1; i <= NF; i++) {
        if(NR == 1) {
            s[i] = $i; } else { s[i] = s[i] " " $i;
        }
    }
}
END {
    for (i = 1; s[i] != ""; i++) {
        print s[i];
    }
}' file.txt