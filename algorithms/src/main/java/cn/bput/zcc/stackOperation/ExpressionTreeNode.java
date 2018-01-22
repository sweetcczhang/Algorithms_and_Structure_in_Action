package cn.bput.zcc.stackOperation;

import java.util.Stack;

/**
 * Created by 张城城 on 2018/1/21.
 */
public class ExpressionTreeNode {
    public String symbol;
    public ExpressionTreeNode left;
    public ExpressionTreeNode right;
    public ExpressionTreeNode(String symbol){
        this.symbol = symbol;
        this.left= this.right=null;
    }
    public ExpressionTreeNode(){

    }

    public ExpressionTreeNode build(String[] expression){
        if(expression == null || expression.length == 0) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int base = 0;
        int val = 0;
        for(int i=0; i<expression.length; i++){
            if(expression[i].equals("(")){
                base +=10;
                continue;
            }
            if(expression[i].equals(")")){
                base -=10;
                continue;
            }
            val = getWeight(base, expression[i]);
            TreeNode node = new TreeNode(val, expression[i]);
            while (!stack.isEmpty() && node.val<=stack.peek().val){
                node.eNode.left = stack.pop().eNode;
            }
            if(!stack.isEmpty()){
                stack.peek().eNode.right= node.eNode;
            }
            stack.push(node);
        }
        if(stack.isEmpty()){
            return null;
        }
        TreeNode rst = stack.pop();
        while ((!stack.isEmpty())){
            rst = stack.pop();
        }
        return  rst.eNode;
    }

    public int getWeight(int base, String s){
        if(s.equals("/") || s.equals("*")){
            return base+2;
        }
        if(s.equals("+") || s.equals("-")){
            return base + 1;
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args){
        ExpressionTreeNode expressionTreeNode=new ExpressionTreeNode();
        String[] expression=new String[]{"2","*","6","-","(","23","+","7",")","/","(","1","+","2",")"};
        expressionTreeNode.build(expression);
    }

    class TreeNode{
        int val;
        ExpressionTreeNode eNode;
        public TreeNode(int val, String s){
            this.val = val;
            eNode = new ExpressionTreeNode(s);
        }
    }
}
