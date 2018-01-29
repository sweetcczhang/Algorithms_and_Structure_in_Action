package cn.bput.zcc.linkListOperation;


import cn.bput.zcc.treeOperation.TreeNode;

/**
 * Created by 张城城 on 2018/1/29.
 */
public class BstToDoublyList {
    DoublyListNode head = new DoublyListNode(-1);
    public DoublyListNode bstToDoublyList(TreeNode root){
        if (root==null) return null;
        DoublyListNode p = head;
        midOrder(root);
        DoublyListNode result = p.next;
        p.next.prev = null;
        return result;
    }

    public void midOrder(TreeNode root){
        if(root==null)  return ;
        midOrder(root.left);
        DoublyListNode node1 = new DoublyListNode(root.val);
        head.next = node1;
        node1.prev = head;
        head = node1;
        midOrder( root.right);
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(4);
        TreeNode node = new TreeNode(2);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        root.left = node;
        root.right = node1;
        node.left = node2;
        node.right = node3;
        BstToDoublyList bstToDoublyList = new BstToDoublyList();
        bstToDoublyList.bstToDoublyList(root);
    }

}
