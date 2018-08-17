package cn.bput.zcc.SwordFingerOffer;

import java.util.Stack;

/**
 * Created by zcc
 * Date on 2018/8/8
 */
public class MinStack {

    private Stack<Integer> stack = new Stack<Integer>();

    private Stack<Integer> min = new Stack<Integer>();


    public void push(int node) {
        stack.push(node);

        if (min.isEmpty()){
            min.push(node);
            return;
        }
        int top = min.peek();

        if (top> node){
            min.push(node);
        }else {
            min.push(top);
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
