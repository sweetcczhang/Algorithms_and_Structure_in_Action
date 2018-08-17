package cn.bput.zcc.SwordFingerOffer;

import cn.bput.zcc.dataStruck.TreeNode;

/**
 * Created by zcc
 * Date on 2018/8/9
 */
public class Convert {

    TreeNode lastNode = null;
    public TreeNode convert(TreeNode root){


        TreeNode node = lastNode;
         while ( node!=null && node.left!=null)
             node = node.left;
         return root;
     }

     public void convertNode(TreeNode root){
        if (root==null) return;
        TreeNode currentNode = root;
        if (currentNode.left!=null){
            convertNode(currentNode.left);
        }
        currentNode.left = lastNode;
        if (lastNode!=null){
            lastNode.right = currentNode;
        }
        if (currentNode.right!=null){
            convertNode(currentNode.right);
        }
     }
}
