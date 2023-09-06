package leetcode.a200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 输出选课的顺序，依赖关系是反着的
 * 需要同时判断是否有回路
 */
public class _210Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int count = 0;
        // 构建入度数组
        int[] inDegree = new int[numCourses];
        for(int[] row : prerequisites){
            inDegree[row[0]] ++;
        }

        // 构建邻接列表
        List[] neighber = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            neighber[i] = new ArrayList<Integer>();   
        }
        for(int i=0; i<prerequisites.length;i++){

            neighber[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList<Integer>();

        // 将入度为0的数组入列
        for(int i =0; i<numCourses; i++){
            if(inDegree[i] == 0) 
            {
                queue.add(i);
                count++;
            }
        }

        ArrayList<Integer> res =new ArrayList<>();

        // 遍历队列，发现入度为0的数组就入列
        // 对每个出列的节点扫描邻接列表，列表中节点的入度-1，如果降到零就入列
        while(!queue.isEmpty()){

            Integer node = queue.poll();
            res.add(node);

            for(int i = 0; i< neighber[node].size();i++) {
                
                int n = (int)neighber[node].get(i);
                inDegree[n]--;
                if(inDegree[n] == 0){
                    count ++;
                    queue.add(n);
                }

            }

        }

        return count == numCourses? res.stream().mapToInt(Integer::intValue).toArray():new int[0];
        
    } 
}
