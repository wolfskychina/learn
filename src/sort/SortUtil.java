package sort;

/**
 * 常见的比较排序的总结
 *
 * java里面对象的传递是引用传递
 * 因此数组a会被修改
 */
public class SortUtil {


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
    // 稳定排序

    /**
     * Bubble Sort
     * @param a
     */
    public static void bubbleSort(int[] a){

        for(int i = 0;i<a.length;i++){

            for(int j=a.length-1;j>i;j--){

                if(a[j] < a[j-1]){
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }

    }

    /**
     * Merge Sort
     */
    public static void mergeSort(int[] a,int low,int high) {

        int mid = (low + high) >> 2;
        if (low < high) {
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);

        }

    }

    /**
     * Merge Sort- merge method
     */
    private static void merge(int[] a,int low,int mid,int high){
        int[] temp = new int[high-low+1];
        int i =low;
        int j = mid+1;
        int k = 0;

        while(i<=mid && j<=high){
            temp[k++]=a[i]<=a[j]?a[i++]:a[j++];
            // the '<=' is important, or the sort will be unstable
        }

        while(i<=mid) temp[k++] = a[i++];
        while(j<=high) temp[k++] = a[j++];

        // 书上的方法只需要一次循环，但是需要一个正无穷作为标记，在java里面没有无穷大整数这种常量
        // 如果测试数据集中有Max_int值得话，原书上的方法就会有问题。

        for(int x = 0;x<temp.length;x++){
            a[low+x] = temp[x];
        }

    }

    /**
     * Quick Sort - Main Method
     */
    public static void quickSort(int[] a,int p,int r){
        if(p<r){
            int q = partition(a,p,r);
            quickSort(a,p,q-1);
            quickSort(a,q+1,r);
        }
    }

    /**
     * Quick Sort- Partation
     * 分划方法是个很有用的子方法
     */
    public  static int partition(int[] a, int p,int r){

        int x = a[r];
        int i =p;
        int tmp;
        for(int j=p;j<r;j++){
            if(a[j]<=x){
                tmp = a[j];
                a[j] = a[i];
                a[i] =tmp;
                i++;
            }
        }

        tmp = a[r];
        a[r] = a[i];
        a[i] = tmp;

        return i;

    }

}
