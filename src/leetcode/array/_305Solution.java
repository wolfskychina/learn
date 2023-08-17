package leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
/**
 * 每次往一个网格里面填一个空，求每一步填完之后岛屿的数目
 */
public class _305Solution {
   
    int[][] a = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {

        Queue<Set<String>> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<positions.length;i++){

            int size = q.size();
            List<Set<String>> list = new ArrayList<>();
            for(int j = 0;j<size;j++){
                Set<String> set = q.poll();
                if(mergeable(set,positions[i],m,n)){
                    list.add(set);
                }
            }
            
            Set<String> set2 = merge(list);
            set2.add(positions[i][0]+":"+positions[i][1]);
            q.offer(set2);
            res.add(q.size());
        }

        return res;

    }

    private boolean mergeable(Set<String> set, int[] p,int m, int n){

        for(int i =0;i<4;i++){
            int xn = p[0] + a[i][0];
            int yn = p[1] + a[i][1];
            if(xn<0||xn>=m||yn<0||yn>=n) continue;

            if(set.contains(xn+":"+yn)) return true;
        }

        return false;
    }

    private Set<String> merge(List<Set<String>> list){

        Set<String> res = new HashSet<>();
        for(Set<String> set: list){

            res.addAll(set);
        }
        return res;
    } 
}
