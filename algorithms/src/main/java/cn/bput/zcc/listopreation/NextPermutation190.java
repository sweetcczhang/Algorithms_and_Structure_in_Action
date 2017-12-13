package cn.bput.zcc.listopreation;

import java.util.Arrays;

/**
 * Created by 张城城 on 2017/12/12.
 */
public class NextPermutation190 {
    /**
     *题目：下一个排列
     * 描述：给定一个若干整数的排列，给出按正数大小进行字典序从小到大排序后的下一个排列。
     * 如果没有下一个排列，则输出字典序最小的序列。
     * 解题思路：
     * 从后往前找，找到第一对(i,j)，使得nums[i]<num[j],然后将两者兑换后，后面部分排序即可
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        // write your code here
        for(int i= nums.length-1;i>=0;i--){
            for(int j=nums.length-1;j>i;j--){
                if(nums[i]<nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    Arrays.sort(nums,i+1,nums.length);
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }
    public static void main(String[] args){
        int[] a ={1,3,2};
        nextPermutation(a);
    }
}
