package cn.bput.zcc.hashtableOperation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 张城城 on 2018/2/2.
 */
public class ConcatenetedString702 {
    public String concatenetedString(String s1, String s2){
        if(s1==null && s2==null) return null;
        if(s1==null) return s2;
        if(s2==null) return s1;
        HashSet<Character> set2 = new HashSet<Character>();
        HashSet<Character> set1 = new HashSet<Character>();
        String result ="";
        for(int i=0;i<s2.length();i++){
            set2.add(s2.charAt(i));
        }
        for(int i =0;i<s1.length();i++){
            Character c = s1.charAt(i);
            if(!set2.contains(c)){
                result += c;
            }else {
                set1.add(c);
            }
        }
        for(int i =0;i<s2.length();i++){
            Character c = s2.charAt(i);
            if(!set1.contains(c)){
                result +=c;
            }
        }
        return result;
    }
}
