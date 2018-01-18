package cn.bput.zcc.stackOperation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by 张城城 on 2018/1/18.
 */
public class EvalRPN424 {

    public int evalRPN(String[] tokens){

        Set<String> set = new HashSet<String>(Arrays.asList("+","-","/","*"));
        Stack<Integer> stack = new Stack<Integer>();
        for(String s : tokens){
            if(!set.contains(s)){
                stack.push(Integer.valueOf(s));
            }else {
                int a = stack.pop();
                int b = stack.pop();
                int c = 0;
                if(s.equals("+")){
                    c = a+b ;
                }else if(s.equals("-")){
                    c = b-a ;
                }else if(s.equals("/")){
                    c = b/a ;
                }else if(s.equals("*")) {
                    c = a*b ;
                }
                stack.push(c);
            }
        }
        return stack.pop();
    }
}
