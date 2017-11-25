package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/11/25.
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums){
        int len = nums.length;
        int j=0;
        if (len==0){
            return len;
        }
        for(int i=0; i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                len--;

            }else {
                nums[j] = nums[i];
                j++;
            }
        }
        nums[j]=nums[nums.length-1];
        return len;
    }
    public int removeDuplicates2(int[] nums){
        int len = nums.length;
        if (len==0) return 0;
        int fast;
        int slow = 1;
        int count = 0;
        for (fast=1; fast<len;fast++){
            if (nums[fast]==nums[slow-1]){
                count++;
                if(count>=2){
                    continue;
                }
            }else {
                count=0;
            }
            nums[slow] = nums[fast];
            slow++;
        }
        return slow;
    }
}
