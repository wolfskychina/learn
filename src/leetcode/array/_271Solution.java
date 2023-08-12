package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一组字符串编码，然后用另一个方法解码
 */
public class _271Solution {

    //public Codec codec = new Codec();

    public static class Codec {
        public static String encode(List<String> strs) {
            StringBuilder out = new StringBuilder();
            for (String s : strs)
                out.append(s.replace("#", "##")).append(" # ");
            return out.toString();
        }

        public static List<String> decode(String s) {
            List<String> strs = new ArrayList<>();
            //String[] array = s.split(" # ");
            String[] array = s.split(" # ", -1);
            // 注意i循环次数，对于最后一个空字符串，不处理
            for (int i=0; i<array.length-1; ++i)
                strs.add(array[i].replace("##", "#"));
            return strs;
        }
    }

    public static void main(String[] args){

        List<String> list  = new ArrayList<>();
        list.add("111");
        list.add("   ");
        list.add("###  # # ");
        list.add(" ");
        String s = Codec.encode(list);
        for(String str : Codec.decode(s)){
            System.out.println(str);
        }

    }

}
