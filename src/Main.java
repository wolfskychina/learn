import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {


        Queue<String> s1 = new LinkedList<>();
        Queue<String> s2 = new Queue<String>();

        s1.offer("111");
        s1.offer("222");
        s1.offer("333");

        for(int i = 0; i<s1.size();i++){
// 此时s1.size（）大小在动态变化

            s1.offer(s1.peek()+"a");
            s1.offer(s1.peek()+"b");
            s1.offer(s1.peek()+"c");
            s1.poll();
        }
        

        System.out.println(s1.size());

        for(String e:s1){
            System.out.println(e);
        }


    }
}
