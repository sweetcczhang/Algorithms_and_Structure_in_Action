package cn.bput.zcc.hashtableOperation;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by 张城城 on 2018/1/30.
 */
public class LengthOfLongestSubstring384 {

    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if(s==null ||s.length()==0) return 0;
        if(s.length()==1) return 1;
        int max =1;
        int index=0;
        for(int i=0;i<s.length();i++){
            for(int j =i-1;j>index;j--){
                if(s.charAt(i)==s.charAt(j)){
                    index=j+1;
                    break;
                }else {
                    max = Math.max(max,i-j+1);
                }
            }

        }
       return  max;
    }
    /**
     * 题目：最长无重复字符子串
     * 描述：给定一个字符串，请找出其中无重复字符的最长子字符串。
     * 解题思路：使用一个table维护每一个字符出现的位置当无重复字符串被破坏时，
     * 更新起始节点的位置。并且字符串每往前移动一次就保存当前最大的无重复子串。
     * @param s
     * @return
     */
    public int lengthOfLongest(String s){
        int length = s.length();
        if(length<=1) return length;
        int start=0;
        int end = 1;
        int max =1;
        int[] table = new int[256];
        Arrays.fill(table,-1);
        table[s.charAt(0)] =0;
        while (end<length){
            if(table[s.charAt(end)]>=start){
                start = table[s.charAt(end)]+1;
            }
            max = Math.max(max,end-start+1);
            table[s.charAt(end)] =end;
            end++;
        }
        return max;
    }
}
