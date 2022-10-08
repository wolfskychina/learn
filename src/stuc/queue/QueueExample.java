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
// 这种情况i只在初始化的情况下s1.size()获取一次值，后续不会更新
// for(int i = 0; i<s1.size();i++) <= 此时s1.size（）大小在动态变化

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
