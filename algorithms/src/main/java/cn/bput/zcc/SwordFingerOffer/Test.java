package cn.bput.zcc.SwordFingerOffer;

import cn.bput.zcc.linkListOperation.ListNode;

/**
 * Created by zcc
 * Date on 2018/8/14
 */
public class Test {
//    public static ListNode reverseKGroup(ListNode head, int k) {
//        if(head ==null || head.next==null) return head;
//        ListNode p = new ListNode(-1);
//        ListNode l = head;
//        while(k>0 && l!=null){
//            ListNode next = l.next;
//            l.next = p.next;
//            p.next = l;
//            l = next;
//            k--;
//        }
//        head.next = l;
//        return p.next;
//    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        int count=0;
        ListNode cur= head;
        while(cur!=null){
            count++;
            cur = cur.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode s=dummy, e = dummy.next;
        for(int i=count;i>=k;i-=k){
            for(int j=1;j<k;j++){
                ListNode next = e.next;
                e.next = next.next;
                next.next=s.next;
                s.next=next;
            }
            s =e;
            e=e.next;
        }
        return dummy.next;
    }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node2.next = node3;
        node1.next = node2;
        node.next = node1;
        head.next = node;
        reverseKGroup(head,2);
    }
}
