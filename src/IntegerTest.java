public class IntegerTest {

    // to test the different of (n-1)/2 and n/2 -1
    public static void main(String[] args){

        IntegerTest.f2();


    }

    public static void f1(){
        for(int i =0; i<100;i++){

            System.out.println("(n-1)/2 is "+((i-1)/2)+" n/2-1 is "+(i/2-1));
        }

    }

    public static void f2(){

        System.out.println((Integer.MAX_VALUE-1 + Integer.MAX_VALUE-1)/2);
        System.out.println(Integer.MAX_VALUE-10+ (Integer.MAX_VALUE+10-Integer.MAX_VALUE-5)/2);

    }
    
}
