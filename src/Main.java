import java.util.Stack;

public class Main {

    public static void main(String[] args) {


        Stack<String> s1 = new Stack<String>();

        s1.push("111" );
        s1.push("222");
        s1.push("333");

        for(int i = s1.size();i>0;i--){

            System.out.println(s1.size());
            System.out.println(s1.pop());


        }


    }
}
