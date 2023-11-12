package leetcode.a600;

/**
 * 压缩字符串解码器
 */
public class _604Solution {

    class StringIterator {
        int next = 0;
        int remain = 0;
        char cur;
        int length = 0;
        char[] str;

        public StringIterator(String compressedString) {
            str = compressedString.toCharArray();
            this.length = str.length;
            this.next = 0;
            if (this.length < 2) {
                remain = 0;
            } else {
                cur = str[0];
                int l = 1;
                while (l < length && str[l] >= '0' &&
                        str[l] <= '9') {

                    remain = 10 * remain + (str[l] - '0');
                    l++;
                }
                next = l;

            }
        }

        public char next() {

            char res = cur;
            if (remain != 0)
                remain--;

            if (remain == 0 && next < length) {

                cur = str[next];
                next++;
                int l = next;
                while (l < length && str[l] >= '0' &&
                        str[l] <= '9') {
                    remain = 10 * remain + str[l] - '0';
                    l++;
                }
                next = l;

            } else if (remain == 0) {
                cur = ' ';
            }

            return res;

        }

        public boolean hasNext() {

            if (remain == 0)
                return false;
            return true;

        }
    }

    public static void main(String[] args) {
        _604Solution so = new _604Solution();

        StringIterator inr = so.new StringIterator("L1e2t1C1o1d1e1");

    }
}
