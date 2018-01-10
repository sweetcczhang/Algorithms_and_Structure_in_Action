package cn.bput.zcc.queueOperation;

import java.util.*;

/**
 * Created by 张城城 on 2018/1/9.
 */
public class TreeNode {
    public int val;
    public TreeNode right;
    public TreeNode left;
    public TreeNode(int val){
        this.val =val;
        this.right=this.left=null;
    }

    /**
     * 二叉树的层次遍历
     * 倒序输出每一层
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Stack<List<Integer>> stack = new Stack<List<Integer>>();
        if(root==null) return result;
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> values = new ArrayList<Integer>();
            int size = queue.size();
            for(int i=0; i<size;i++){
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                values.add(treeNode.val);
            }
            stack.push(values);
        }
        while (!stack.isEmpty()){
            result.add(stack.pop());
        }

        return result;
    }

    /**
     * 二叉树层次遍历正序输出每一层
     * @param root
     * @return
     */
    public static List<List<Integer>> leverOrder(TreeNode root){

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null) return result;
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> values = new ArrayList<Integer>();
            int size = queue.size();
            for(int i=0; i<size;i++){
                TreeNode node=queue.poll();
                values.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(values);
        }

        return result;
    }
    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        TreeNode node1 = new TreeNode(3);
        treeNode.left = node;
        treeNode.right = node1;
        leverOrder(treeNode);
    }
}
