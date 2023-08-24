package leetcode.a200;

import java.util.List;

public class _120Solution {

    public int minimumTotal(List<List<Integer>> triangle) {

        int[][] m = new int[triangle.size()][triangle.get(triangle.size()-1).size()];


        m[0][0] = triangle.get(0).get(0);

        if(m.length ==1) return m[0][0];

        for(int i=1;i<m.length;i++){
            m[i][0] = m[i-1][0]+triangle.get(i).get(0);
            m[i][m[i].length-1] = m[i-1][m[i-1].length-1]+triangle.get(i).get(m[i].length-1);
        }


        for(int i=1;i<m.length;i++){
            for(int j=1;j<m[i].length-1;j++){

                m[i][j] = triangle.get(i).get(j)+Math.min(m[i-1][j-1],m[i-1][j]);
            }
        }

        int min = m[m.length-1][0];
        for(int j=1;j<m[m.length-1].length;j++){

            if(min>m[m.length-1][j]){
                min = m[m.length-1][j];
            }
        }

        return min;
    }

    // 使用一维数组代替二维数组，注意遍历方向变化
    public int minimumTotal2(List<List<Integer>> triangle) {

        int[] m = new int[triangle.get(triangle.size()-1).size()];

        m[0] = triangle.get(0).get(0);

        if(m.length ==1) return m[0];

        for(int i=1;i<m.length;i++){

            m[triangle.get(i).size()-1] = m[triangle.get(i-1).size()-1]+triangle.get(i).get(triangle.get(i).size()-1);
            
            for(int j=triangle.get(i).size()-2;j>=1;j--){

                m[j] = triangle.get(i).get(j)+Math.min(m[j-1],m[j]);
            }

            m[0] = m[0]+triangle.get(i).get(0);
        }

        int min = m[0];
        for(int j=1;j<m.length;j++){

            if(min>m[j]){
                min = m[j];
            }
        }

        return min;
    }
}
