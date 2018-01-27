package cn.bput.zcc.linkListOperation;

import java.util.List;

/**
 * Created by 张城城 on 2018/1/27.
 */
public class InsertionSortList173 {
    public ListNode insertionSortList(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode listNode = new ListNode(-1);
        ListNode p = head;
        ListNode node = listNode;
        while(p!=null){
            ListNode h = p.next;
            while(node.next!=null){
                ListNode tmp = node.next;
                if(tmp.val>=p.val){
                    break;
                }
                node = tmp;
            }
            p.next=node.next;
            node.next = p;
            node=listNode;
            p = h;

        }
        return listNode.next;
    }
}
