package cn.bput.zcc.depthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class Partition136 {
    public List<List<String>> partition(String s){
        List<String> list = new ArrayList<String>();
        List<List<String>> result = new ArrayList<List<String>>();
        dfs(s,0,result,list);
        return result;
    }
    public void dfs(String s,int index, List<List<String>> result, List<String > list){
        if(index == s.length()){
            List<String> temp = new ArrayList<String>(list);
            result.add(temp);
        }
        for(int i=index+1;i<=s.length();i++){
            String sub = s.substring(index,i);
            if (!isPartition(sub)) continue;
            list.add(sub);
            dfs(s,i,result,list);
            list.remove(list.size()-1);
        }
    }
    public boolean isPartition(String str){
        int start = 0;
        int end = str.length()-1;
        while(start<end){
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
