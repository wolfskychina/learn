package leetcode.a700;

import java.util.ArrayList;
import java.util.List;
/**
 * 从起始ip开始分配n个ip地址，这n个ip地址是连续的
 * 分配结果用cidr地址块的形式展现，要求使用的cidr地址块最少
 */
public class _751Solution {

    /**
     * 因为起始ip固定，需要的ip地址连续，所以要分配的具体地址清单是明确的
     * 只是尽可能的将单个的ip地址合并成为区块
     * 每个区块的起始区块后面都应该是i个0（其中i可能为0）
     * 能够分配的最大数量是最后面的连续0的位数
     * {bit manipulation}
     * @param ip
     * @param n
     * @return
     */
    public List<String> ipToCIDR(String ip, int n) {
        int start = toInt(ip);// 将ip转化为整数
        List<String> ans = new ArrayList<>();
        while (n > 0) {
            int trailingZeros = Integer.numberOfTrailingZeros(start);
            // System.out.println(trailingZeros);
            int mask = 0, bitsInCIDR = 1;
            // 计算mask
            while (bitsInCIDR < n && mask < trailingZeros) {
                bitsInCIDR <<= 1;
                mask++;
            }
            if (bitsInCIDR > n) {
                bitsInCIDR >>= 1;
                mask--;
            }

            ans.add(toString(start, 32 - mask));
            // 本次cidr能够包含的最多的不同ip
            n -= bitsInCIDR;
            // 下一次cidr开始时的ip地址
            start += (bitsInCIDR);
        }
        return ans;
    }

    private String toString(int number, int range) {
        final int WORD_SIZE = 8;
        StringBuilder buffer = new StringBuilder();
        for (int i = 3; i >= 0; --i) {
            buffer.append(((number >> (i * WORD_SIZE)) & 255));
            buffer.append(".");
        }
        buffer.setLength(buffer.length() - 1);
        buffer.append("/").append(range);
        return buffer.toString();
    }

    private int toInt(String ip) {
        String[] strs = ip.split("\\.");
        int sum = 0;
        for (String str : strs) {
            sum *= 256;
            sum += Integer.parseInt(str);
        }
        return sum;
    }

}
