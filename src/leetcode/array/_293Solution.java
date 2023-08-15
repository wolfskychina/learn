package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**\
 * 将字符串中的一组++符号替换成--，所有的替换方式
 */
public class _293Solution {
    /**
     * indexOf比直接CharAt要快
     * @param s
     * @return
     */
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() < 2) return result;
        int idx = 0;
        while(s.indexOf("++", idx) != -1){
            idx = s.indexOf("++", idx);
            String tmp = s.substring(0,idx) + "--" + s.substring(idx + 2);
            result.add(tmp);
            idx++;
        }
        
        return result;
    }

}
