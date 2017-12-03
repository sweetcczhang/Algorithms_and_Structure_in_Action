package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/12/3.
 */
public class MaxDiffSubArrays45 {
    /**
     * 题目：
     * 给定一个整数数组，找出两个不重叠的子数组A和B，
     * 使两个子数组和的差的绝对值|SUM(A) - SUM(B)|最大。
     * @param nums
     * @return
     */
    public static int maxDiffSubArrays(int[] nums) {
        // write your code here
        int size = nums.length;
        if(nums==null&&size==0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int localMax = 0;
        int localMin = 0;
        int globalMax = Integer.MIN_VALUE;
        int globalMin = Integer.MAX_VALUE;
        int[] leftMax = new int[size];
        int [] leftMin = new int[size];
        int[] rightMax = new int[size];
        int[] rightMin = new int[size];
        for(int i=0;i<size;i++){
            localMax = Math.max(nums[i],localMax+nums[i]);
            globalMax = Math.max(localMax, globalMax);
            leftMax[i] = globalMax;
            localMin = Math.min(nums[i],localMin+nums[i]);
            globalMin = Math.min(globalMin, localMin);
            leftMin[i] = globalMin;
        }
        localMax = 0;
        localMin = 0;
        globalMax = Integer.MIN_VALUE;
        globalMin = Integer.MAX_VALUE;

        for(int i=size-1;i>=0;i--){
            localMax = Math.max(nums[i],localMax+nums[i]);
            globalMax = Math.max(localMax, globalMax);
            rightMax[i] = globalMax;
            localMin = Math.min(nums[i],localMin+nums[i]);
            globalMin = Math.min(globalMin, localMin);
            rightMin[i] = globalMin;
        }
        for(int i=0; i<size-1;i++){
            max = Math.max(rightMax[i+1]-leftMin[i],max);
            max = Math.max(leftMax[i]-rightMin[i+1],max);
        }

        return max;
    }
    public static void main(String[] args){
        int[] a ={1,2,-3,1};
        maxDiffSubArrays(a);

    }
}
