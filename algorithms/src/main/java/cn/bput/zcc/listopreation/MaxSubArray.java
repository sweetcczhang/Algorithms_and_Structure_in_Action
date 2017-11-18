package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/11/12.
 */
public class MaxSubArray {
    /**
    * @param nums: A list of integers
    * @return: A integer indicate the sum of max subarray
    */
    public int maxSubArray(int[] nums){
        int max_ending_here = nums[0];
        int max_so_far = nums[0];
        for(int i=0;i<nums.length;i++){
            max_ending_here = Math.max(nums[i], nums[i]+max_ending_here);
            max_so_far = Math.max(max_ending_here, max_so_far);
        }

        return max_so_far;
    }
}
