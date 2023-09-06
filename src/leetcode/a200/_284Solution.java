package leetcode.a200;

import java.util.Iterator;

/**
 * 传统迭代器改进，增加获取下一个值但是指针不动的操作
 */
public class _284Solution {

    /**
     * 使用一个额外存储，提前保存next值
     * 相当于缓存预取的思想，提前取出一个来
     */
    class PeekingIterator implements Iterator<Integer> {
        private Iterator<Integer> iterator;
        private Integer nextElement;

        public PeekingIterator(Iterator<Integer> iterator) {
            this.iterator = iterator;
            nextElement = iterator.next();
        }

        public Integer peek() {
            return nextElement;
        }

        @Override
        public Integer next() {
            Integer ret = nextElement;
            nextElement = iterator.hasNext() ? iterator.next() : null;
            return ret;
        }

        @Override
        public boolean hasNext() {
            return nextElement != null;
        }
    }
}
