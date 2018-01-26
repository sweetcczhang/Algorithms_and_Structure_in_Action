package cn.bput.zcc.linkListOperation;

/**
 * Created by 张城城 on 2018/1/26.
 */
public class DeleteDuplicates113 {
    public ListNode deleteDuplicates(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode p = head;
        head = node;
        while(p.next!=null){
            if(p.val==p.next.val){
                ListNode tmp = p.next;
                while(tmp!=null && p.val==tmp.val){
                    tmp = tmp.next;
                }
                node.next = tmp;
                if(tmp==null){
                    break;
                }else {
                    p=tmp;
                }
            }else {
                node=node.next;
                p=p.next;
            }
        }

        return head.next;
    }
}
