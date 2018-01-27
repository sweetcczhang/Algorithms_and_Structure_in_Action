package cn.bput.zcc.linkListOperation;

/**
 * Created by 张城城 on 2018/1/27.
 */
public class AddLists167 {
    /**
     * 由于没有现在链表的长度，所以不能使用简便方法，先把两个链表转换成字符串
     * 然后相加之后再转换成链表。这样转换的整数会溢出超出java能表示的最大范围
     * 的整数
     * @param l1
     * @param l2
     * @return
     */
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
        ListNode result = null;
        if(l1!=null){
            result =l1;
        }
        if(l2!=null){
            result = l2;
        }
        while(result!=null && flag>0){
            int val = result.val+flag;
            int value = val%10;
            flag=val/10;
            result.val = value;
            head.next=result;
            result=result.next;
            head = head.next;
        }
            if(result!=null){
                head.next=result;
            }
        if(flag>0){
            ListNode node1 = new ListNode(flag);
            head.next = node1;
        }
        return node.next;
    }
}
