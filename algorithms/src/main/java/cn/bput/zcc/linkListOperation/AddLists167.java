package cn.bput.zcc.linkListOperation;

/**
 * Created by 张城城 on 2018/1/27.
 */
public class AddLists167 {
    public ListNode addLists(ListNode l1, ListNode l2){
        if(l1==null&&l2==null) return null;
        if(l1 ==null) return l2;
        if(l2 ==null) return l1;
        ListNode head = new ListNode(-1);
        ListNode node = head;
        int flag = 0;
        while(l1!=null && l2!=null){
            int val = l1.val+l2.val;
            int value = (val+flag)%10;
            ListNode node1 = new ListNode(value);
            head.next=node1;
            head = head.next;
            flag = (val+flag)/10;
            l1=l1.next;
            l2=l2.next;
        }
        if(l1!=null){
            while(l1!=null && flag>0){
                int val = l1.val+flag;
                int value = val%10;
                flag=val/10;
                l1.val = value;
                head.next=l1;
                l1=l1.next;
                head = head.next;
            }
            if(l1!=null){
                head.next=l1;
            }
        }
        else if(l2!=null){
            while(l2!=null && flag>0){
                int val = l2.val+flag;
                int value = val%10;
                flag = val/10;
                l2.val = value;
                head.next=l2;
                l2 = l2.next;
                head = head.next;
            }

            if(l2!=null){
                head.next = l2;
            }
        }
        if(flag>0){
            ListNode node1 = new ListNode(flag);
            head.next = node1;
        }
        return node.next;
    }
}
