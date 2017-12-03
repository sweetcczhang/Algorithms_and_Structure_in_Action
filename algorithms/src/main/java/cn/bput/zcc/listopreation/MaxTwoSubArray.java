package cn.bput.zcc.listopreation;

import java.util.List;

/**
 * Created by 张城城 on 2017/12/3.
 */
public class MaxTwoSubArray {

    /**
     * 题目描述：
     * 给定一个整数数组，找出两个 不重叠 子数组使得它们的和最大。
     * 每个子数组的数字在数组中的位置应该是连续的。返回最大的和。
     * 解题思路：
     * 只需要把给定的数组分为两部分，找到左半部分和右半部分的最大子数组的和的最大值即可。
     * @param nums
     * @return
     */
    public int maxTwoSubArrays(List<Integer> nums) {
        // write your code here
        int size = nums.size();
        if(nums==null|| size==0){
            return 0;
        }
        int max= Integer.MIN_VALUE;
        int localMax = 0;
        int [] left = new int[size];
        int [] right = new int[size];
        int globalMax = Integer.MIN_VALUE;
        for(int i=0;i<size;i++){
            localMax = Math.max(nums.get(i),nums.get(i)+localMax);
            globalMax = Math.max(localMax,globalMax);
            left[i] = globalMax;
        }
        localMax = 0;
        globalMax = Integer.MIN_VALUE;
        for (int i=size-1;i>=0;i--){
            localMax = Math.max(nums.get(i),nums.get(i)+localMax);
            globalMax = Math.max(localMax, globalMax);
            right[i] = globalMax;
        }
        for(int i=0; i<size-1;i++){
            max = Math.max(left[i]+right[i+1],max);
        }
        return max  ;
    }

}
