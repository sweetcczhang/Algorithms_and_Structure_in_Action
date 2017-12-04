package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/12/4.
 */
public class Search62 {
    public int search(int[] A, int target) {
        // write your code here
        int size = A.length;
        int start = 0;
        int end = A.length-1;
        if(A==null||size==0){
            return -1;
        }
        if(target>=A[0]){
            while (start<size-1&&A[start]<=A[start+1]){
                if(target==A[start]){
                    return start;
                }
                start++;
            }
            if (A[start]==target) return start;
        }else {
            while (end>0&&A[end]>A[end-1]){
                if(target==A[end]){
                    return end;
                }
                end--;
            }
            if(A[end]==target) return end;
        }
        return -1;
    }
}
