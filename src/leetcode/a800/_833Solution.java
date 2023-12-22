package leetcode.a800;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 字符串的查找与替换
 */
public class _833Solution {
   
    /**
     * 按照索引进行排序
     * {index sorting}
     * @param s
     * @param indices
     * @param sources
     * @param targets
     * @return
     */
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {

        List<int[]> list = new ArrayList<>();
        List<Integer> idxlist = new ArrayList<>();
        // 专门索引的映射，只排序索引，原数据不排序
        Integer[] map = new Integer[indices.length];
        for(int i=0;i<map.length;i++){
            map[i]=i;
        }
        Arrays.sort(map, (o1,o2)->indices[o1]-indices[o2]);
        
        for(int i=0;i<indices.length;i++){

            int idx = indices[map[i]];
            if(s.startsWith(sources[map[i]], idx)){
                list.add(new int[]{idx,idx+sources[map[i]].length()});
                idxlist.add(map[i]);
            }
        }

        StringBuilder sb = new StringBuilder();

        int l=0;
        int idx = 0;
        for(int[] pair:list){
            sb.append(s.substring(l, pair[0]));
            sb.append(targets[idxlist.get(idx++)]);
            l = pair[1];
        }
        sb.append(s.substring(l));
        return sb.toString();

    }
}
