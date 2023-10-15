package leetcode.a400;
/**
 * 434. Number of Segments in a String
 * 字符串中的字段 
 */
public class _434Solution {
   
    public int countSegments(String s) {
        int sum =0;
        if(s ==null ||s.isEmpty()) return 0;
        int l =0;
        int r =s.length() -1;
        // 需要跳过首尾的空格
        while(l<=s.length()-1 && s.charAt(l) == ' ') l++;
        while(r>=0 && s.charAt(r) == ' ') r--;
        if(l>r) return 0;

        for(int i=l;i<r;i++){
            if(s.charAt(i) == ' ')
            {
                sum++;
                // 跳过连续的空格
                while(i<r && s.charAt(i) == ' ')
                i++;
            }
                
        }
        return sum+1;

    }
}
