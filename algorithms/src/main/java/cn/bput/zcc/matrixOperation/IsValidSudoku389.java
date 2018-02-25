package cn.bput.zcc.matrixOperation;

import java.util.Arrays;

/**
 * Created by 张城城 on 2018/2/25.
 */
public class IsValidSudoku389 {
    public boolean isValidSudoku(char[][] board){
        if(board==null || board.length==0 || board[0].length==0 || board.length%3!=0 || board[0].length%3!=0) return false;
        boolean[] flag = new boolean[9];
        boolean[] flag1 = new boolean[9];
        for(int i=0;i<9;i++){
            Arrays.fill(flag,false);
            Arrays.fill(flag1,false);
            for(int j=0;j<9;j++){
                char c = board[i][j];
                if(c!='.'){
                    if(flag[c-'0'-1]) return false;
                    else {
                        flag[c-'0'-1]=true;
                    }
                }
                char c1 = board[j][i];
                if(c1!='.'){
                    if(flag[c1-'0'-1]) return false;
                    else {
                        flag[c1-'0'-1]=true;
                    }
                }

            }
        }
        for(int i=0;i<9;i=i+3){
            for(int j=0;j<9;j=j+3){
                Arrays.fill(flag,false);
                for(int k=0;k<9;k++){
                    char c=board[k/3+i][k%3+j];
                    if(c!='.') {
                        if(flag[c-'0'-1]) return false;
                        else {
                            flag[c-'0'-1]=true;
                        }
                    }
                }
            }
        }
        return true;
    }
}
