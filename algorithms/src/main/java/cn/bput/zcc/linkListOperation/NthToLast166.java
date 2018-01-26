package cn.bput.zcc.linkListOperation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张城城 on 2018/1/26.
 */
public class NthToLast166 {
    public ListNode nthToLast(ListNode head, int n){
        if(head == null) return head;
        ListNode p = head;
        int i =0;
        while(p!=null){
            i++;
            p = p.next;
        }
        if(i<n) return null;
        int flag = i-n;
        ListNode q = head;
        while(flag>0){
            q = q.next;
            flag--;
        }

        return q;
    }
}
