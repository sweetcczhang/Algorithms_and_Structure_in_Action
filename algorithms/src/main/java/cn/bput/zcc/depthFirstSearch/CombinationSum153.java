package cn.bput.zcc.depthFirstSearch;

import sun.plugin.javascript.navig.LinkArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 张城城 on 2017/12/10.
 */
public class CombinationSum153 {
    /**
     * 题目：数字组合 II
     * 描述：给出一组候选数字(C)和目标数字(T),找出C中所有的组合，
     * 使组合中数字的和为T。C中每个数字在每个组合中只能使用一次。
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, 0, target, 0, result, list);
        return result;
    }

    public void dfs(int[] nums, int start, int target, int sum, List<List<Integer>> result, List<Integer> list){
        if (sum == target){
            List<Integer> temp = new ArrayList<Integer>(list);
            if(!result.contains(temp)){
                result.add(temp);
                return;
            }
        }
        for (int i = start; i<nums.length;i++){
            if(sum+nums[i]>target){
                break;
            }
            list.add(nums[i]);
            dfs(nums, i+1, target, sum+nums[i], result,list);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args){
        CombinationSum153 combinationSum153 = new CombinationSum153();
        int[] a = {7,1,2,5,1,6,10};
        int target = 8;
        combinationSum153.combinationSum2(a, target);
    }
}
