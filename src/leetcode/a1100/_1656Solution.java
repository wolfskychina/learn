package leetcode.a1100;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计有序流
 * {easy}
 */
public class _1656Solution {
   
    class OrderedStream {
        String[] arr ;
        int chunked = 1;
        public OrderedStream(int n) {
            arr = new String[1001];
    
        }
        
        public List<String> insert(int idKey, String value) {
            arr[idKey] = value;
            if(idKey == chunked){
    
                List<String> res = new ArrayList<>();
                while(chunked !=arr.length&&arr[chunked]!=null){
                    res.add(arr[chunked++]);
                }
                return res;
            }else{
                return new ArrayList<>();
            }
        }
    }
}
