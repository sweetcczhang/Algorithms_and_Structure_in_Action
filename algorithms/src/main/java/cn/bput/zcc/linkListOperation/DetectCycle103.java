package cn.bput.zcc.linkListOperation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 张城城 on 2018/1/24.
 */
public class DetectCycle103 {
    public Map map = new HashMap();
    /**
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head){
        if(head==null || head.next==null) return null;
        ListNode fast = head;
        ListNode slow =head;
        while(slow!=null){
            if(fast==null || fast.next==null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)  break;
        }
        ListNode find = head;
        if(slow!=null){
            while(true){
                slow = slow.next;
                find = find.next;
                if(find == slow) return slow;
            }
        }
        return null;
    }
}
