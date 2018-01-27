package cn.bput.zcc.linkListOperation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 张城城 on 2018/1/27.
 */
public class LRUCache {
    private int capacity;
    Map<Integer,CacheNode> data;
    private CacheNode head ;
    private CacheNode tail;
    public LRUCache(int capacity) {
        this.capacity =capacity;
        data = new HashMap<Integer, CacheNode>();
        head = new CacheNode(-1,-1);
        tail = new CacheNode(-1,-1);
        tail.pre = head;
        head.next = tail;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if(!data.containsKey(key)) return -1;
        CacheNode current = data.get(key);
        current.pre.next = current.next;
        current.next.pre = current.pre;
        move_to_tail(current);
        return data.get(key).value;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if(get(key)==-1) {
            data.get(key).value =value;
            return;
        }
       if(data.size()==capacity){
           data.remove(head.next.key);
           head.next = head.next.next;
           head.next.pre = head;
        }
        CacheNode node = new CacheNode(key,value);
        data.put(key,node);
        move_to_tail(node);
    }

    public void move_to_tail(CacheNode current){
        current.pre = tail.pre;
        tail.pre = current;
        current.pre.next = current;
        current.next = tail;
    }

    private class CacheNode{
        int key;
        int value;
        CacheNode pre,next;
        public CacheNode(int key, int value){
            this.key =key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
    }
}
