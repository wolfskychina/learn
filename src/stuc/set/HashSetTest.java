package stuc.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetTest {
   

    public static void main(String[] args){

        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        set.add(list1);
        System.out.println(list1.hashCode());

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        set.add(list2);
        System.out.println(list2.hashCode());


        System.out.println(set.size());

        
        
    }
}
