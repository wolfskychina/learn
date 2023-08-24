package leetcode.a300;
/**
 * 定义一个Trie树和常见操作
 */
public class _208Solution {
   
    class Trie {

        public Trie[] e = new Trie[26];
        public Boolean tail = false;
        public char val;
    
        public Trie() {
            this.val = '/';
            
        }
        
        public void insert(String word) {
    
            Trie index=this;
    
            for(char c : word.toCharArray()){
    
                if(index.e[c-'a']!=null){
                    index=index.e[c-'a'];
                    continue;
                }else{
                    index.e[c-'a'] = new Trie();
                    index.e[c-'a'].val = c;
                    index =index.e[c-'a'];
                }   
    
            }   
            index.tail = true;     
        }
        
        public boolean search(String word) {

            char[] arr = word.toCharArray();
            Trie index = this;

            for (char c : arr) {

                if (index.e[c - 'a'] == null) {
                    return false;
                } else {
                    index = index.e[c - 'a'];
                }

            }

            return index.tail;

        }
        
        public boolean startsWith(String prefix) {
            char[] arr = prefix.toCharArray();
            Trie index = this;

            for (char c : arr) {

                if (index.e[c - 'a'] == null) {
                    return false;
                } else {
                    index = index.e[c - 'a'];
                }

            }
            return true;
        }
    }
}
