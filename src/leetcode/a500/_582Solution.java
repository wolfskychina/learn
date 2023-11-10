package leetcode.a500;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 杀进程，给定一个进程表和进程父子关系表，要杀掉一个进程，返回所有需要被
 * 一同杀掉的进程
 */
public class _582Solution {

    /**
     * 超时的解，队列中的每一个元素都需要遍历一遍ppid
     * {queue},{hashmap},{bfs}
     */
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

        List<Integer> res = new LinkedList<>();
        // res.add(kill);

        Queue<Integer> q = new LinkedList<>();
        q.add(kill);
        while (!q.isEmpty()) {
            int cur = q.poll();
            res.add(cur);
            for (int i = 0; i < ppid.size(); i++) {
                if (ppid.get(i) == cur) {
                    q.offer(pid.get(i));
                }
            }
        }
        return res;

    }

    /**
     * 对上一种方法的改进,使用map保存ppid使得每次的遍历时间缩短为o1
     * 通过
     */
    public List<Integer> killProcess1(List<Integer> pid, List<Integer> ppid, int kill) {

        List<Integer> res = new LinkedList<>();
        // res.add(kill);
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<ppid.size();i++){

            List<Integer> list = map.getOrDefault(ppid.get(i), new LinkedList<>());
            list.add(i);
            map.put(ppid.get(i),list);
            
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(kill);
        while(!q.isEmpty()){
            int cur = q.poll();
            res.add(cur);
            if(map.containsKey(cur)){
                List<Integer> m = map.get(cur);
                for(Integer i:m){
                    q.offer(i);
                }
            }
        }
        return res;

    }
}
