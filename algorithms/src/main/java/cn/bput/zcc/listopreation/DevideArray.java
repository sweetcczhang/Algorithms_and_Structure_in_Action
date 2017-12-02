package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/12/1.
 */
public class DevideArray {
    public int partitionArray(int[] nums, int k) {
        // write your code here
        int left = 0;
        int right = nums.length-1;
        int target = k;
        while (left<right){
            while(left<right&&nums[left]<target)
                left++;
            while (left<right&&nums[right]>=target)
                right--;
            if(left<right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        if(left==right){
            if(nums[left]<target){
                return left+1;
            }
        }
        return left;
    }
}
