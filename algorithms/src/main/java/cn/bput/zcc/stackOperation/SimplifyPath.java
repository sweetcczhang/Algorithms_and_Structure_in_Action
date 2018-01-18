package cn.bput.zcc.stackOperation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by 张城城 on 2018/1/18.
 */
public class SimplifyPath {
    /**
     * 题目：给定一个文档(Unix-style)的完全路径，请进行路径简化。
     * 解题思路：
     * 使用"/"对路径进行分割，使用一个栈对路径进行存放，如果遇到".."且栈不为空就出站一个。如果路径不是“"..",".",""”
     * 就入栈。
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        // write your code here
        Stack<String> stack = new Stack<String>();
        Set<String> set = new HashSet<String>(Arrays.asList("..",".",""));
        for(String dir: path.split("/")){
            if(dir.equals("..")&&!stack.isEmpty()){
                stack.pop();
            }else if(!set.contains(dir)){
                stack.push(dir);
            }
        }
        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
            sb.insert(0,"/");
        }

        return sb.length()==0 ? "/":sb.toString();
    }
}
