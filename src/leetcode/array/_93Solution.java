package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断一个字符串表示的ip地址是否合法
 */
public class _93Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        
        StringBuffer ip = new StringBuffer();
        // 使用每一段的长度作为索引而不是起止位置

        // 更加方便思考

        for(int a = 1 ; a < 4 ; ++ a)
        for(int b = 1 ; b < 4 ; ++ b)
        for(int c = 1 ; c < 4 ; ++ c)
        {
            if(s.length() -a-b-c <4 && s.length() -a-b-c >0)
            {
                int n1 = Integer.parseInt(s.substring(0, a));
                int n2 = Integer.parseInt(s.substring(a, a+b));
                int n3 = Integer.parseInt(s.substring(a+b, a+b+c));
                int n4 = Integer.parseInt(s.substring(a+b+c));
                if(n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255)
                {
                    ip.append(n1).append('.').append(n2)
                        .append('.').append(n3).append('.').append(n4);
                    if(ip.length() == s.length() + 3) ret.add(ip.toString());
                    ip.delete(0, ip.length());
                }
            }
        }
        return ret;
    } 
}
