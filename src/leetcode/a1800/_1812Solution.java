package leetcode.a1800;
/**
 * 国际象棋的格子的颜色
 */
public class _1812Solution {
   
    public boolean squareIsWhite(String coordinates) { // 白色用0表示，黑色用1表示
        int letter = (coordinates.charAt(0) - 'a') % 2;     // a列:白色 b列:黑色 c列:白色 ……
        int number = (coordinates.charAt(1) - '1' + 1) % 2; // 1行:黑色 2行:白色 3行:黑色 ……
        return (letter ^ number) == 0; 
    }
}
