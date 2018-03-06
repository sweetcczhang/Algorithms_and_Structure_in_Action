package cn.bput.zcc.DynamicProgramming;

import java.util.Set;

/**
 * Created by 张城城 on 2018/3/6.
 */
public class WordBreak107 {
    /**
     * 使用动态规划来解题
     * 思路：如果字符串的长度为n，字典的大小为k，设dp[i]表示前i个字符是否可以切分。
     * 如果按照字符串来循环比较的话，则是n*n如果每次从字典中取出比较的话是n*k
     * @param s
     * @param dict
     * @return
     */
    public boolean wordBreak(String s, Set<String> dict){
        if(s==null && dict==null) return true;
        if(s==null || dict ==null) return false;
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for (int i=0;i<s.length();i++){
            for (String str: dict){
                if(dp[i]&&i+str.length()<=s.length()&&s.substring(i,i+str.length()).equals(str)) dp[i+str.length()]=true;
            }
        }
        return dp[s.length()];
    }
}
