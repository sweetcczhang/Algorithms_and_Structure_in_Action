package cn.bput.zcc.linkListOperation;

/**
 * Created by 张城城 on 2018/1/29.
 */
public class SwapPairs451 {
    public ListNode swapPairs(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode fast = head;
        ListNode slow = node;
        while(fast!=null && fast.next!=null){
            ListNode tmp = fast.next.next;
            ListNode p = fast.next;
            fast.next=tmp;
            p.next = slow.next;
            slow.next = p;
            slow = fast;
            fast = tmp;
        }
        return node.next;
    }
    public static void main(String[] args){
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        SwapPairs451 swapPairs451 = new SwapPairs451();
        swapPairs451.swapPairs(node);
    }
}
