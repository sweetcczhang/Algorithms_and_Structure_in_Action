package cn.bput.zcc.dataStruck;

import java.util.Queue;
import java.util.Stack;

/**
 * Created by 张城城 on 2017/12/8.
 */
public class MyQueue40 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public  MyQueue40(){
    }
    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        int e;
        if(!stack2.empty()){
            e = stack2.pop();
            return e;
        }else {
            while (!stack1.empty()){
                int d = stack1.pop();
                stack2.push(d);
                System.out.println("d:"+d);
            }
        }
        e = stack2.pop();
        System.out.println("pop:"+e);
        return e;
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        int e;
        if(!stack2.empty()){
            e = stack2.lastElement();
            return e;
        }else {
           while (!stack1.empty()){
                int f = stack1.pop();
                stack2.push(f);
                System.out.println("f:"+f);
            }
        }
        e = stack2.lastElement();
        System.out.println("top:"+e);
        return e;
    }

    public static void main(String[] args){
        MyQueue40 myQueue40= new MyQueue40();
        myQueue40.push(1);
        myQueue40.pop();
        myQueue40.push(2);
        myQueue40.push(3);
        myQueue40.top();
        myQueue40.pop();
    }
}
