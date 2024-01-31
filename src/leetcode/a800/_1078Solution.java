package leetcode.a800;

import java.util.ArrayList;
import java.util.List;
/**
 * bigram分词
 * {easy}
 */
public class _1078Solution {

    public String[] findOcurrences(String text, String first, String second) {

        String[] words = text.split(" ");
        if (words.length < 3)
            return new String[0];
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length - 2; i++) {
            if (words[i].equals(first) && words[i + 1].equals(second))
                list.add(words[i + 2]);
        }
        return list.toArray(new String[list.size()]);
    }
}
