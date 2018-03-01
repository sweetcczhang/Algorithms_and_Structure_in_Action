package cn.bput.zcc.treeOperation;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by 张城城 on 2018/3/1.
 */
public class InverBinaryTree175 {
    /**
     * 二叉树的递归翻转
     * @param root
     */
    public void invertBinaryTree(TreeNode root){
        if(root==null) return;
        if(root.left==null && root.right==null){
            return;
        }
        if(root.left!=null){
            invertBinaryTree(root.left);
        }
        if(root.right!=null){
            invertBinaryTree(root.right);
        }

        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
    }

    /**
     * 二叉树的非递归翻转
     * @param root
     */
    public void inverBinaryTree(TreeNode root){
        if(root==null) return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (queue.size()>0){
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if(node.left!=null) queue.offer(node.left);
            if(node.right!=null) queue.offer(node.right);
        }

    }
}
