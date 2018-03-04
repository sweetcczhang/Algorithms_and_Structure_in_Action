package cn.bput.zcc.treeOperation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 张城城 on 2018/3/4.
 */
public class TwoSum689 {
    int[] ans =null;
    public int[] twoSum(TreeNode root, int n){
        Set<Integer> set = new HashSet<Integer>();
        dfs(root,set,n);
        return ans;
    }
    public void dfs(TreeNode root, Set<Integer> set, int n){
        if (root==null) return;
        if(ans!=null) return;
        dfs(root.left,set,n);
        if(set.contains(n-root.val)){
            ans = new int[]{n-root.val,root.val};
            return;
        }else {
            set.add(root.val);
        }
        dfs(root.right,set,n);
    }
}
