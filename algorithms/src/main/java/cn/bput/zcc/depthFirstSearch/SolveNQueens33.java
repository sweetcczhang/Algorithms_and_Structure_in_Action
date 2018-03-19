package cn.bput.zcc.depthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class SolveNQueens33 {
    public List<List<String>> solveNQueens(int n){
        List<List<String>> result = new ArrayList<List<String>>();
        if(n<0) return result;
        int[] col = new int[n];
        dfs(n,result,0,col);
        return result;

    }
    public void dfs(int nQueens, List<List<String>> result, int row, int[] col){
        if(row==nQueens){
                List<String> path = new ArrayList<String>();
                for(int i=0;i<row;i++){
                    StringBuilder s= new StringBuilder();
                    for(int j=0;j<row;j++){
                        if(col[i]==j) s.append("Q");
                        else {
                            s.append(".");
                        }
                    }
                    path.add(s.toString());
                }
                result.add(path);
        }else {
                for (int i=0;i<nQueens;i++){
                    col[row]=i;
                    if(isValid(row,col)){
                        dfs(nQueens,result,row+1,col);
                    }
                }
        }
    }
    public boolean isValid(int row, int[] cols){
        for(int i=0;i<row;i++){
            if(cols[row]==cols[i] || Math.abs(cols[row]-cols[i])==row-i){
                return false;
            }
        }
        return true;
    }
}
