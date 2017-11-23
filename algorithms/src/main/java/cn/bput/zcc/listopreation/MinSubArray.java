package cn.bput.zcc.listopreation;

import java.util.List;

/**
 * Created by 张城城 on 2017/11/23.
 */
public class MinSubArray {
    public int minSubArray(List<Integer> nums){
        Integer min_ending_here = nums.get(0);
        Integer min_so_far = nums.get(0);
        for(int i=1;i<nums.size();i++){
            min_ending_here = Math.min(nums.get(i), min_ending_here+nums.get(i));
            min_so_far = Math.min(min_ending_here,min_so_far);
        }
        return min_so_far;
    }
}
