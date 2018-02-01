package cn.bput.zcc.hashtableOperation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 张城城 on 2018/2/1.
 */
public class IsIsomorphic638 {
    public boolean isIsomorphic(String s, String t){
        if(s==null && t==null) return true;
        if(s==null || t==null) return false;
        if(s.length()!=t.length()) return false;
        HashMap<Character,Character> map = new HashMap<Character, Character>();
        for(int i=0;i<s.length();i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            Character c = getValue(map, c2);
            if(c!=null && c!=c1) return false;
            if(map.containsKey(c1)){
                char value = map.get(c1);
                if(value!=c2) return false;
            }else {
                map.put(c1,c2);
            }
        }
        return true;
    }
    public Character getValue(HashMap<Character,Character> map, char value){
        for(Map.Entry<Character,Character> entry: map.entrySet()){
            if(entry.getValue().equals(value)){
                return entry.getKey();
            }
        }
        return null;
    }
}
