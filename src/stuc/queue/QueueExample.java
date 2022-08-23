package stuc.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

    public static void main(String[] args) {


        Queue<String> s1 = new LinkedList<>();

        // Queue的操作  offer是入队
        s1.offer("111");
        s1.offer("222");
        s1.offer("333");

        for(int i = s1.size();i>0;i--){
// 说明s1.size()是一次获取值，后续不会更新


            s1.offer(s1.peek()+"a");
            s1.offer(s1.peek()+"b");
            s1.offer(s1.peek()+"c");
            // Queue的操作，poll是出队
            s1.poll();
        }

        System.out.println(s1.size());

        for(String e:s1){
            System.out.println(e);
        }


    }
}
