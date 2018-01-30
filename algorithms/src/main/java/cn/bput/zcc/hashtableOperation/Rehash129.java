package cn.bput.zcc.hashtableOperation;

import cn.bput.zcc.linkListOperation.ListNode;

/**
 * Created by 张城城 on 2018/1/30.
 */
public class Rehash129 {
    public ListNode[] rehashing(ListNode[] hashTable){
        if(hashTable==null || hashTable.length==0) return hashTable;
        ListNode[] hash = new ListNode[hashTable.length*2];
        int len = hashTable.length;
        int capacity = len*2;
        for(int i=0;i<len;i++){
            ListNode tmp = hashTable[i];
            if(tmp!=null){
                while(tmp!=null){
                    ListNode value= tmp;
                    tmp = tmp.next;
                    int key = hashcode(value.val,capacity);
                    if(hash[key]==null){
                        hash[key]= value;
                        value.next=null;
                    }else {
                        ListNode h= hash[key];
                        while (h.next!=null){
                            h=h.next;
                        }
                        h.next=value;
                        value.next=null;
                    }
                }
            }
        }
        return hash;
    }
    public int hashcode(int key, int capacity){
        return (key%capacity+capacity)%capacity;
    }
}
