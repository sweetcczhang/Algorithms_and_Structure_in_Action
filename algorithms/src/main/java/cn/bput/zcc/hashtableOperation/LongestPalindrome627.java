package cn.bput.zcc.hashtableOperation;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

/**
 * Created by 张城城 on 2018/1/31.
 */
public class LongestPalindrome627 {
    public int longestPalindrome(String s){
        if(s==null) return 0;
        if(s.length()<=1) return s.length();
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        for(int i =0;i<s.length();i++){
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else {
                map.put(s.charAt(i),1);
            }
        }
        int simple =0;
        int result =0;
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            if(entry.getValue()%2==0){
                result += entry.getValue();
            }else {
                    if(entry.getValue()>1){
                        result +=(entry.getValue()-1);
                    }
                    simple++;
            }
        }
        if(simple>0){
            result=result+1;
        }
        return result;
    }
    public static void main(String[] args){
        String s= "NTrQdQGgwtxqRTSBOitAXUkwGLgUHtQOmYMwZlUxqZysKpZxRoehgirdMUgy";
        LongestPalindrome627 longestPalindrome627 = new LongestPalindrome627();
        longestPalindrome627.longestPalindrome(s);
    }
}
