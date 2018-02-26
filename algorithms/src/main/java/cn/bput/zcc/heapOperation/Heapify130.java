package cn.bput.zcc.heapOperation;

/**
 * Created by 张城城 on 2018/2/26.
 */
public class Heapify130 {
    public void heapify(int[] A){
        for(int i=A.length/2-1;i>=0;i--){
            heapAdjust(A,i,A.length);
        }

    }
    public void heapAdjust(int[]A, int i,int len){
        int child;
        int temp;
        for(; 2*i+1<len;i=child){
            child = 2*i+1;
            if(child<len-1 && A[child]>A[child+1]){
                child++;
            }
            if(A[i]>A[child]){
                temp = A[i];
                A[i]=A[child];
                A[child]=temp;
            }
        }
    }
}
