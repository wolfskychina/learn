package leetcode.a800;
/**
 * 柠檬水找零问题
 * {easy},{greedy}
 */
public class _860Solution {
   
    public boolean lemonadeChange(int[] bills) {

        int remain5 =0;
        int remain10 =0;
        for(int get:bills){
            if(get==5){
                remain5++;
            }else if(get ==10){
                if(remain5==0)
                    return false;
                remain10++;
                remain5--;
            }else{
                //get ==20
                if(remain10!=0 && remain5!=0){
                    remain10--;
                    remain5--;
                }else if(remain5>=3){
                    remain5-=3;
                }else{
                    return false;
                }
                
            }
        }
        return true;
    }
}
