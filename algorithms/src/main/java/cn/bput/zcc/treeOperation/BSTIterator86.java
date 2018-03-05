package cn.bput.zcc.treeOperation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张城城 on 2018/3/5.
 */
public class BSTIterator86 {
    List<TreeNode> list;
    public BSTIterator86(TreeNode root){
        list = new ArrayList<TreeNode>();
        inOrder(root);
    }
    public void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        list.add(root);
        inOrder(root.right);
    }
    public boolean hashNext(){
        if (list.size()>0) return true;
        else return false;
    }
    public TreeNode next(){
        TreeNode node=list.get(0);
        list.remove(0);
        return node;
    }
}
