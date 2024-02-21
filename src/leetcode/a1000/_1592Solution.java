package leetcode.a1000;
/**
 * 重新排列空格
 * {easy}
 */
public class _1592Solution {

    public String reorderSpaces(String text) {

        int count = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ')
                count++;
        }
        String[] words = text.trim().split(" +");
        int numOfWords = words.length;
        int start = 0;
        if (words[0].equals("")) {
            numOfWords--;
            start = 1;
        }
        StringBuilder sb = new StringBuilder();

        if (numOfWords == 1) {
            sb.append(words[start]);
            for (int i = 0; i < count; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
        int numSpace = count / (numOfWords - 1);
        int end = count % (numOfWords - 1);

        for (int i = start; i < words.length; i++) {

            sb.append(words[i]);
            for (int j = 0; j < numSpace; j++) {
                sb.append(" ");
            }
        }
        sb.setLength(sb.length() - numSpace);
        for (int j = 0; j < end; j++) {
            sb.append(" ");
        }
        return sb.toString();

    }

    public static void main(String[] args) {

        return;
    }
}
