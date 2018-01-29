package cn.bput.zcc.linkListOperation;

/**
 * Created by 张城城 on 2018/1/29.
 */
public class RemoveElements452 {
    public ListNode removeElements(ListNode head, int val){
        if(head==null) return head;
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode fast = head;
        head = node;
        while(fast!=null){
            if(fast.val==val){
                node.next = fast.next;
                fast = fast.next;
            }else {
                fast= fast.next;
                node = node.next;
            }
        }
        return head.next;
    }
}
