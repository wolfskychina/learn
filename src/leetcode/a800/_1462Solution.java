package leetcode.a800;

import java.util.ArrayList;
import java.util.List;

public class _1462Solution {
  
    /**
     * TODO
     * @param numCourses
     * @param prerequisites
     * @param queries
     * @return
     */
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        int tree[]  = new int [numCourses];
        for(int i=0;i<tree.length;i++){
            tree[i] = i;
        }

        for(int[] pair:prerequisites){
            unionFind(pair[0],pair[1],tree);
        }
        List<Boolean> list = new ArrayList<>();
        
        for(int[] q:queries){
            if(isparent(q[0],q[1],tree)){
                list.add(true);
            }else{
                list.add(false);
            }
        }

        return list;
    }

    private boolean isparent(int i, int j, int[] tree) {
        
        while(tree[j]!=j && tree[j]!=i){
            j = tree[j];
        }
        if(tree[j]==i) return true;
        return false;
    }

    private void unionFind(int i, int j, int[] tree) {
        
        tree[j] =i;
    }
}
