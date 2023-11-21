package leetcode.a600;

import java.util.LinkedList;
import java.util.List;
/**
 * 奇怪的棒球计分
 * {easy}
 */
public class _682Solution {

    public int calPoints(String[] operations) {

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < operations.length; i++) {

            switch (operations[i]) {
                case "+":
                    int sum = list.get(list.size() - 1) + list.get(list.size() - 2);
                    list.add(sum);
                    break;
                case "D":
                    list.add(list.get(list.size() - 1) * 2);
                    break;
                case "C":
                    list.remove(list.size() - 1);
                    break;
                default:
                    list.add(Integer.parseInt(operations[i]));
            }
        }
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;

    }
}
