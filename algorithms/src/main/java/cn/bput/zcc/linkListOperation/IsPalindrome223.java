package cn.bput.zcc.linkListOperation;

/**
 * Created by 张城城 on 2018/1/27.
 */
public class IsPalindrome223 {
    /**
     * 一刷没有ac，内存溢出
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head){
        if(head==null || head.next==null) return true;
        ListNode p =head;
        String num1="";
        String num2="";
        while (p!=null){
            num1 +=p.val;
            num2 = p.val+num2;
            p=p.next;
        }
        if(num1.equals(num2)) return true;
        return false;
    }
    public boolean isPalindrome2(ListNode head){
        if(head==null || head.next==null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHead = slow.next;
        slow.next = null;
        ListNode p1 = secondHead;
        ListNode p2 = p1.next;
        p1.next = null;
        while (p1!=null && p2!=null){
            ListNode tmp = p2.next;
            p2.next = p1;
            p1=p2;
            p2 = tmp;
        }
        secondHead.next = null;
        secondHead = p1;
        while(head!=null && secondHead!=null){
            if(head.val!=secondHead.val) return false;
            head = head.next;
            secondHead = secondHead.next;
        }
        return true;
    }
}
