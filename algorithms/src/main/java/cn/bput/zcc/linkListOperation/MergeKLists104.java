package cn.bput.zcc.linkListOperation;

import java.util.List;
import java.util.prefs.NodeChangeEvent;

/**
 * Created by 张城城 on 2018/1/25.
 */
public class MergeKLists104 {
    public ListNode mergeKLists(List<ListNode> lists){
        if(lists==null || lists.size()<1) return null;
        if(lists.size()<2) return lists.get(0);
        ListNode head = lists.get(0);
        ListNode  node =null;
        for(int i=1; i<lists.size();i++){
            node = merge(head, lists.get(i));
            head = node;
        }
        return node;
    }
    public ListNode merge(ListNode left, ListNode right){
        if(left ==null && right==null) return null;
        if(left ==null) return right;
        if(right == null) return  left;
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (left!=null && right!=null){
            ListNode tmp;
            if(left.val<right.val){
                tmp = left.next;
                left.next =null;
                head.next=left;
                head = head.next;
                left = tmp;
            }else {
                tmp = right.next;
                right.next = null;
                head.next = right;
                head = head.next;
                right = tmp;
            }
        }
        if(left!=null){
            head.next=left;
        }
        if(right!=null){
            head.next = right;
        }
        return node.next;
    }
}
