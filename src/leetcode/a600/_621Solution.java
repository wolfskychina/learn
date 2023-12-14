package leetcode.a600;

import java.util.Arrays;
import java.util.Collections;
/**
 * CPU调度一个任务数组，想同类型的任务必须间隔n时间片后才能调度
 * 问最少需要多少时间才能执行完所有的任务
 */
public class _621Solution {

    /**
     * https://leetcode.cn/problems/task-scheduler/solutions/196302/tong-zi-by-popopop/
     * {greedy}桶思想，容量为n+1的桶，当桶放满时，可以逐渐增加桶的容量，保证原来相同任务的时间片的
     * 差值仍然是大于n，同时不增加空白的时间片间隙，末尾的时间片也不增长
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        // 可以不用排序，只找出相同任务最多的任务类型的数量即可
        int[] temp = new int[26];
        int countMaxTask = 0;
        int maxTask = 0;
        for (char c : tasks) {
            temp[c - 'A']++;
            maxTask = Math.max(temp[c - 'A'], maxTask);
        }
        for (int i = 0; i < 26; i++) {
            if (temp[i] == maxTask) {
                countMaxTask++;
            }
        }
        return Math.max(tasks.length, (maxTask - 1) * (n + 1) + countMaxTask);
    }

    public int leastInterval1(char[] tasks, int n) {

        int len = tasks.length;
        Integer[] vec = new Integer[26];
        Arrays.fill(vec, 0);
        for (char c : tasks)
            ++vec[c - 'A'];
        Arrays.sort(vec, Collections.reverseOrder());
        int cnt = 1;
        // TODO 注意这个地方不能用vec[cnt] == vec[0]来比较
        // 因为数组存储的是Integer对象，==比较的是地址
        while (cnt < vec.length && Integer.compare(vec[cnt],vec[0])==0)
            cnt++;

        return Math.max(len, cnt + (n + 1) * (vec[0] - 1));
    }
}
