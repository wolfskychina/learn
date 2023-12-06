package leetcode.a800;
/**
 * 最相似的rbg
 */
public class _800Solution {

    public String similarRGB(String color) {
        return "#" + f(color.substring(1, 3)) + f(color.substring(3, 5)) + f(color.substring(5));
    }

    public String f(String comp) {
        // 按照进制转换字符串到数字
        // TODO
        int q = Integer.parseInt(comp, 16);
        q = q / 17 + (q % 17 > 8 ? 1 : 0);
        return String.format("%02x", 17 * q);
    }

    public static void main(String[] args){
        _800Solution so  = new _800Solution();
        so.similarRGB("1223ff");
    }
}
