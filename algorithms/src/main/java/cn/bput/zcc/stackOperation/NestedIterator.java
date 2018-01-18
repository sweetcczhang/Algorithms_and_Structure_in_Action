package cn.bput.zcc.stackOperation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 张城城 on 2018/1/18.
 */
public class NestedIterator implements Iterator<Integer> {

    List<Integer> list;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<Integer>();
        search(nestedList);

        // Initialize your data structure here.
    }

    public void search(List<NestedInteger> nestedIntegerList){
        for(NestedInteger nestedInteger: nestedIntegerList){
            if(nestedInteger.isInteger()){
                list.add(nestedInteger.getInteger());
            }else {
                search(nestedInteger.getList());
            }
        }
    }

    public boolean hasNext() {
        Iterator it = list.iterator();
        return it.hasNext();
    }

    public Integer next() {
        Iterator it = list.iterator();
        int m = (Integer) it.next();
        list.remove(0);
        return m;
    }

    public void remove() {

    }
    public interface NestedInteger {

         // @return true if this NestedInteger holds a single integer,
         // rather than a nested list.
         public boolean isInteger();

         // @return the single integer that this NestedInteger holds,
         // if it holds a single integer
         // Return null if this NestedInteger holds a nested list
         public Integer getInteger();

         // @return the nested list that this NestedInteger holds,
         // if it holds a nested list
         // Return null if this NestedInteger holds a single integer
         public List<NestedInteger> getList();
 }
}

