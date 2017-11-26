package cn.bput.zcc.listopreation;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 张城城 on 2017/11/26.
 */
public class InUnique {
    /**
     * 实现一个算法确定字符串中的字符是否均唯一出现
     * @param str
     * @return
     */
    public boolean isUnique(String str){
        int[] table = new int[256];
        for(int i=0;i<256;i++){
            table[i]=0;
        }
        for(int i=0;i<str.length();i++){
            table[str.charAt(i)]++;
            if (table[str.charAt(i)]>1){
                return false;
            }
        }
        return true;
    }
}
