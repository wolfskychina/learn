package leetcode.a900;

import java.util.HashSet;
import java.util.Set;
/**
 * 有多少不同的电子邮箱地址
 */
public class _929Solution {
  
    /**
     * 字符串处理速度比较慢
     * @param emails
     * @return
     */
    public int numUniqueEmails(String[] emails) {

        Set<String> set = new HashSet<>();
        for(String email:emails){
            String local = email.split("@")[0];
            if(local.indexOf('+')!=-1){
                local = local.substring(0,local.indexOf('+'));
            }
            // 删除特定的字符，还是用字符串替代
            set.add(local.replace(".","")+"@"+email.split("@")[1]);
        }
        return set.size();

    }

    /**
     * 直接按位处理比较快
     * @param emails
     * @return
     */
    public int numUniqueEmails1(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            set.add(convertEmail(email));
        }
        return set.size();
    }

    String convertEmail(String email) {
        char[] chars = email.toCharArray();
        int size = 0, n = chars.length;
        for (int i = 0; i < n; ) {
            char c = chars[i];
            if (c == '@') {
                while (i < n) {
                    chars[size++] = chars[i++];
                }
                break;
            } else if (c == '+') {
                while (i < n && chars[i] != '@') {
                    i++;
                }
            } else {
                i++;
                if (c != '.') {
                    chars[size++] = c;
                }
            }
        }
        return new String(chars, 0, size);
    }

    public static void main(String[] args){

        String [] str = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        _929Solution so  =  new _929Solution();
        so.numUniqueEmails(str);
      
    }
}
