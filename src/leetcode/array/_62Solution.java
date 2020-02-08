package leetcode.array;

public class _62Solution {

    public int uniquePaths(int m, int n) {

        m--;
        n--;

        if(n>m){
            int tmp = n;
            n = m;
            m = tmp;
        }
        long mul =1;
        long fact = 1;

        for(int i=0;i<n;i++){
            mul *= (m+n-i);
            fact *=i+1;
        }

        return (int)(mul/fact);

    }

    public static void main(String[] args){
        _62Solution so = new _62Solution();
        so.uniquePaths(7,3);
    }
}
