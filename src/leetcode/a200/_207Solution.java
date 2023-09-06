package leetcode.a200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 根据课程的先修关系，判断给出的课程能否修完
 * 实际上是判断有向图里面是否有回路
 * 拓扑排序，发现（入队列）的节点数是否等于图中所有节点数，
 * 如果发现（入队列）的节点数多于图中的节点数，则有回路
 */
public class _207Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count =0;

        int[] inDegree = new int[numCourses];

        List[] neighbor = new ArrayList[numCourses];
        for(int i=0;i<neighbor.length;i++){
            neighbor[i] = new ArrayList<Integer>();
        }

        Queue<Integer> queue = new LinkedList<Integer>();

        for(int i=0 ;i< prerequisites.length; i++){

            inDegree[prerequisites[i][1]]++;
            neighbor[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        for(int i=0; i<inDegree.length;i++){
            if(inDegree[i] == 0){
                queue.add(i);
                count++;
            }
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int i=0; i< neighbor[node].size();i++){

                int index = (int)neighbor[node].get(i);
                inDegree[index]--;
                if(inDegree[index] ==0 ){
                    queue.add(index);
                    count++;
                }
            }
        }

        return count==numCourses?true:false;


    }
}
