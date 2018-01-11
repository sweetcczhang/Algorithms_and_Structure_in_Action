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




    public static List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Stack<TreeNode> stackleft = new Stack<TreeNode>();
        Stack<TreeNode> stackright = new Stack<TreeNode>();
        if(root==null) return result;
        int i = 0;
        stackleft.push(root);
        while (!stackleft.isEmpty() || !stackright.isEmpty()){
            int flag = i % 2;
            List<Integer> list = new ArrayList<Integer>();
            if(flag==0){
                int size = stackleft.size();
                while(size>0){
                    TreeNode treeNode = stackleft.pop();
                    list.add(treeNode.val);
                    if(treeNode.left!=null){
                        stackright.push(treeNode.left);
                    }
                    if (treeNode.right!=null){
                        stackright.push(treeNode.right);
                    }
                    size--;
                }
            }else {
                int size = stackright.size();
                while (size>0){
                    TreeNode treeNode = stackright.pop();
                    list.add(treeNode.val);
                    if(treeNode.right!=null){
                        stackleft.push(treeNode.right);
                    }
                    if(treeNode.left!=null){
                        stackleft.push(treeNode.left);
                    }
                    size--;
                }
            }
            i++;
            result.add(list);

        }

        return result;
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
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(7);
        treeNode.left = node;
        treeNode.right = node1;
        node.left =node2;
        node.right = node3;
        node1.left = node4;
        node1.right = node5;
        zigzagLevelOrder(treeNode);
    }
}
