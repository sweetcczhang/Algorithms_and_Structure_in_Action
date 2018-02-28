package cn.bput.zcc.treeOperation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张城城 on 2018/2/28.
 */
public class PreOrderTraversal66 {
    public List<Integer> preOrderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        preOrder(root,result);
        return result;
    }
    public void preOrder(TreeNode root, List<Integer> result){
        if(root!=null){
            result.add(root.val);
            preOrder(root.left,result);
            preOrder(root.right, result);


        }
    }
    public void inOrder(TreeNode root, List<Integer> result){
        if(root!=null){
            preOrder(root.left,result);
            result.add(root.val);
            preOrder(root.right, result);


        }
    }

    public void postOrder(TreeNode root, List<Integer> result){
        if(root!=null){
            preOrder(root.left,result);
            preOrder(root.right, result);
            result.add(root.val);
        }
    }

}
