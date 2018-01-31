package cn.bput.zcc.hashtableOperation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 张城城 on 2018/1/31.
 */
public class IsHappy488 {
    public boolean isHappy(int n){
        Set<Integer> set = new HashSet<Integer>();
        set.add(n);
        while (true){
            String str = String.valueOf(n);
            int result = 0;
            for(int i=0;i<str.length();i++){
                int tmp=Integer.valueOf(str.charAt(i)+"");
                result+= tmp*tmp;
            }
            if (result==1) return true;
            if(set.contains(result)){
                return false;
            }else {
                set.add(result);
            }
            n=result;
        }
    }
}
