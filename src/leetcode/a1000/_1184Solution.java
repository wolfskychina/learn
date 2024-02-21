package leetcode.a1000;
/**
 * 环形公交线中两个特定站点之间的最短距离
 * {easy}
 */
public class _1184Solution {
   
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {

        int sum = 0;
        for(int i:distance){
            sum+=i;
        }
        if(start>destination) {
            int tmp = start;
            start = destination;
            destination = tmp;
        }
        int oneway = 0;
        for(int i=start;i<destination;i++){
            oneway += distance[i];
        }
        return oneway>sum-oneway?sum-oneway:oneway;
    }
}
