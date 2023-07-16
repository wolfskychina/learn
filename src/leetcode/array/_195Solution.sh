# 输出一个文本文件的第10行
# 目前最快的方式
sed -n 10p file.txt

# 其他的方式
# beat 18%
awk 'NR==10{print;exit}' file.txt
# beat 41%
sed -n '10p;11q' file.txt
# beat 58%
cut -d$'\n' -f 10 file.txt
