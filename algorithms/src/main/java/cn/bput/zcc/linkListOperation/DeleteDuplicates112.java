package cn.bput.zcc.linkListOperation;

/**
 * Created by 张城城 on 2018/1/26.
 */
public class DeleteDuplicates112 {

    public ListNode deleteDuplicates(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode p = head;
        while(p.next!=null){
            if(p.val==p.next.val){
                ListNode tmp = p.next;
                p.next = tmp.next;
                tmp=null;
            }else {
                p=p.next;
            }
        }
        return head;
    }
}
