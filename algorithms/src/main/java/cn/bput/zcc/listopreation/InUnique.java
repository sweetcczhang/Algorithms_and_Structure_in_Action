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

    /**
     * 给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。
     * 你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。
     * 注意这里下标的范围是 1 到 n，不是以 0 开头。
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[]numbers, int target){
        int len = numbers.length;
        int start=0,end=0;
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                if(numbers[i]+numbers[j]==target){
                    start = i+1;
                    end = j+1;
                }
            }
        }
        int [] ans ={start,end};
        return ans;
    }

}
