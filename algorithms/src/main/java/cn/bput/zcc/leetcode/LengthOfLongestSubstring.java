package cn.bput.zcc.leetcode;

import java.util.Arrays;

/**
 * Created by zcc
 * Date on 2018/8/3
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s){
        int max =0;
        if (s==null || s.length()==0){
            return max;
        }
        if (s.length()==1){
            return 1;
        }
        int start =0;
        int end = 1;
        int[] table = new int[256];
        Arrays.fill(table,-1);
        table[s.charAt(0)] = 0;
        int length = s.length();
        while (end<length){
            if (table[s.charAt(end)]>=start){
                start = table[s.charAt(end)]+1;
            }
            table[s.charAt(end)] =end;
            max = Math.max(max,end-start+1);
            end++;
        }

        return max;
    }
}
