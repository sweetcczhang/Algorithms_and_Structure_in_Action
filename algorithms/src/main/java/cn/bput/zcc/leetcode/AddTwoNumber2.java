package cn.bput.zcc.leetcode;

import cn.bput.zcc.linkListOperation.ListNode;

public class AddTwoNumber2 {

    public ListNode addTwoNumber(ListNode l1, ListNode l2){

        ListNode result = new ListNode(0);
        int carry = 0;
        while (l1!=null || l2!=null){
            int q = l1!=null ? l1.val:0;
            int p = l2!=null ? l2.val:0;
            carry = (p+q+carry)/10;
            result.next = new ListNode((p+q+carry)%10);
            result = result.next;
            if (l1!=null) l1=l1.next;
            if (l2!=null) l2=l2.next;
        }
        if (carry>0){
            result.next = new ListNode(carry);
        }


        return result.next;

    }
}
