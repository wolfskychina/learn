package leetcode.a500;

import java.util.HashMap;
import java.util.Map;
/**
 * 判断给定的四个坐标能否围成一个长方形
 */
public class _593Soltion {
  
    /**
     * 计算6条边的组成情况
     * 注意四个点中有重复点的情况，尤其是两两重复的情况
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     * @return
     */
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        Map<Integer,Integer> map = new HashMap<>();
        int l1 = computeLength(p1,p2);
        int l2 = computeLength(p2,p3);
        int l3 = computeLength(p3,p4);
        int l4 = computeLength(p1,p3);
        int l5 = computeLength(p1,p4);
        int l6 = computeLength(p2,p4);
        if(l1==0||l2==0||l3==0||l4==0||l5==0||l6==0) return false;
        map.put(l1,map.getOrDefault(l1,0)+1);
        map.put(l2,map.getOrDefault(l2,0)+1);
        map.put(l3,map.getOrDefault(l3,0)+1);
        map.put(l4,map.getOrDefault(l4,0)+1);
        map.put(l5,map.getOrDefault(l5,0)+1);
        map.put(l6,map.getOrDefault(l6,0)+1);
        if(map.size()!=2){
            return false;
        }else if(!map.containsValue(2)||!map.containsValue(4)){
            return false;
        }
        return true;
    }

    private int computeLength(int[] a,int[] b){

        return (a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]);
    }
}
