package leetcode.a400;

import java.util.ArrayList;
import java.util.List;
/**
 * EAZY
 */
public class _412Solution {

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {

            if (i % 15 == 0) {
                res.add("FizzBuzz");
                continue;

            } else if (i % 3 == 0) {
                res.add("Fizz");
                continue;
            } else if (i % 5 == 0) {
                res.add("Buzz");
                continue;
            } else {
                res.add(String.valueOf(i));
            }
        }

        return res;
    }
}
