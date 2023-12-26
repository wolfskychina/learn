package leetcode.a800;
/**
 * 根据规则将箱子分类
 * {easy}
 */
public class _2525Solution {
   
    public String categorizeBox(int length, int width, int height, int mass) {

        boolean bulky=false ;
        boolean heavy=false;

        if(length>=10000||width>=10000||height>=10000||(long)length*width*height>=1000000000){
            bulky = true;
        }
        if(mass>=100) heavy = true;

        if(bulky&&heavy)
            return "Both";
        if(!bulky&&!heavy)
            return "Neither";
        if(bulky&&!heavy)
            return "Bulky";
        return "Heavy";
    }
}
