package cn.bput.zcc.hashtableOperation;

import java.util.*;

/**
 * Created by 张城城 on 2018/2/5.
 */
public class FindRepeatedDna774 {
    public List<String> findRepeatedDna(String s){
        List<String > result = new ArrayList<String>();
        HashSet<String> set = new HashSet<String>();
        if(s==null) return null;
        if(s.length()==0) return result;
        for(int i=0; i<s.length()-10;i++){
            String c = s.substring(i,i+10);
            if(!set.contains(c)){
                for(int j=i+1; j<=s.length()-10;j++){
                    String t = s.substring(j,j+10);
                    if(c.equals(t)){
                        set.add(c);
                        break;
                    }
                }
            }
        }
        Iterator<String > it = set.iterator();
        while(it.hasNext()){
            result.add(it.next());
        }

        return result;
    }
    public static void main(String[] args){
        String s= "";
        FindRepeatedDna774 f = new FindRepeatedDna774();
        f.findRepeatedDna(s);
    }
}
