package leetcode.a600;

import java.util.LinkedList;
import java.util.List;
/**
 * 统计所有函数各自累计消耗的cpu时间
 */
public class _636Solution {

    int idx = 0;

    // 0:start:2
    /**
     * 使用递归模拟出栈入栈
     * 注意相同的函数可能递归调用，并且可能重复执行
     * 最外层的循环需要保证将logs遍历完
     * {recursive}
     *  */ 
    public int[] exclusiveTime(int n, List<String> logs) {

        int res[] = new int[n];

        while (idx < logs.size()) {
            traverseLogs(logs, res);
        }

        return res;

    }

    public int traverseLogs(List<String> logs, int[] res) {

        String[] array = logs.get(idx).split(":");
        int id = Integer.parseInt(array[0]);
        int timestamp = Integer.parseInt(array[2]);
        int subTime = 0;
        idx++;
        while (idx < logs.size() && !(Integer.parseInt(logs.get(idx).split(":")[0]) == id &&
                logs.get(idx).split(":")[1].equals("end"))) {

            subTime += traverseLogs(logs, res);
        }
        int endTime = Integer.parseInt(logs.get(idx).split(":")[2]);
        int costTime = endTime - timestamp + 1 - subTime;
        res[id] += costTime;
        idx++;
        return endTime-timestamp+1;

    }

    public static void main(String[] args){
        _636Solution so = new _636Solution();
        List<String> logs = new LinkedList<>();
        logs.add("0:start:0");
        logs.add("0:start:1");
        logs.add("0:start:2");
        logs.add("0:end:3");
        logs.add("0:end:4");
        logs.add("0:end:5"); 
        so.exclusiveTime(1,logs);
    }

}
