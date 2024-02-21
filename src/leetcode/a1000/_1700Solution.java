package leetcode.a1000;
/**
 * 无法吃午餐的学生数量
 * 两种三明治按照一定顺序提供，学生排队选喜欢的一种，如果不满意就到后面重新排队
 * 如果当前提供的三明治没有队伍中的学生喜欢则终止供餐
 * {stack}
 */
public class _1700Solution {
   
    public int countStudents(int[] students, int[] sandwiches) {
        int num0 = 0;
        int num1 =0;
        for(int i:students){
            if(i==0)
                num0++;
            else   
                num1++;
        }
        for(int i=0;i<sandwiches.length;i++){

            if(sandwiches[i]==0){
                if(num0==0)
                    return sandwiches.length-i;
                else    
                    num0--;
            }else{
                if(num1==0)
                    return sandwiches.length-i;
                else 
                    num1--;
            }
        }
        return 0;

    }
}
