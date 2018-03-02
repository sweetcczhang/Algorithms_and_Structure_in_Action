package cn.bput.zcc.treeOperation;

/**
 * Created by 张城城 on 2018/3/2.
 */
public class CloneTree375 {
    public TreeNode cloneTree(TreeNode root){
        if(root==null) return null;
        TreeNode node = new TreeNode(root.val);
        node.left = cloneTree(root.left);
        node.right = cloneTree(root.right);
        return node;
    }
}
