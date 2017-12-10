package cn.bput.zcc.depthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张城城 on 2017/12/10.
 */
public class Combine152 {

    public List<List<Integer>> combine(int n, int k){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(n<0 || k<0 || n<k) return result;
        dfs(n, k, 1, result, list);
        return result;
    }

    public void dfs(int n, int k, int start, List<List<Integer>> result, List<Integer> list){
         if(list.size()==k){
             List<Integer> temp = new ArrayList<Integer>(list);
             if(!result.contains(temp)){
                 result.add(temp);
             }
         }
         for(int i=start;i<=n; i++){
             list.add(i);
             dfs(n, k, i+1, result, list);
             list.remove(list.size()-1);
         }
    }

    public static void main(String[] args){
        Combine152 combine152 = new Combine152();
        combine152.combine(1,1);
    }
}
