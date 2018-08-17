package cn.bput.zcc.SwordFingerOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zcc
 * Date on 2018/8/9
 */
public class Permutation {

    public List<String> permutation(String str){
       List<String> result = new ArrayList<String>();
       ArrayList<Integer> path = new ArrayList<Integer>();
       return result;
    }
    public void dfs(String str,List<String> result, List<Integer> path){
        if (path.size()==str.length()){
            StringBuilder builder = new StringBuilder();
            for (int i =0;i<path.size();i++){
                builder.append(str.charAt(path.get(i))+"");
            }
            String s = builder.toString();
            if (!result.contains(s)){
                result.add(s);
            }
            return;
        }
        for (int i=0; i<str.length();i++){
            if (path.contains(i)){
                continue;
            }
            path.add(i);
            dfs(str,result,path);
            path.remove(path.size()-1);
        }

    }
}
