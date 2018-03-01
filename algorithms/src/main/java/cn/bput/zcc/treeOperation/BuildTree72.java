package cn.bput.zcc.treeOperation;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

/**
 * Created by 张城城 on 2018/3/1.
 */
public class BuildTree72 {

    public TreeNode buildTree(int[] inorder,int[] postorder){
        TreeNode root = build(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
        return root;
    }
    public TreeNode build(int[]inorder ,int left,int right ,int[]postorder, int start, int end){
        if(left>right || start>end) return null;
        TreeNode root = new TreeNode(postorder[end]);
        int mid = binarySearch(inorder,postorder[end]);
        root.left=build(inorder, left,mid-1,postorder,start,start+mid-left-1);
        root.right=build(inorder,mid+1,right,postorder,mid-left+start,end-1);
        return root;
    }
    public int binarySearch(int[] nums,int target){
        int start=0;
        int end = nums.length-1;
        while(start<=end){
            if(nums[start]==target) return start;
            start++;
        }
        return -1;
    }
    public static void main(String[] args){
        BuildTree72 buildTree72= new BuildTree72();
        int[]inorder={1,2,3};
        int[]postorder={1,3,2};
        buildTree72.buildTree(inorder,postorder);
    }
}
