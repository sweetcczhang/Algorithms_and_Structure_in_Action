package cn.bput.zcc.hashtableOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 张城城 on 2018/1/30.
 */
public class SubArraySum138 {
    /**
     * lintcode 138
     * 题目：子数组之和
     * 描述:给定一个整数数组，找到和为零的子数组。你的代码应该返回满足要求的子数组的起始位置和结束位置
     * 解题思路：使用hashmap记录钱n项之和。如果出现两个相同的和表示在上一次之后到现在数的相加之和为零。
     * 其中需要注意的一个小技巧是：如果前几个数的和就是零的话就会报错。所以在所以在hashmap中首先插入和为零下标为-1.
     * 这样当前几项和为零时。-1+1就是零就是第一项。
     * @param nums
     * @return
     */
    public List<Integer> subArraySum(int[] nums){
        if(nums==null || nums.length==0) return null;
        List<Integer> result = new ArrayList<Integer>();
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        int sum =0;
        map.put(0,-1);
        for(int i=0; i<nums.length;i++){
            sum +=nums[i];
            if(map.containsKey(sum)){
                result.add(map.get(sum)+1);
                result.add(i);
                return result;
            }
            map.put(sum,i);
        }
        return null;
    }
}
