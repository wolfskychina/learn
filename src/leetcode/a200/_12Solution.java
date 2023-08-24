package leetcode.a200;

/**
 * 将整形数字转换成罗马字符
 * 除十取余数
 */
public class _12Solution {

        public String intToRoman(int num) {
                         String c[][]={
                    {"","I","II","III","IV","V","VI","VII","VIII","IX"},
                    {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
                    {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
                    {"","M","MM","MMM"}
            };
            String roman = "";
            roman+=c[3][num / 1000 % 10];
            roman+=c[2][num / 100 % 10];
            roman+=c[1][num / 10 % 10];
            roman+=c[0][num % 10];
    
    
            return roman;
        }
}
