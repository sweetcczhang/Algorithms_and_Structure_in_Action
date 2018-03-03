package cn.bput.zcc.treeOperation;

/**
 * Created by 张城城 on 2018/3/3.
 */
public class ConverBST661 {
    public int sum = 0;
    public TreeNode convertBST(TreeNode root){

        conver(root);
        return root;
    }
    public void conver(TreeNode root){
        if(root!=null){
            conver(root.right);
            root.val += sum;
            sum = root.val;
            conver(root.left);

        }
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(13);
        root.left = left;
        root.right = right;
        ConverBST661 c = new ConverBST661();
        c.convertBST(root);
    }
}
