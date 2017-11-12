package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/11/11.
 */
public class MergeSortedArray {

    /**
     *合并两个排序的数组：此处技巧从大往小排序，不用移动数据。
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int p = m+n-1;
        int a = m-1;
        int b = n-1;
        while (a>=0 && b>=0){
            if(A[a]>B[b]){
                A[p--] = A[a--];
            }else {
                A[p--] = B[b--];
            }
        }
        while (a>=0){
            A[p--]=A[a--];
        }
        while (b>=0){
            A[p--] =B[b--];
        }
    }


    /**
     * 对两个数组进行排序，进行比较。当一个数组都已经插入完全，将另一个数组
     * 中剩余的数据插入就好无需再进行比较
     * @param A
     * @param B
     * @return
     */
    public static int[] mergeSortedArray(int[]A, int[]B){
        int [] C = new int[A.length+B.length];
        int i=0,j=0,k=0;
        while (i<A.length && j<B.length){
            if(A[i]<B[j]){
                C[k++] = A[i++];
            }else {
                C[k++] = B[j++];
            }
        }
        if(i<A.length){
            while (i<A.length){
                C[k++]=A[i++];
            }
        }else if(j<B.length) {
            while (j<B.length){
                C[k++]= B[j++];
            }
        }
        return C;
    }
}
