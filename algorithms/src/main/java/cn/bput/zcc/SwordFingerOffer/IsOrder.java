package cn.bput.zcc.SwordFingerOffer;

import java.util.Stack;

/**
 * Created by zcc
 * Date on 2018/8/8
 */
public class IsOrder {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<Integer>();
        if(pushA==null && popA==null) return true;
        if(pushA==null || popA==null) return false;
        if(pushA.length!=popA.length) return false;
        int nlength = pushA.length;
        int plength = 0;
        int i=0;
        while(i<nlength){
            stack.push(pushA[i]);
            while(!stack.isEmpty() && stack.peek()==popA[plength]){
                stack.pop();
                plength++;
            }
            if(plength == nlength) return true;
            i++;
        }
        return false;
    }

    public static void main(String[] args){

        int[]pushA ={1,2,3,4,5};
        int[]popA ={4,5,3,2,1};
        IsPopOrder(pushA,popA);

    }

}
