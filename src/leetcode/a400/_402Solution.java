package leetcode.a400;

public class _402Solution {

    String res = "0";

    public String removeKdigits(String num, int k) {
        if (num.length() <= k)
            return "0";

        StringBuilder sb = new StringBuilder();
        char[] array = num.toCharArray();
        int i = 0;
        int kk =k;
        for (; i < array.length-1 && k != 0; i++) {

            if (array[i] > array[i + 1]) {
                // del i
                k--;
            } else {
                sb.append(array[i]);
            }
        }

        sb.append(num.substring(i));
        String ans = "";

        if(kk==k && k!=0){
            // 当前的剩余num不存在逆序对
            // 直接从后往前删除，返回
            sb.setLength(sb.length()-k);
            ans = sb.toString();
            int j = 0;
            for (; j < ans.length() - 1; j++) {
                if (ans.charAt(j) != '0')
                    break;
            }
            res = ans.substring(j);       
            return this.res;
        }

        if (k != 0) {
            removeKdigits(sb.toString(), k);
        } else {
            ans = sb.toString();
            int j = 0;
            for (; j < ans.length() - 1; j++) {
                if (ans.charAt(j) != '0')
                    break;
            }
            res = ans.substring(j);
        }
        return this.res;
    }

    public static void main(String[] args){

        _402Solution so = new _402Solution();
        so.removeKdigits("1173", 2);

    }
}
