package leetcode.a1000;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 字符串中在字典当中的子串的坐标集合
 * {Trie}
 */
public class _1065Solution {
   
    public int[][] indexPairs(String text, String[] words) {

        List<int[]> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(String str:words){
            set.add(str);
        }
        for(int i=0;i<text.length();i++){
            for(int j=i+1;j<text.length()+1;j++){

                if(set.contains(text.substring(i,j)))
                    list.add(new int[]{i,j-1});
            }
        }
        int [][] res= new int[list.size()][2];
        for(int i=0;i<res.length;i++){
            res[i] = list.get(i);
        }
        return res;
    }


    /**
     * 使用Trie树，不需要处理字符串，更快
     * @param text
     * @param words
     * @return
     */
    public int[][] indexPairs1(String text, String[] words) {
        Trie trie = new Trie();
        for (String t : words) {
            trie.insert(t.toCharArray());
        }
        List<int[]> ans = trie.find(text.toCharArray());

        return ans.toArray(new int[ans.size()][]);
    }
}

class Node {
    Node[] children = new Node[26];
    boolean isEnd = false;
    int length = 0;
}

class Trie {
    private Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(char[] w) {
        Node current = root;
        for (char c : w) {
            int i = c - 'a';
            if (null == current.children[i]) {
                current.children[i] = new Node();
            }
            current = current.children[i];
        }
        current.isEnd = true;
        current.length = w.length;
    }

    private List<int[]> ans;

    public List<int[]> find(char[] text) {
        this.ans = new ArrayList<>();
        for (int i = 0; i < text.length; i++) {
            dfs(i, text, root, i);
        }
        return ans;
    }

    private void dfs(int i, char[] text, Node current, int start) {
        if (null == current) {
            return;
        }
        if (current.isEnd) {
            ans.add(new int[]{i, i + current.length - 1});
        }
        if (start == text.length) {
            return;
        }
        int index = text[start] - 'a';
        dfs(i, text, current.children[index], start + 1);
    }
}
