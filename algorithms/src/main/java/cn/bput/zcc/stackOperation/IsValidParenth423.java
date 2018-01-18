package cn.bput.zcc.stackOperation;

import java.util.*;

/**
 * Created by 张城城 on 2018/1/18.
 */
public class IsValidParenth423 {
    public boolean isValidParentheses(String s) {
        // write your code here
        Stack<Integer> stack = new Stack<Integer>();
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        map.put('(',1);
        map.put('{',2);
        map.put('[',3);
        Map<Character,Integer> mapRight = new HashMap<Character, Integer>();
        mapRight.put(')',1);
        mapRight.put('}',2);
        mapRight.put(']',3);
        Set<Character> set = new HashSet<Character>(Arrays.asList('{','[','('));
        for(char c : s.toCharArray()){
            if(set.contains(c)){
                stack.push(map.get(c));
            }else if(!stack.isEmpty()) {
                int a = stack.pop();
                if(a!=mapRight.get(c)){
                    return false;
                }
            }else {
                return false;
            }
        }
        if(stack.isEmpty()) return true;

        return false;
    }
}

