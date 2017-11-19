package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/11/16.
 */
public class Median {

    /**
     * 给定一个未排序的整数数组，找到其中位数。
     * 中位数是排序后数组的中间值，如果数组的个数是偶数个，则返回排序后数组的第N/2个数。
     * @param nums
     * @return
     */
    public int median(int [] nums){
        int len = nums.length;
        for(int i=0;i<nums.length-1;i++){
            for(int j=nums.length-1; j>i;j--){
                if(nums[j]<nums[j-1]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }
        return nums[(len-1)/2];
    }

}
