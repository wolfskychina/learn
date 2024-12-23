package leetcode.a2000;

/**
 * 字符串的前缀score和
 * {trie},{prefix sum}
 */
public class _2416Solution {

    public int[] sumPrefixScores(String[] words) {
        
        Trie p = new Trie();
        for(String word:words){
            p.insert(word);
        }
        int res[] = new int[words.length];
        for(int i=0;i<res.length;i++){

            res[i]+=p.count(words[i]);
        }

        return res;
    }

    class Trie{

        int num;
        Trie[] next;

        public Trie(){
            num=1;
            next = new Trie[26];
        }

        public void insert(String s){
            Trie p = this;
            for(char c:s.toCharArray()){
                if(p.next[c-'a']!=null){
                    p.next[c-'a'].num++;
                    p=p.next[c-'a'];
                }else{
                    Trie tree  = new Trie();
                    p.next[c-'a']=tree;
                    p = p.next[c-'a'];
                }
            }
        }

        public int count(String s){
            Trie p  = this;
            int count=0;
            for(char c:s.toCharArray()){

                count += p.next[c-'a'].num;
                p = p.next[c-'a'];
                
            }
            return count;
        }
    }
}
