package sort;

public class SortTest {
    
    public static void main(String[] args){

        int a[] = {0,333,1,2,3,4,5,5,23,1,2,5,43,23,11,23,432,11,15,31};

        //SortUtil.insertionSort(a);
        //SortUtil.bubbleSort(a);
        //SortUtil.mergeSort(a, 0, a.length-1);
        //SortUtil.quickSort(a, 0, a.length-1);
        SortUtil.heapSort(a, a.length);
        for(int i:a){
            System.out.println(i);
        }
    }
}
