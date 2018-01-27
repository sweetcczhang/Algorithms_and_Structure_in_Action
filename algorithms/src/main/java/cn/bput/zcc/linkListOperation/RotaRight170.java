package cn.bput.zcc.linkListOperation;

/**
 * Created by 张城城 on 2018/1/27.
 */
public class RotaRight170 {
    public ListNode rotaRight(ListNode head, int k){
        if(head==null) return head;
        ListNode p = head;
        int n =0;
        while(p!=null){
            n++;
            p = p.next;
        }
        int flag = k%n;
        if(flag==0) return head;
        int count = n-flag;
        p = head;
        ListNode last = null;
        while(count>0){
            last = p;
            p = p.next;
            count--;
        }
        last.next =null;
        ListNode end = p;
        while(end.next!=null){
            end = end.next;
        }
        end.next = head;
        return p;
    }
    public static void main(String[] args){
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node.next=node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        RotaRight170 right170 = new RotaRight170();
        right170.rotaRight(node, 1);
    }
}
