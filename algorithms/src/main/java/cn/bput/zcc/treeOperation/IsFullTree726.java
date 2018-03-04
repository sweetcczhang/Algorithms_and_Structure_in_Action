package cn.bput.zcc.treeOperation;

/**
 * Created by 张城城 on 2018/3/4.
 */
public class IsFullTree726 {
    public boolean isFullTree(TreeNode root){
        if(root==null) return true;
        if(root.left!=null && root.right==null) return false;
        if(root.left==null && root.right!=null) return false;
        boolean left = isFullTree(root.left);
        boolean right = isFullTree(root.right);
        return  left && right;

    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode node = new TreeNode(4);
        TreeNode node1 = new TreeNode(5);
        root.left = left;
        root.right = right;
        left.left = node;
        left.right =node1;
        IsFullTree726 isFullTree726 = new IsFullTree726();
        isFullTree726.isFullTree(root);
    }
}
