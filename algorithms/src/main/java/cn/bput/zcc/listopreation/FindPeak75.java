package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/12/4.
 */
public class FindPeak75 {

    public int findPeak(int[] A) {
        // write your code here
        int start=1;
        int end = A.length-2;
        if(A[start]>A[start+1]){
            return start;
        }
        if(A[end]>A[end-1]){
            return end;
        }
        while (start<A.length-1&&A[start]<A[start+1]) start++;
        return start;
    }
}
