package leetcode.a1000;

import java.util.List;
/**
 * 统计匹配的规则的物品数量
 * {easy}
 */
public class _1773Solution {
   
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count=0;
        int idx =0;
        switch (ruleKey) {
            case "type":
                idx=0;
                break;
            case "color":
                idx=1;
                break;
            default:
                idx=2;
                break;
        }
        for(List<String> item:items){

            if(item.get(idx).equals(ruleValue))
                count++;
            
        }
        return count;
    }
}
