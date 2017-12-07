package cn.bput.zcc.depthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 张城城 on 2017/12/7.
 */

/**
 * 深度优先遍历不会做，加强练习
 */
public class CombinationSum135 {
    /**
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates==null || candidates.length==0){
            return result;
        }
        int[] nums = removeDuplicates(candidates);
        dfs(nums,0,new ArrayList<Integer>(),target,0,result);

        return result;
    }

    /**
     * 在数组原地去除数组中重复的数
     * @param candidates
     * @return
     */
    public int[] removeDuplicates(int[] candidates){
        Arrays.sort(candidates);
        int index = 0;
        for(int i=0; i<candidates.length;i++){
            if(candidates[i]!=candidates[index]){
                candidates[++index] = candidates[i];
            }
        }
        int [] num = new int[index+1];
        for(int i=0;i<=index;i++){
            num[i] = candidates[i];
        }
        return num;
    }

    /**
     * 深度优先遍历
     * @param nums
     * @param startIndex
     * @param combination
     * @param target
     * @param sum
     * @param results
     */
    public void dfs(int[]nums, int startIndex, List<Integer> combination, int target, int sum, List<List<Integer>> results){
        if(sum == target){
            List<Integer> temp = new ArrayList<Integer>(combination);
            results.add(temp);
            return;
        }
        for(int i = startIndex; i<nums.length;i++){
            if(target<nums[i]+sum){
                break;
            }
            combination.add(nums[i]);
            dfs(nums,i,combination, target, sum+nums[i],results);
            combination.remove(combination.size()-1);
        }
    }
    public static void main(String[] args){
        CombinationSum135 combinationSum135 = new CombinationSum135();
        int[] a = {1};
        combinationSum135.combinationSum(a,1);
    }
}
