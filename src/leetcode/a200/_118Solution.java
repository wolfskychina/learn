package leetcode.a200;

import java.util.ArrayList;
import java.util.List;

/**
 * 帕斯卡三角形
 */
public class _118Solution {
   
    
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> res =new ArrayList<List<Integer>>();
        
        if(numRows<=0) return res;
        
        List<Integer> ini = new ArrayList<Integer>();
        ini.add(1);
        res.add(ini);
        
        for(int i=1;i<numRows;i++){
            
            List<Integer> list = new ArrayList<Integer>(res.get(res.size()-1));
            // 在队列前端增加元素的时间复杂度是on，有没有其他更好的方法？
            list.add(0,1);
            for(int j=1;j<list.size()-1;j++){
                list.set(j, list.get(j)+list.get(j+1));
            }
            res.add(list);
        }
        
        return res;
    }
}
