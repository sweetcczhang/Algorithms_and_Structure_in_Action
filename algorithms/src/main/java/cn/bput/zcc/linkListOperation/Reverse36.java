package cn.bput.zcc.linkListOperation;

/**
 * Created by 张城城 on 2018/1/22.
 */
public class Reverse36 {

    /**
     * 解决此题的关键是：要在节点的前面再添加一个头结点，使第一个节点也需要翻转的时候，
     * 和其他节点一样处理。
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n){

        if(m>=n || head==null) return head;
        ListNode before = new ListNode(0);
        before.next = head;
        head = before;
        for(int i=1; i<m; i++){
            if(head==null){
                return null;
            }
            head = head.next;
        }
        ListNode mNode = head.next;
        ListNode dangqiaoNode = mNode;
        ListNode next = mNode.next;
        ListNode mQainMianNode = head;
        for(int i=m;m<n;m++){
            if(next==null) return null;
            ListNode temp = next.next;
            next.next =dangqiaoNode;
            dangqiaoNode = next;
            next=temp;
        }
        mQainMianNode.next= dangqiaoNode;
        mNode.next = next;
        return before.next;
    }


    class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val=val;
            this.next = null;
        }
    }
}
