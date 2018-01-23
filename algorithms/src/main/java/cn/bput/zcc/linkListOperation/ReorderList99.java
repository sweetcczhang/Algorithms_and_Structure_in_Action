package cn.bput.zcc.linkListOperation;

/**
 * Created by 张城城 on 2018/1/23.
 */
public class ReorderList99 {
    public void reorderList(ListNode head){
        if(head==null || head.next==null) return;
        ListNode mid = findMid(head);
        ListNode right = mid.next;
        mid.next =null;
        ListNode newRight = reverse(right);
        ListNode left = head;
        while (newRight!=null){
            ListNode tmp = newRight.next;
            newRight.next= left.next;
            left.next=newRight;
            left = left.next.next;
            newRight = tmp;
        }


    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode revHead = null;
        ListNode p = head;
        while (p!=null){
            ListNode pNext = p.next;
            if(pNext==null){
                revHead = p;
            }
            p.next = prev;
            prev = p;
            p = pNext;
        }

        return revHead;
    }

    public ListNode findMid(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode test=null;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
