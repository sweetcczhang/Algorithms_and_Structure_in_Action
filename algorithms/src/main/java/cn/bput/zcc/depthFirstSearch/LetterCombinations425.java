package cn.bput.zcc.depthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations425 {
    public List<String> letterCombinations(String digits){
        List<String> result = new ArrayList<String>();
        String [] dicts = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        dfs(digits,0,"",dicts,result);
        return result;
    }
    public void dfs(String digits, int index,String out,String[] dicts,List<String> result){
        if(index==digits.length()){
            result.add(out);
            return;
        }
        int flag = Integer.valueOf(digits.charAt(index)+"")-2;
        String str =dicts[flag];
        for(int i=0; i<str.length();i++){
            out = out+str.charAt(i);
            dfs(digits,index+1,out,dicts,result);
            out = out.substring(0,out.length()-1);
        }
    }
}
