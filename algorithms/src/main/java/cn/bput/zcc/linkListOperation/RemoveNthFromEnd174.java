package cn.bput.zcc.linkListOperation;

/**
 * Created by 张城城 on 2018/1/27.
 */
public class RemoveNthFromEnd174 {
    public ListNode removeNthFromEnd(ListNode head, int n){
        if(head==null) return head;
        ListNode p = head;
        int size = 0;
        while (p!=null){
            size++;
            p=p.next;
        }
        ListNode listNode = new ListNode(-1);
        listNode.next=head;
        head = listNode;
        p=head;
        int flag = size-n;
        while(flag>0){
            p=p.next;
            flag--;
        }
        p.next=p.next.next;
        return head.next;
    }
}
