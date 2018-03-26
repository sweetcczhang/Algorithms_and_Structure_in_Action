package cn.bput.zcc.treeOperation;

import java.util.Stack;

/**
 * Created by 张城城 on 2018/3/1.
 */
public class BuildTree73 {
    public TreeNode buildTree(int[] preorder, int[] inorder){
        TreeNode root= build(preorder,0, preorder.length-1,inorder,0,inorder.length-1);
        Stack<Integer> stack1 = new Stack<Integer>();

        return root;
    }
    public TreeNode build(int[]preorder,int left, int right,int[] inorder,int start, int end){
        if(left>right || start >end) return null;
        TreeNode root = new TreeNode(preorder[left]);
        int mid = binarySearch(inorder,preorder[left]);
        root.left = build(preorder,left+1,mid-start+left,inorder,start,mid-1);
        root.right = build(preorder,mid-start+1+left,right,inorder, mid+1, end);
        return root;
    }

    public int binarySearch(int[] nums,int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            if (nums[start] == target) return start;
            start++;
        }
        return -1;
    }

}
