package cn.bput.zcc.hashtableOperation;

import cn.bput.zcc.linkListOperation.ListNode;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.*;

/**
 * Created by 张城城 on 2018/2/2.
 */
public class MissingString684 {
    public List<String> missingString(String str1, String str2){
        if(str1==null && str2==null) return null;
        if(str1.length()>str2.length()){
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        String [] s1 = str1.split(" ");
        String [] s2 = str2.split(" ");
        List<String> list = new ArrayList<String>();
        HashSet<String> set = new HashSet<String>();
        for(String s : s1){
            set.add(s);
        }
        for(String s : s2){
            if(!set.contains(s)){
                list.add(s);
            }
        }

      return list;
    }
}
