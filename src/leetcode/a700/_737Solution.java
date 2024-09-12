package leetcode.a700;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 句子的相似性，不同的是这次不同相似的单词组之间存在传递性
 */
public class _737Solution {

    private final Map<String, Integer> idMap = new HashMap<>();
    private int[] parent; // parent[i] 记录并查集中节点 i 的父节点。

    /**
     * {union find} 并查集
     * TODO
     * @param sentence1
     * @param sentence2
     * @param similarPairs
     * @return
     */
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }
        parent = new int[similarPairs.size() << 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }
        for (List<String> pair : similarPairs) {
            union(pair.get(0), pair.get(1));
        }
        for (int i = 0; i < sentence1.length; i++) {
            if (sentence1[i].equals(sentence2[i])) {
                continue;
            }
            if (!isSimilar(sentence1[i], sentence2[i])) {
                return false;
            }
        }
        return true;
    }

    private int generateId(String word) {
        Integer o = idMap.get(word);
        if (o == null) {
            o = idMap.size();
            idMap.put(word, o);
        }
        return o;
    }

    private boolean isSimilar(String word1, String word2) {
        if (word1.equals(word2)) {
            return true;
        }
        Integer id1 = idMap.get(word1);
        Integer id2 = idMap.get(word2);
        if (id1 == null || id2 == null) {
            return false;
        }
        return find(id1) == find(id2);
    }

    // 获取并查集中节点 i 所在集合的代表元。
    private int find(int i) {
        if (parent[i] < 0) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    // 合并并查集中节点 i1 与节点 i2 所在的集合。
    private void union(String word1, String word2) {
        int root1 = find(generateId(word1));
        int root2 = find(generateId(word2));
        if (root1 == root2) {
            return;
        }
        int rank1 = -parent[root1];
        int rank2 = -parent[root2];
        if (rank1 < rank2) {
            parent[root1] = root2;
        } else if (rank1 > rank2) {
            parent[root2] = root1;
        } else {
            parent[root2]--;
            parent[root1] = root2;
        }
    }

}
