package cn.bput.zcc.linkListOperation;


/**
 * Created by 张城城 on 2018/1/24.
 */
public class HasCycle102 {
    public boolean hasCycle(ListNode head){
        if(head==null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (slow!=null){
            if(fast==null || fast.next==null) return false;
            fast = fast.next.next;
            slow =slow.next;
            if(fast==slow) return true;
        }
        return false;
    }
    public static void main(String[] args){
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(-1);
        node.next=node1;
        HasCycle102 hasCycle102 = new HasCycle102();
        hasCycle102.hasCycle(node);
    }
}
