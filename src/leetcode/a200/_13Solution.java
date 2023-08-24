package leetcode.a200;

/**
 * 罗马数字转换成整数
 * 从往右转换
 */
public class _13Solution {
   
        public int romanToInt(String s) {
            int strLen = s.length();
            int prevValue = 0;
            int integer = 0;
            
            int i = 0;
            while(i < strLen) {
                char currentChar = s.charAt(i++);
                int currentValue = valueMap(currentChar);
            
                integer += currentValue;
                
                if(prevValue < currentValue)
                    integer -= prevValue * 2;
                
                prevValue = currentValue;
            }
            
            return integer;
        }
        
        static int valueMap(char roman) {
            switch(roman){
                case 'I': return 1;
                case 'V': return 5;
                case 'X': return 10;
                case 'L': return 50;     
                case 'C': return 100;
                case 'D': return 500;   
                case 'M': return 1000;
                default:  return 0;
            }
        }
    
}
