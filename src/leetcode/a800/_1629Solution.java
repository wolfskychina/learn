package leetcode.a800;
/**
 * 按键持续时间最长的键
 * {easy}
 */
public class _1629Solution {
   
    public char slowestKey(int[] releaseTimes, String keysPressed) {

        int longest = 0;
        int longestidx =-1;
        int time[] = new int[26];
        time[keysPressed.charAt(0)-'a'] = releaseTimes[0];
        char[] arr = keysPressed.toCharArray();

        for(int i=1;i<arr.length;i++){

            time[arr[i]-'a'] = Math.max(time[arr[i]-'a'], releaseTimes[i]-releaseTimes[i-1]);
        }

        for(int i=25;i>=0;i--){

            if(time[i]>longest){
                longest = time[i];
                longestidx = i;
            }
                
        }

        return (char)(longestidx+'a');
    }

    public static void main(String[] args){

        _1629Solution so = new _1629Solution();
        int[] retime = {9,29,49,50};
        String pressed = "cbcd";
        so.slowestKey(retime, pressed);
    }
}
