package leetcode.a2000;

import java.util.Arrays;

public class _2285Solution {
   
    public long maximumImportance(int n, int[][] roads) {
		long[] map = new long[n];//map[i] 表示第i少条路的城市有多少条路（后面的排序后表示的意思）
		for (int i = 0; i < roads.length; i++) {
			map[roads[i][0]]++;
			map[roads[i][1]]++;
		}
		int num=1;//城市数值 
		Arrays.sort(map);//将这些城市按有道路数从小到大排序
		long ans = 0L;
		for (int i = 0; i < map.length; i++) {
			ans+=map[i]*num;//道路重要性之和为==》   城市数值 *城市的道路数  
			num++;
		}
		return ans;
	}

}
