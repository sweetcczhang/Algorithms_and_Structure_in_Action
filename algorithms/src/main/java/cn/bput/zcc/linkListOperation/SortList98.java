package cn.bput.zcc.linkListOperation;

/**
 * Created by 张城城 on 2018/1/23.
 */
public class SortList98 {

    public ListNode sortList(ListNode head){
        if(head==null || head.next==null) return head;
         ListNode mid = findMid(head);
         ListNode right = mid.next;
         mid.next =null;
         ListNode left = head;
         ListNode hleft = sortList(left);
         ListNode hright = sortList(right);
        return  merge(hleft,hright);
    }
    public ListNode findMid(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public ListNode merge(ListNode left, ListNode right){
        if(left==null || right==null) return null;
        ListNode node = new ListNode(0);
        ListNode dummy = node;
        while (left!=null && right!=null){
            if(left.val<right.val){
                ListNode tmp = left;
                left = left.next;
                dummy.next = tmp;
                dummy = dummy.next;
            }else {
                ListNode tmp = right;
                right = right.next;
                dummy.next = tmp;
                dummy = dummy.next;
            }
        }
        if(left!=null){
            dummy.next=left;
        }else {
            dummy.next=right;
        }
        return node.next;
    }
    public static void main(String[] args){
        SortList98 m = new SortList98();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(-1);
        listNode.next = listNode1;
        m.sortList(listNode);

    }

}

