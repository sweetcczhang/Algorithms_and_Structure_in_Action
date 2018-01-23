package cn.bput.zcc.linkListOperation;

/**
 * Created by 张城城 on 2018/1/22.
 */
public class Partion96 {
    public ListNode partion (ListNode head, int x){


        ListNode before = new ListNode(0);
        before.next = head;
        head = before;
        ListNode now = null;
        ListNode end = null;
        ListNode newHead = head;

        while(newHead.next!=null){
            if(newHead.next.val<x){
                newHead=newHead.next;
            }else {
                end = newHead;
                now = newHead.next.next;
                newHead = newHead.next;
                break;
            }
        }

        while(now!=null){
            ListNode temp = now.next;
            if(now.val<x){
                now.next=end.next;
                end.next=now;
                end = now;
            }else {
                newHead.next=now;
                newHead = now;
                newHead.next=null;
            }
            now =temp;
        }

        return head.next;
    }

    public static void main(String[] args){
        ListNode node = new ListNode(1);
        ListNode node1= new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(2);
        node4.next=node5;
        node3.next=node4;
        node2.next = node3;
        node1.next = node2;
        node.next = node1;
        Partion96 partion96 = new Partion96();
        partion96.partion(node,3);

    }

}

