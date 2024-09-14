package leetcode.a2000;

/**
 * 从左侧往右浇花，水量不够需要回0点打水
 * 问需要多少步可以浇完所有的花
 */
public class _2079Solution {
   
    class Solution {
        public int wateringPlants(int[] plants, int capacity) {
            int n = plants.length;
            int ans = n;
            int water = capacity;
            for (int i = 0; i < n; i++) {
                if (water < plants[i]) {
                    ans += i * 2;
                    water = capacity;
                }
                water -= plants[i];
            }
            return ans;
        }
    }
    
}
