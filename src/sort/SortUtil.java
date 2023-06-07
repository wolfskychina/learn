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
     * 左右都是全闭区间
     */
    public static void mergeSort(int[] a,int low,int high) {

        int mid = (low + high) >> 1;
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
     * 左右为全闭区间
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
    // 分划的过程也是构建二叉树的过程，以a[r]为根，左子树的所有节点的值都比根节点大
    // 右子树的所有节点的值都比根节点小

    /**
     * Heap Sort
     * 堆排序
     * 堆排序算法主要包括：递归的堆维护函数、建堆函数、堆排序函数
     * 堆是连续的内存空间，可以方便的进行随机访问
     */

     /**
      * Maintain Heap
        堆维护函数
        当堆顶的节点发生改变时，用来维护堆的单调性质
        堆维护函数是递归调用的
      */
    private static int heapSize = 0;

    private static void maintainHeap(int[] a, int root){

        int left = root*2+1;
        int right = root*2+2;
        int larger ;

        // 通过两次比较确定三个值中的最大值
        larger = (left< heapSize && a[root]<a[left])?left:root;

        larger = (right< heapSize && a[larger]<a[right]) ?right:larger;

        if(larger!=root){

            int tmp = a[root];
            a[root] = a[larger];
            a[larger] = tmp;

            maintainHeap(a,larger);
        }

    }

    /**
     * 建堆函数
     * @param a
     */
    private static void buildHeap(int [] a){

        for(int i = (heapSize-1)>>1 ; i>=0;i--){

            maintainHeap(a, i);

        }
    }

    /**
     * 堆排序函数
     */
    public static void heapSort(int[] a,int size){

        heapSize = size;
        buildHeap(a);
        for(int i = heapSize-1;i>=0;i--){
            // 每次都取最大的root节点
            int tmp = a[i];
            a[i] = a[0];
            a[0] = tmp;
            // 通过缩小堆的大小，从而不影响已经排好的部分
            heapSize --;
            maintainHeap(a, 0);
        }
    }
}
