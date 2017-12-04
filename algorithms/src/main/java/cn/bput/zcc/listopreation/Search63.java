package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/12/4.
 */
public class Search63 {

    public boolean search(int[] A, int target) {
        // write your code here
        int size = A.length;
        int start = 0;
        int end = A.length-1;
        if(A==null||size==0){
            return false;
        }
        if(target>=A[0]){
            while (start<size-1&&A[start]<=A[start+1]){
                if(target==A[start]){
                    return true;
                }
                start++;
            }
            if (A[start]==target) return true;
        }else {
            while (end>0&&A[end]>=A[end-1]){
                if(target==A[end]){
                    return true;
                }
                end--;
            }
            if(A[end]==target) return true;
        }
        return false;
    }
}
