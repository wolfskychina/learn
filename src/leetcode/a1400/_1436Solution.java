package leetcode.a1400;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 旅行终点站
 * {easy}
 */
public class _1436Solution {
   
    public String destCity(List<List<String>> paths) {

        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();
        for(List<String> path:paths){
            start.add(path.get(0));
            end.add(path.get(1));
        }
        for(String str:end){

            if(!start.contains(str))
                return str;
        }
        return "";
    }
}
