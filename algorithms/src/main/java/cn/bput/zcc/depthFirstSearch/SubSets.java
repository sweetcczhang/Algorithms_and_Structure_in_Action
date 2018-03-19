package cn.bput.zcc.depthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(nums==null || nums.length==0) return result;
        result.add(list);
        for(int i=1;i<=nums.length;i++){
            dfs(nums,result, list,0,i);
        }
        result.add(new ArrayList<Integer>());
        return result;

    }

    public void dfs(int[]nums, List<List<Integer>> result, List<Integer> list, int start,int len){
        if(list.size()==len){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=start;i<nums.length;i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            dfs(nums, result,list,i+1,len);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args){
        SubSets s =new SubSets();
        int[] a={1,2};
        s.subsets(a);
    }
}
