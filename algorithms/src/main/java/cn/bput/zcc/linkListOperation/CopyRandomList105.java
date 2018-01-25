package cn.bput.zcc.linkListOperation;

/**
 * Created by 张城城 on 2018/1/25.
 */
public class CopyRandomList105 {
    /**
     * 题目：复制带随机指针的链表
     * 描述：给出一个链表，每个节点包含一个额外增加的随机指针可以指向链表中的任何节点或空的节点
     * 返回一个深拷贝的指针~
     * 解题思路：主要是把新链表和旧链表链接起来，通过把新旧链表链接起来来复制random指针。
     * http://www.cppblog.com/yuech/archive/2011/04/02/143318.html
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head){
        if(head==null) return null;
        RandomListNode p = head;
        while(p!=null){
            RandomListNode tmp = new RandomListNode(p.label);
            RandomListNode heada = p.next;
            tmp.next = p.next;
            p.next = tmp;
            p=heada;
        }
        p = head;
        while(p!=null){
            if(p.random!=null){
                p.next.random =p.random.next;
            }else {
                p.next.random =null;
            }
            p=p.next.next;
        }
        p = head;
        RandomListNode q = p.next, result=p.next;
        while(q.next!=null){
            p.next = q.next;
            p=p.next;
            q.next = p.next;
            q=q.next;
        }
        return result;
    }
}
