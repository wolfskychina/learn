package leetcode.a300;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.Map.Entry;

import leetcode.util.TreeNode;

/**
 * 二叉树序列化与反序列化
 * TODO
 */
public class _297Solution {

    public Codec codec = new Codec();
    public Codec2 codec2= new Codec2();
   
    public class Codec {

        // Encodes a tree to a single string.
        /**
         * 使用层次遍历二叉树，生成序列
         * @param root
         * @return
         */
        public String serialize(TreeNode root) {

            // 层次遍历二叉树，层中有null的节点也需要记录下来
            Map<Integer,Integer> map = new HashMap<>();
            firstRoot(root,map,1);
            StringBuilder sb = new StringBuilder();
            for(Entry<Integer,Integer> en:map.entrySet()){

                sb.append(en.getKey().toString());
                sb.append(":");
                sb.append(en.getValue().toString());
                sb.append(" ");
                
            }
            if(sb.length()!=0) sb.setLength(sb.length()-1); 

            return sb.toString();
            
        }
    
        private void firstRoot(TreeNode root, Map<Integer, Integer> map, int i) {

            if(root==null) return;
            map.put(i,root.val);
            firstRoot(root.left,map,2*i);
            firstRoot(root.right,map,2*i+1);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.equals("")) return null;
           String[] enList = data.split(" ");
           Map<Integer,Integer> map = new HashMap<>();
           for(String s:enList){
                String[] en = s.split(":");
                map.put(Integer.valueOf(en[0]),Integer.valueOf(en[1]));
           } 
           // rebuild the tree
           TreeNode root =buildTree(map,1);
           return root;
            
        }

        private TreeNode buildTree(Map<Integer, Integer> map, int i) {
            if(!map.containsKey(i)) return null;

            TreeNode root = new TreeNode(map.get(i));
            root.left = buildTree(map,2*i);
            root.right = buildTree(map,2*i+1);

            return root;
        }
    }

    /**
     * 改成迭代方式，但是超时
     */
    public class Codec2 {

        // Encodes a tree to a single string.
        /**
         * @param root
         * @return
         */
        public String serialize(TreeNode root) {

            Map<Integer,Integer> map = new HashMap<>();
            firstRoot(root,map);
            StringBuilder sb = new StringBuilder();
            for(Entry<Integer,Integer> en:map.entrySet()){

                sb.append(en.getKey().toString());
                sb.append(":");
                sb.append(en.getValue().toString());
                sb.append(" ");
                
            }
            if(sb.length()!=0) sb.setLength(sb.length()-1); 

            return sb.toString();
            
        }
    
        /**
         * 因为递归测试爆栈了，所以需要改成迭代遍历
         * @param root
         * @param map
         * @param i
         */
        private void firstRoot(TreeNode root, Map<Integer, Integer> map) {

            if(root==null) return;
            Stack<Integer> keyStack = new Stack<>();
            Stack<TreeNode> nStack = new Stack<>();
            nStack.push(root);
            keyStack.push(1);
            while(!nStack.isEmpty()){
                TreeNode node = nStack.pop();
                int key = keyStack.pop();
                map.put(key,node.val);
                if(node.right!=null){
                    keyStack.push(2*key+1);
                    nStack.push(node.right);
                }
                if(node.left!=null){
                    keyStack.push(2*key);
                    nStack.push(node.left);
                }
            }
            
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.equals("")) return null;
           String[] enList = data.split(" ");
           Map<Integer,Integer> map = new HashMap<>();
           for(String s:enList){
                String[] en = s.split(":");
                map.put(Integer.valueOf(en[0]),Integer.valueOf(en[1]));
           } 
           // rebuild the tree
           TreeNode root =buildTree(map);
           return root;
            
        }

        /**
         * 改成迭代方法构建树
         */
        private TreeNode buildTree(Map<Integer, Integer> map) {
            if(!map.containsKey(1)) return null;

            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(map.get(1));
            Queue<Integer> iq = new LinkedList<>();
            queue.offer(root);
            iq.offer(1);
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                int i = iq.poll();
                if(map.containsKey(2*i)){
                    iq.offer(2*i);
                    TreeNode n1 = new TreeNode(map.get(2*i));
                    node.left = n1;
                    queue.offer(n1);
                }
                if(map.containsKey(2*i+1)){
                    iq.offer(2*i+1);
                    TreeNode n2 = new TreeNode(map.get(2*i+1));
                    node.right =n2;
                    queue.offer(n2);
                }
            }

            return root;
        }

        public TreeNode rdeserialize(List<String> dataList) {
            if (dataList.get(0).equals("NONE")) {
                dataList.remove(0);
                return null;
            }
      
            TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
            dataList.remove(0);
            root.left = rdeserialize(dataList);
            root.right = rdeserialize(dataList);
        
            return root;
        }
    
    }

    public static void main(String[] args){

        _297Solution s = new _297Solution();
        Codec2 co = s.codec2;
        String[] dataArray = {"1","2","3","NONE","NONE","NONE","NONE"};
        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));

        TreeNode no = co.rdeserialize(dataList);

        // [1,2,3,null,null,4,5]
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        n3.left = n4;
        n3.right = n5;
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;

        _297Solution so =new _297Solution();
        Codec codec =  so.codec;
        String str = codec.serialize(null);
        n1 = codec.deserialize(str);



    }
}
