package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/11/11.
 */
public class BinarySearch {
    public int binarySearch(int [] nums, int target){
         int low = 0;
         int high = nums.length-1;
         while (low <= high){
             int middle = (low + high) / 2;
             if (target==nums[middle]){
                     while((middle>0)&&(nums[middle]==nums[middle-1])){
                         middle = middle -1;
                 }
                 return middle;
             }else if(target<nums[middle]){
                 high = middle - 1;
             }else {
                 low = middle + 1;
             }
         }
        return 0;
    }
}
