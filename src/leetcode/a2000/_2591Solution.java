package leetcode.a2000;
/**
 * 将钱分给所有儿童
 * 要求每个儿童至少有一块钱，不能有儿童恰好有4块钱
 * 问恰好有8块钱的儿童的最大可能数量，如果无法有符合前两条规则的分配
 * 返回-1
 */
public class _2591Solution {
   
    /**
     * 分类讨论，注意边界条件
     * @param money
     * @param children
     * @return
     */
    public int distMoney(int money, int children) {

        if(money<children) return -1;
        int most8 = (money-children)/7;
        int remain = (money-children)%7;
        // 只有children==1，most8=0，remain==3的情况下才能无法分配
        if(most8==children-1&&remain==3) return most8==0?-1:most8-1;
        if(most8<=children-1) return most8;
        if(most8==children&&remain==0) return most8;
        if(most8>=children) return children-1;
        return -1;

    }
}
