package cn.bput.zcc.stackOperation;

import java.util.Stack;

/**
 * Created by 张城城 on 2018/1/21.
 */
public class LargestRectangleArea122 {
    public int largestRectangleArea(int[] height){
        if(height==null || height.length==0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int max =0;
        int len = height.length;
        int i =0;
        while (i<=len){
            if(stack.isEmpty() || (i<len && height[i]>= height[stack.peek()])){
                stack.push(i);
                i++;
            }else {
                int h = height[stack.pop()];
                int width = stack.isEmpty()? i:i- stack.peek()-1;
                max = Math.max(max, h*width);
            }
        }

        return max;
    }
}
