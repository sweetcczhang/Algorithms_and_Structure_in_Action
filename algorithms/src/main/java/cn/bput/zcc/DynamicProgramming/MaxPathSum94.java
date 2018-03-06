package cn.bput.zcc.DynamicProgramming;

import cn.bput.zcc.treeOperation.TreeNode;

/**
 * Created by 张城城 on 2018/3/6.
 */
public class MaxPathSum94 {

    public int max =Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        inOrder(root);
        return max;
    }
    public int inOrder(TreeNode root){
        if(root==null) return 0;

        int left =inOrder(root.left);
        int right =inOrder(root.right);
        max = Math.max(max,Math.max(0,left)+Math.max(0,right)+root.val);
        return Math.max(0,Math.max(left,right)+root.val);
    }
}
