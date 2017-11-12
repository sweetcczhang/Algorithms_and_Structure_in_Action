package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/11/11.
 */
public class SearchInsert {

    public static int searchInsert(int[] A, int target){
        int low = 0;
        int high = A.length-1;
        if (target<=A[low]){
            return low;
        }
        if(target>A[high]){
            return  high+1;
        }
        while (low<=high){
            int middle = (low + high)/2;
             if(target == A[middle]){
                 return middle;
             }else if(target<A[middle]){
                 high = middle-1;
             }else {
                 low = middle + 1;
             }
        }
        return low;
    }
}
