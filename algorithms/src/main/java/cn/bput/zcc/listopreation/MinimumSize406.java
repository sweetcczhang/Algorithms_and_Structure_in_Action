package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/12/24.
 */
public class MinimumSize406 {
    /**
     * 题目：和大于S的最小子数组
     * 描述：给定一个由 n 个正整数组成的数组和一个正整数 s ，请找出该数组中满足
     * 其和 ≥ s 的最小长度子数组。如果无解，则返回 -1
     *
     * 思路：定义两根指针，fast and slow。fast指针往前移动当找到sum>=s时，记录长度fast-slow并且slow向前移动
     * 继续判断 sum是否大于等于s。
     *
     * @param nums
     * @param s
     * @return
     */
    public static int minimumSize(int[] nums, int s) {
        // write your code here
        if(nums==null || nums.length==0) return -1;
        int slow = 0;
        int fast = 0;
        int sum = 0;
        int minsize = nums.length+1;
        while(fast<nums.length){
            sum +=nums[fast++];
            while (sum>=s){
                minsize = Math.min(minsize, fast-slow);
                sum -= nums[slow++];
            }
        }
        minsize = minsize>nums.length? -1 : minsize;
        return minsize;
    }

    public static void main(String[] args){
        int[] nums = {2,3,1,2,4,3};
        minimumSize(nums,7);
    }

}
