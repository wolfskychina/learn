package leetcode.a1100;
/**
 * 子字符串的最大连续重复次数
 */
public class _1668Solution {
   
    /**
     * {binary search}
     * @param sequence
     * @param word
     * @return
     */
    public int maxRepeating(String sequence, String word) {

        int r = sequence.length()/word.length()+1;
        int l=0;
        while(l<r){
            int mid = (l+r)/2;
            String tmp = form(mid,word);
            if(sequence.indexOf(tmp)>-1){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        String tmp = form(l-1,word);
        if(sequence.indexOf(tmp)>-1)
            return l-1;
        else 
            return 0;

    }

    private String form(int n,String word){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(word);
        }
        return sb.toString();
    }
}
