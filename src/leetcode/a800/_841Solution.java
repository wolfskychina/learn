package leetcode.a800;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 钥匙和房间
 * 每个房间有N把配套的钥匙N为（0-i），这些钥匙可能分布在不同的房间
 * 除了0号房间，其他房间开始都是锁住的
 * 问从0号房间开始，能否打开所有房间的门
 */
public class _841Solution {
   
    /**
     * {queue}
     * @param rooms
     * @return
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean opened [] = new boolean[rooms.size()];
        opened[0] = true;
        Queue<Integer> q = new LinkedList<>();
        for(Integer i: rooms.get(0)){
            if(!opened[i]){
                opened[i] = true;
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int key = q.poll();
            for(Integer i:rooms.get(key)){
                if(!opened[i]){
                    opened[i] = true;
                    q.offer(i);
                }
               
            }
        }
        for(boolean open:opened){
            if(!open) return false;
        }
        return true;
        
    }
}
