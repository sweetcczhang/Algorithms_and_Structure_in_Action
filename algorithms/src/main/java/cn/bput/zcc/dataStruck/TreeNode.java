package cn.bput.zcc.dataStruck;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.Executors;

/**
 * Created by zcc
 * Date on 2018/8/8
 */
public class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val){
        this.val = val;
        this.left = this.right = null;
    }

    /**
     * 二叉树的非递归前序遍历
     * @param root
     * @return
     */
    public List<Integer> preOrder(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || root!=null){
            while (root!=null){
                result.add(root.val);
                stack.add(root);
                root = root.left;
            }
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                root = node.right;

            }
        }

        return result;
    }

    /**
     * 二叉树的非递归中序遍历
     * @param root
     * @return
     */
    public List<Integer> inOrder(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || root!=null){

            while (root!=null){
                stack.add(root);
                root =root.left;
            }
            if (!stack.isEmpty()){
                TreeNode node = stack.pop();
                result.add(node.val);
                root = node.right;
            }
        }
        return result;
    }

    /**
     * 二叉树的非递归后续遍历
     * @param root
     * @return
     */
    public List<Integer> postOrder(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> stack1 = new Stack<Integer>();
        int flag =1;
        while (!stack.isEmpty() || root!=null){
            while (root!=null){
                stack.push(root);
                stack1.push(0);
                root = root.left;
            }
            if (!stack.isEmpty() && stack1.peek()==flag){
                TreeNode node = stack.pop();
                stack1.peek();
                result.add(node.val);
            }
            if (!stack.isEmpty()){
                TreeNode node = stack.peek();
                stack1.pop();
                stack1.push(1);
                root = node.right;
            }
        }


        return result;
    }
    public static void main(String[] args){
        Executors.callable(new Runnable() {
            public void run() {
                System.out.println("test");
            }
        });
    }
}
