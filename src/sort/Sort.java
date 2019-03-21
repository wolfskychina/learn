package sort;

public class Sort {

    /**
     * Insertion Sort
     * @param a
     */
    public static void insertionSort(int[] a ){

        int i = 0;
        int key;
        for(int j=1 ; j < a.length; j++){

            key = a[j];

            for(i =j -1;i>=0 && a[i]>key;i--){

                a[i+1] = a[i]; //插入操作,第一步i+1=j,a[j]的值已经被赋给key

            }
            a[i+1]=key; //每一个插入元素都会执行这一步，即使已经是有序的，也会有这个赋值的操作
        }
    }



}
