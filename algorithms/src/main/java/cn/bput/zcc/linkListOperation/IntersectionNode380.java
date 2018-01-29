package cn.bput.zcc.linkListOperation;

import java.util.List;

/**
 * Created by 张城城 on 2018/1/29.
 */
public class IntersectionNode380 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA==null || headB==null) return null;
        ListNode pA=headA;
        ListNode pB=headB;
        int A=0;
        int B=0;
        while(pA!=null){
            A++;
            pA = pA.next;
        }
        while (pB!=null){
            B++;
            pB=pB.next;
        }
        pA = headA;
        pB = headB;
        if(A>B){
            int flag = A-B;
            while(flag>0){
                pA = pA.next;
                flag--;
            }
        }else if (A<B){
            int flag = B-A;
            while(flag>0){
                pB =pB.next;
                flag--;
            }
        }
        int result = A < B ? A:B;
        while (result>0){
            if(pA.val==pB.val) return pA;
            result--;
            pA = pA.next;
            pB = pB.next;
        }
        return null;
    }
}
