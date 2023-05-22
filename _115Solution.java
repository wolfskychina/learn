import java.util.ArrayList;

public class _115Solution {
   
    public int numDistinct(String s, String t) {
        
        ArrayList<Integer> preIdx= new ArrayList<Integer>();
        
        preIdx.add(-1);
        
        for(int k = 0;k<t.length();k++){
            
            ArrayList<Integer> list = new ArrayList<Integer>();
            
            for(int index : preIdx){
            
                for(int j=index+1;j<s.length();j++){
            
                    if(s.charAt(j)==t.charAt(k)){
                        list.add(j);
                    }
                }
            }
            
            preIdx = list;


        }
        
        return preIdx.size();
    }
}
