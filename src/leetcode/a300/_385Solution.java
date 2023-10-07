package leetcode.a300;

import leetcode.util.NestedInteger;
import leetcode.util.NestedIntegerMock;
/**
 * 将一个字符串表示的嵌套列表
 * 还原为对象引用
 */
public class _385Solution {
   
        int index = 0;
    
        /**
         * 递归，深度优先遍历
         * @param s
         * @return
         */
        public NestedInteger deserialize(String s) {
            if (s.charAt(index) == '[') {
                // index是全局共享的，标记处理到的位置
                index++;
                NestedInteger ni = new NestedIntegerMock();
                while (s.charAt(index) != ']') {
                    ni.add(deserialize(s));
                    if (s.charAt(index) == ',') {
                        index++;
                    }
                }
                index++;
                return ni;
            } else {
                boolean negative = false;
                if (s.charAt(index) == '-') {
                    negative = true;
                    index++;
                }
                int num = 0;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    num = num * 10 + s.charAt(index) - '0';
                    index++;
                }
                if (negative) {
                    num *= -1;
                }
                return new NestedIntegerMock(num);
            }
        }

}
