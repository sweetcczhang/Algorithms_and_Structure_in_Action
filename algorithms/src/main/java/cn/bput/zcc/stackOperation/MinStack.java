package cn.bput.zcc.stackOperation;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 张城城 on 2018/1/11.
 */
public class MinStack {
    List<Integer> data;
    List<Integer> mindata;
    int length;
    int min;
    public MinStack(){
        data = new LinkedList<Integer>();
        mindata = new LinkedList<Integer>();
        length = 0;
        min = Integer.MAX_VALUE;
    }

    public void push(int number){
        data.add(number);
        length++;
        if(number<=min){
            if(length!=1){
                mindata.add(min);
            }
            min = number;
        }

    }

    public int pop(){
        if(length>0){
            length--;
            int s = data.remove(length);
            if(s==min && length>0){
                min = mindata.remove(mindata.size()-1);
            }
            if(length==0){
                min = Integer.MAX_VALUE;
            }
            return s ;
        }
        return 0;
    }

    public int min(){
        if (length>0)
            return min;
      return 0 ;
    }
    public void test(){
        push(-1);
        push(-2);
        min();
        pop();
        push(-3);
        push(3);
        push(2);
        pop();
        pop();
        pop();
        pop();
        push(400);
        push(3);
        push(200);
        push(1);
        min();
        pop();
        min();
    }
    public static void main(String[] args){
            MinStack minStack = new MinStack();
        minStack.test();
    }
}
