package cn.bput.zcc.depthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis427 {

    /**
     * 采用递归树的思想
     * left：代表左括号的数量
     * right：代表右括号的数量
     * 如果路径中左括号的数量大于右括号的数量则非法操作
     * 如果left或者right的数量大于ze属于非法操作。
     *
     * @param n
     * @return
     */
    public List<String > generateParenthesis(int n){
        List<String> result = new ArrayList<String>();
        if(n==0)return result;
        dfs(n,"",0,0,result);
        return result;

    }

    public void dfs(int n,String path,int left,int right, List<String> result){
        if(left>n || right>n || left<right)
            return;
        if(left==n){
            for (int i=0;i<left-right;i++){
                path=path+")";
            }
            result.add(path);
            return;
        }
        //代表 left>=right的操作
        dfs(n,path+"(",left+1,right,result);
        dfs(n,path+")",left,right+1,result);
    }
}
