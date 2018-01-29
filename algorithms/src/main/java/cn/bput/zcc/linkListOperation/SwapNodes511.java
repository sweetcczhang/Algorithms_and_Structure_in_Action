package cn.bput.zcc.linkListOperation;

/**
 * Created by 张城城 on 2018/1/29.
 */
public class SwapNodes511 {
    /**
     * 题目描述：交换链表中两个节点
     * 解题思路中：本题并不难，但是在解题的过程中需要注意一个坑。即查找的两个节点是相邻的
     * 两个节点时，需要进行特殊的处理。
     * 所以解此题的时候需要判断查找的两个节点是否相邻的节点~
     * @param head
     * @param v1
     * @param v2
     * @return
     */
    public ListNode swapNode(ListNode head, int v1, int v2){
        if(head==null || head.next==null) return head;
        ListNode node = new ListNode(-1);
        node.next = head;
        head = node;
        ListNode p1 = head.next;
        ListNode p2 = head.next;
        ListNode head1 = head;
        ListNode head2 = head;
        ListNode node1 =null;
        ListNode node2 =null;
        while(p1!=null){
            if(p1.val==v1){
                node1 = p1;
                break;
            }
            p1 = p1.next;
            head1 = head1.next;
        }
        while (p2!=null){
            if(p2.val==v2){
                node2 = p2;
                break;
            }
            p2 = p2.next;
            head2 = head2.next;
        }

        if(node1!=null && node2!=null){
            if(node1.next==node2){
               ListNode next = node2.next;
                node2.next =node1;
                node1.next = next;
                head1.next = node2;
            }else if(node2.next==node1){
                    ListNode next = node1.next;
                node1.next = node2;
                node2.next = next;
                head2.next = node1;
            }else {
                ListNode s1 = node1.next;
                node1.next = node2.next;
                head2.next = node1;
                node2.next =s1;
                head1.next = node2;
            }
        }
        return head.next;

    }
    public static void main(String[] args){
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        SwapNodes511 swapNodes511 = new SwapNodes511();
        swapNodes511.swapNode(node,2,3);
    }
}
