package cn.bput.zcc.hashtableOperation;

import java.util.*;

/**
 * Created by 张城城 on 2018/2/1.
 */
public class RandomizedSet {

    Map<Integer,Integer> map;
    List<Integer> list;
    public RandomizedSet(){
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
    }
    public boolean insert(int val) {
        // write your code here
        if(map.containsKey(val)) return false;
        else {
            list.add(val);
            map.put(val,list.size()-1);
        }
        return true;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        // write your code here
        if(!map.containsKey(val)) return false;
        if(map.containsKey(val)){
            int key = map.remove(val);
            list.set(key,list.get(list.size()-1));
            map.put(list.get(list.size()-1),key);
        }
        list.remove(list.size()-1);
        return true;
    }

    /*
     * @return: Get a random element from the set
     */
    Random r = new Random();
    public int getRandom() {
        // write your code here
        return list.get(r.nextInt(list.size()));
    }
}
