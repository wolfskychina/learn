package sort;

public class Sort {


    /**
     * Insertion Sort
     * @param a
     */
    public static int[] insertionSort(int[] a ){

        int i = 0;
        int key;
        for(int j=1 ; j < a.length; j++){

            key = a[j];

            for(i =j -1;i>=0 && a[i]>key;i--){

                a[i+1] = a[i]; //插入操作,第一步i+1=j,a[j]的值已经被赋给key

            }
            a[i+1]=key; //每一个插入元素都会执行这一步，即使已经是有序的，也会有这个赋值的操作
        }

        return a;
    }

    /**
     * Bubble Sort
     * @param a
     */
    public static int[] bubbleSort(int[] a){

        for(int i = 0;i<a.length;i++){

            for(int j=a.length-1;j>i;j--){

                if(a[j] < a[j-1]){
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }

        return a;
    }

    /**
     * Merge Sort
     */
    public static int[] mergeSort(int[] a,int low,int high) {

        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            a = merge(a, low, mid, high);

        }

        return a;

    }

    /**
     * Merge Sort- merge method
     */
    public static int[] merge(int[] a,int low,int mid,int high){
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

        for(int x = 0;x<temp.length;x++){
            a[low+x] = temp[x];
        }

        return a;
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
