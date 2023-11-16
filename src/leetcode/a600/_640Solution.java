package leetcode.a600;
/**
 * 求解一元一次方程
 */
public class _640Solution {

    /**
     * {char},{string}
     * @param equation
     * @return
     */
    public String solveEquation(String equation) {

        // "x+5-3+x=-6+x-2"
        int i = equation.indexOf("=");
        StringBuilder sb = new StringBuilder();
        sb.append(equation.substring(0, i));
        if (equation.charAt(i + 1) != '-')
            sb.append('-');
        for (int j = i + 1; j < equation.length(); j++) {
            if (equation.charAt(j) == '+') {
                sb.append("-");
            } else if (equation.charAt(j) == '-') {
                sb.append('+');
            } else {
                sb.append(equation.charAt(j));
            }
        }

        String str = sb.toString();
        if (!str.startsWith("-")) {
            str = "+" + str;
        }
        // "x+5-3+x-6+x-2"
        int numX = 0;
        int numNum = 0;
        int idx = 0;
        while (idx < str.length()) {

            int l = idx + 1;
            while (l < str.length() && str.charAt(l) != 'x' && str.charAt(l) != '+' && str.charAt(l) != '-') {
                l++;
            }

            if (l == str.length() || str.charAt(l) != 'x') {
                numNum += Integer.parseInt(str.substring(idx, l));
                idx = l;
            } else {
                if (str.substring(idx, l).equals("+")) {
                    numX += 1;
                } else if (str.substring(idx, l).equals("-")) {
                    numX -= 1;
                } else {
                    numX += Integer.parseInt(str.substring(idx, l));
                }
                idx = l + 1;
            }

        }

        if (numX == 0 && numNum == 0) {
            return "Infinite solutions";
        }
        if (numX == 0 && numNum != 0) {
            return "No solution";
        }
        return "x=" + (-numNum / numX);
    }

    public static void main(String[] args) {

        _640Solution so = new _640Solution();
        so.solveEquation("x+5-3+x=-6+x-2");
    }
}
