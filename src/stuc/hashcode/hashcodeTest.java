package stuc.hashcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class hashcodeTest {

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list2.add(1);
        list2.add(2);
        System.out.println("if list1 equals list2: " + list1.equals(list2));
        System.out.println(
                "if the hashcode of the two lists are the same: " + list1.hashCode() + "vs" + list2.hashCode());

        Map<List<Integer>, Integer> map = new HashMap<>();
        map.put(list1,1);
        list1.add(3);
        map.put(list1,2);
        System.out.println("the new hashcode of list1 is: "+list1.hashCode());
        // how many elements in the map?
        System.out.println("the size of the map is: "+ map.size());
        // size is 2 because the hashcode of list1 were changed
        for(List<Integer> list:map.keySet()){
            System.out.println("the hashcode of this list is : " + list.hashCode());
        }
        

    }
}
