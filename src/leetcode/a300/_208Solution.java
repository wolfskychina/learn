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
    
            for(int i =0; i<arr.length; i++){
    
                if(index.e[arr[i]-'a'] == null){
                    return false;
                }else{
                    index = index.e[arr[i]-'a'];
                }
                
            }
    
            return index.tail?true:false;
            
        }
        
        public boolean startsWith(String prefix) {
            char[] arr = prefix.toCharArray();
            Trie index = this;
    
            for(int i =0; i<arr.length; i++){
    
                if(index.e[arr[i]-'a'] == null){
                    return false;
                }else{
                    index = index.e[arr[i]-'a'];
                }
                
            }
            return true;
        }
    }
    
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
}
