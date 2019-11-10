package leetcode.array;

public class _4Solution {

    public double findMedianSortedArrays(int[] A,int[] B){

        int m =A.length;
        int n = B.length;

        if(m>n){

            int [] tmp = A;
            A =B;
            B = tmp;
            int temp =m;m=n;n=temp;
        }

        int iMin = 0;
        int iMax = m;
        int halfLen = (m+n+1)/2;
        // i + j = halfLen
        // i + j = (m+n+1)/2 ? TODO
        // 左边是 a0,a1,...,ai-1, b0,b1...bj-1,总共是i+j个元素。
        // 右边是 ai..am-1,  bj...bn-1， 总共是m-i,n-j个元素

        while(iMin <=iMax){
            int i = (iMin+iMax)/2;
            int j = halfLen - i;
            if(i<iMax && A[i]<B[j-1]){
                iMin = i+1;
            }else if(i>iMin&& A[i-1]>B[j]){
                iMax = i-1;
            }
            else{
                int maxLeft = 0;
                if(i==0) {
                    maxLeft = B[j-1];
                }else if(j ==0){
                    maxLeft = A[j-1];
                }else {
                    maxLeft = Math.max(A[i-1],B[j-1]);
                }
                if( (m+n)/2 == 1) return maxLeft;

                int minRight = 0;

                if(i==m) {minRight = B[j];}
                else if(j==n){minRight=A[i];}
                else{minRight = Math.min(A[i],B[j]);}

                return (maxLeft+minRight)/2.0;
            }
        }

        return 0.0;
    }
}
