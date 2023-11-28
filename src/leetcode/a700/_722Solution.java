
package leetcode.a700;

import java.util.ArrayList;
import java.util.List;
/**
 * 删除语句中的注释
 */
public class _722Solution {

    /**
     * 自动机的构造，单个字符处理，使用是否在注释中标记当前状态
     * 开始打算用substring做，但是对于同一行中有多个注释块的时候不好处理
     * TODO {}
     * @param source
     * @return
     */
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<String>();
        StringBuilder newLine = new StringBuilder();
        boolean inBlock = false;
        for (String line : source) {
            for (int i = 0; i < line.length(); i++) {
                if (inBlock) {
                    if (i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                        inBlock = false;
                        i++;
                    }
                } else {
                    if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                        inBlock = true;
                        i++;
                    } else if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                        break;
                    } else {
                        // 逐个字符处理
                        newLine.append(line.charAt(i));
                    }
                }
            }


            if (!inBlock && newLine.length() > 0) {
                res.add(newLine.toString());
                newLine.setLength(0);
            }
        }
        return res;

    }
}
