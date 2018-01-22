package cn.bput.zcc.linkListOperation;

/**
 * Created by 张城城 on 2018/1/21.
 */
public class Reverse35 {

    public ListNode reverse(ListNode head){
        if(head==null) return  null;
        ListNode listNode = new ListNode(head.val);
        while(head.next!=null){
            ListNode listNode1 = new ListNode(head.next.val);
            listNode1.next=listNode;
            listNode = listNode1;
            head = head.next;
        }
        return listNode;
    }

    /**
     * 原地链表翻转
     * @param head
     * @return
     */
    public ListNode reverse1(ListNode head){
        ListNode revHead = null;
        ListNode p = head;
        ListNode prev = null;
        while (p!=null){
            ListNode pNext = p.next;
            if(pNext==null){
                revHead = p;
            }
            p.next = prev;
            prev = p;
            p = pNext;
        }

        return head;
    }



    class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val=val;
            this.next = null;
        }
    }
}
