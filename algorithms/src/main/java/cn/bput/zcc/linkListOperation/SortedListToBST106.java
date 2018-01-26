package cn.bput.zcc.linkListOperation;

import cn.bput.zcc.treeOperation.TreeNode;

/**
 * Created by 张城城 on 2018/1/25.
 */
public class SortedListToBST106 {
    /**
     * 解题的过程使用了二分查找法，找到链表的中点然后递归构建二叉查找树
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head){
        if(head==null) return null;
        if(head.next==null) return new TreeNode(head.val);
        ListNode left = head;
        ListNode last = findMid(left);
        ListNode mid = last.next;
        TreeNode root = new TreeNode(mid.val);
        TreeNode node = root;
        ListNode right = mid.next;
        last.next = null;
        TreeNode trRight = sortedListToBST(right);
        if(trRight!=null){
            node.right = trRight;
        }
        //找到left半边
        if(left!=mid){
            TreeNode trLeft=sortedListToBST(left);
            if(trLeft!=null){
                node.left = trLeft;
            }
        }
        return root;
    }

    public ListNode findMid(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode last = head;
        while(fast.next!=null && fast.next.next!=null){
            last = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return last;
    }
    public static void main(String[] args){
        SortedListToBST106 bst106 = new SortedListToBST106();
        ListNode node = new ListNode(-1);
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        node.next = node1;
        bst106.sortedListToBST(node);
    }
}
