package cn.bput.zcc.treeOperation;

/**
 * Created by 张城城 on 2018/3/2.
 */
public class Flatten453 {
    public void flatten(TreeNode root){
        if(root==null || (root.left==null && root.right==null)) return;
        if(root.left==null){
            TreeNode right = root.right;
            flatten(right);
            return;
        }
        if(root.right==null){
            TreeNode left = root.left;
            root.right = root.left;
            root.left = null;
            flatten(left);
            return;
        }
        TreeNode left= root.left;
        TreeNode right = root.right;
        root.right = left;
        root.left =null;
        flatten(left);
        TreeNode p = left;
        while(p.right!=null){
            p=p.right;
        }
        flatten(right);
        p.right = right;
    }
}
