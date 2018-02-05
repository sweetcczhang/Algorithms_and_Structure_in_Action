package cn.bput.zcc.hashtableOperation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by 张城城 on 2018/2/2.
 */
public class FindElements737 {
    public int findElements(int[][] Matrix){
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i<Matrix[0].length;i++){
            set.add(Matrix[0][i]);
        }
        for(int i=1;i<Matrix.length;i++){
            HashSet<Integer> set1 = new HashSet<Integer>();
            for(int j=0;j<Matrix[i].length;j++){
                    if(set.contains(Matrix[i][j])){
                        set1.add(Matrix[i][j]);
                    }
            }
            if(set1.size()==1){
                Iterator<Integer> it = set1.iterator();
                return it.next();
            }
            set = set1;
        }
        return 0;
    }
}
