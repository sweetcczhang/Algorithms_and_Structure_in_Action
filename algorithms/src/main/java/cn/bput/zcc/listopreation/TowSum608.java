package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2018/1/7.
 */
public class TowSum608 {
     public int[] twoSum(int[] nums, int target){
         int[] result = new int[2];
         if(nums==null ||nums.length<2) return result;
         int left= 0;
         int right = nums.length-1;
         while(left<right){
             if(nums[left]+nums[right]==target){
                 result[1]=right+1;
                 result[0]=left+1;
                 return result;
             }else if (nums[left]+nums[right]<target){
                 left++;
             }else {
                 right--;
             }
         }
         return result;
     }
}
