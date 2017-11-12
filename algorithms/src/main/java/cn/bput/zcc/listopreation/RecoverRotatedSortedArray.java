package cn.bput.zcc.listopreation;

import java.util.List;

/**
 * Created by 张城城 on 2017/11/12.
 */
public class RecoverRotatedSortedArray {

    /**
     * 回复旋转排序数组
     * 思路：旋转数组可以将其分为两个部分[Second,First]，这个数组有两个特点
     * 1.Second部分的都比First部分大
     * 2.两个部分的数组都是升序排列
     * 解题步骤：先翻转Second部分，在翻转First部分。最后翻转整体
     * @param nums
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        int i =0;
        while ((i<nums.size()-1) && nums.get(i)<=nums.get(i+1)){
             i++;
        }
        reverse(nums, 0, i);
        reverse(nums, i+1, nums.size()-1);
        reverse(nums, 0, nums.size()-1);
    }
    public void reverse(List<Integer> nums, int start, int end){
        for (int i=start,j=end;i<j;i++,j--){
            Integer temp_i = nums.get(i);
            Integer temp_j = nums.get(j);
            nums.set(i, temp_j);
            nums.set(j, temp_i);
        }
    }
}
