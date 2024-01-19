package leetcode.a800;
/**
 * 将标题中的单词按照规则进行首字母大写，其他字母小写
 */
public class _2129Solution {

    public String capitalizeTitle(String title) {

        String[] array = title.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String str:array){
            sb.append(cap(str)).append(" ");
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }

    private String cap(String str){
        char[] array = str.toCharArray();
        if(array.length==1){
            array[0] = array[0]<='Z'?(char)('a'+array[0]-'A'):array[0];

        }else if(array.length==2){
            array[0] = array[0]<='Z'?(char)('a'+array[0]-'A'):array[0];
            array[1] = array[1]<='Z'?(char)('a'+array[1]-'A'):array[1];
        }else{
            array[0] = array[0]>='a'?(char)('A'+array[0]-'a'):array[0];

            for(int i=1;i<array.length;i++){
                array[i] = array[i]<='Z'?(char)('a'+array[i]-'A'):array[i];
            }
        }

        return String.valueOf(array);
    }

     public String capitalizeTitle1(String title) {
        int len = title.length();
        char[] arr = title.toCharArray();
        // i表示单词开始位置，j表示单词后面的空格或者整个字符串的结束位置
        int i = 0, j = 0;
        while(i < len){
            j = i;
            // 先将整个单词的所有字符都变成小写（32在二进制中的位置上变成1，其余位置不变）
            while(j < len && arr[j] != ' '){
                // TODO 'a'和'A'的唯一区别是ascii码的右数第6位上是1
                arr[j ++] |= 32;
            }
            // 如果单词长度大于2则将首字母变成大写（32在二进制的位置上变成0，其余位置不变）
            if(j - i > 2){
                arr[i] &= ~32;
            }
            // 单词起始位置定位到空格的下一位
            i = j + 1;
        }
        return new String(arr);
    }
}
