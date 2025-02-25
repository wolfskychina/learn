package leetcode.a2000;

import java.util.Arrays;

/**
 * 设计内存分配器
 * {design}
 */
public class _2502Solution {

    class Allocator {
        private final int[] memory;

        public Allocator(int n) {
            memory = new int[n];
        }

        public int allocate(int size, int mID) {
            int free = 0;
            // 一次遍历找到能够分配的区块，比while的写法简洁
            // 只在一个地方进行i的递增
            for (int i = 0; i < memory.length; i++) {
                if (memory[i] > 0) { // 已分配
                    free = 0; // 重新计数
                    continue;
                }
                free++;
                if (free == size) { // 找到了
                    Arrays.fill(memory, i - size + 1, i + 1, mID);
                    return i - size + 1;
                }
            }
            return -1; // 无法分配内存
        }

        public int freeMemory(int mID) {
            int ans = 0;
            for (int i = 0; i < memory.length; i++) {
                if (memory[i] == mID) {
                    ans++;
                    memory[i] = 0; // 标记为空闲内存
                }
            }
            return ans;
        }
    }
}
