package cn.bput.zcc.hashtableOperation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 张城城 on 2018/1/30.
 */
public class MinWindows {
    public String minWindow(String source, String target){
        int lenS = source.length();
        int lenT = target.length();
        if(lenS<lenT) return "";
        String result = "";
        Map<Character,Integer> tar = new HashMap<Character, Integer>();
        Map<Character,Integer> sou = new HashMap<Character, Integer>();
        for(int i=0; i<lenT;i++){
            char c = target.charAt(i);
            if(tar.containsKey(c)){
                tar.put(c,tar.get(c)+1);
            }else {
                tar.put(c,1);
            }
        }
        int left = 0;
        int minLen = lenS+1;
        int count =0;
        for(int i=0;i<lenS;i++){
            char c = source.charAt(i);
            if(tar.containsKey(c)){
                if(sou.containsKey(c)){
                    if(sou.get(c)<tar.get(c)){
                        count++;
                    }
                    sou.put(c, sou.get(c)+1);
                }else {
                    sou.put(c,1);
                    count++;
                }
            }
         if(count==lenT){
             char sc = source.charAt(left);
             while(!sou.containsKey(sc) || sou.get(sc)>tar.get(sc)){
                 if(sou.containsKey(sc) && sou.get(sc)>tar.get(sc))
                     sou.put(sc, sou.get(sc)-1);
                 left++;
                 sc = source.charAt(left);
             }
             if(i-left+1<minLen){
                 result = source.substring(left,i+1);
                 minLen = i-left+1;
             }
         }
        }
        return result;
    }
}
