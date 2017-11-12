package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/11/11.
 */
public class MergeSortedArray {
    public static int[] mergeSortedArray(int[]A, int[]B){
        int [] C = new int[A.length+B.length];
        int i=0,j=0,k=0;
        while (i<A.length && j<B.length){
            if(A[i]<B[j]){
                C[k] = A[i];
                k++;
                i++;
            }else {
                C[k] = B[j];
                k++;
                j++;
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
