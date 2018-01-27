package cn.bput.zcc.linkListOperation;

/**
 * Created by 张城城 on 2018/1/27.
 */
public class AddLists221 {
    public ListNode addLists2(ListNode l1, ListNode l2){
        if(l1==null && l2==null) return null;
        if(l1 == null) return l2;
        if(l2 ==null) return l1;
        String num1 ="";
        String num2 = "";
        while(l1!=null){
            num1 =l1.val+num1;
            l1 = l1.next;
        }
        while (l2!=null){
            num2 = l2.val+num2;
            l2 =l2.next;
        }
        int n = num1.length()<num2.length()? num1.length():num2.length();
        int flag =0;
        ListNode head = new ListNode(-1);
        ListNode node = head;
        for(int i=0;i<n;i++){
            int tmp = Integer.valueOf(num1.charAt(i)+"")+ Integer.valueOf(num2.charAt(i)+"")+flag;
            int val = tmp%10;
            flag = tmp/10;
            ListNode node1 = new ListNode(val);
            node1.next = head.next;
            head.next = node1;
        }
        String result="";
        if(num1.length()>num2.length()) result = num1;
        if(num1.length()<num2.length()) result = num2;
        for(int i =n;i<result.length();i++){
            int tmp = Integer.valueOf(result.charAt(i)+"")+flag;
            int val = tmp%10;
            flag = tmp/10;
            ListNode node1 = new ListNode(val);
            node1.next = head.next;
            head.next = node1;
        }
        if(flag>0){
            ListNode node1 = new ListNode(flag);
            node1.next = head.next;
            head.next = node1;
        }
        return node.next;
    }
}
