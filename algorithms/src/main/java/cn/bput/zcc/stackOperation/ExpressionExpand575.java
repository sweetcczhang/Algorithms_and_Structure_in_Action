package cn.bput.zcc.stackOperation;

import java.util.Stack;

/**
 * Created by 张城城 on 2018/1/20.
 */
public class ExpressionExpand575 {
    public String expresionExpand(String s){

        Stack<String> stack = new Stack<String>();
        int number = 0;
        for(char c: s.toCharArray()){
            if(c>='0'&&c<='9'){
                number = number*10+(c-'0');
            }else if(c=='['){
                stack.push(number+"");
                number=0;
            }else if(c==']'){
                String copy = popStack(stack);
                int count = Integer.valueOf(stack.pop());
                for(int i=0;i<count;i++){
                    stack.push(copy);
                }
            }else {
                stack.push(c+"");
            }
        }
        return popStack(stack);

    }
    public String popStack(Stack<String> stack){
        StringBuilder sb= new StringBuilder();
        while (!stack.isEmpty()&&!Character.isDigit(stack.peek().charAt(0))){
            sb.insert(0,stack.pop());
        }
        return sb.toString();
    }
}
