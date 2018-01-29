package cn.bput.zcc.linkListOperation;

/**
 * Created by 张城城 on 2018/1/29.
 */
public class DeleteNode372 {

    public void deleteNode(ListNode node){
        if(node==null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
