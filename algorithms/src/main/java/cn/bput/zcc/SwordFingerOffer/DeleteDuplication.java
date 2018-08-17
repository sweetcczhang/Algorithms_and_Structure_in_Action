package cn.bput.zcc.SwordFingerOffer;

import cn.bput.zcc.linkListOperation.ListNode;

/**
 * Created by zcc
 * Date on 2018/8/7
 */
public class DeleteDuplication {

    public static ListNode deleteDuplication(ListNode pHead){
        if (pHead ==null || pHead.next==null) return pHead;

        ListNode head = new ListNode(-1);
        ListNode node = head;
        while (pHead!=null){
            ListNode next = pHead.next;
            boolean flag = false;
            if (next!=null && pHead.val==next.val){
                flag =true;
            }
            if (!flag){
                head.next = pHead;
                head = head.next;
                pHead = pHead.next;
                head.next=null;
            }else {
                int val = pHead.val;
                ListNode delNode = pHead;
                while (delNode!=null && delNode.val==val){
                    delNode = delNode.next;
                }
                pHead = delNode;
            }
        }

        return node.next;
    }

    public static  void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode node = head.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;
        node.next = new ListNode(5);
        System.out.print(head);
        deleteDuplication(head);
    }
}


