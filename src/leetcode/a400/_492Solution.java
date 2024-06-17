package leetcode.a400;
/**
 * 对于一个面积area，返回长宽最接近的矩形的长宽
 * {easy}
 */
public class _492Solution {

    /**
     * 从平方处开始搜索
     * 注意 2*2=4 的情况，从平方根往下找可以保证不会少数
     * @param area
     * @return
     */
    public int[] constructRectangle(int area) {

        int i = (int)Math.sqrt(area);
        for(;i!=0;i--){
            if(area%i == 0) break;
        }
        int[] res = {area/i,i};
        return res;

    }
}
