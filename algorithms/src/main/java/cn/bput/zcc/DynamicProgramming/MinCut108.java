package cn.bput.zcc.DynamicProgramming;

public class MinCut108 {
    /**
     * 使用动态规划来解题
     * 使用一个布尔类型的二维矩阵dp[i][j]判断字符串从i到j是否可以构成一个回文串。
     * 使用一个数值型的一维数组val[i]表示从i到字符串结尾需要切割的最小次数。
     * @param s
     * @return
     */
    public int minCut(String s){
        if(s==null || s.length()==1) return 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int [] val = new int[s.length()+1];
        for(int i=0;i<s.length();i++){
            val[i] = s.length()-i;
        }
        for (int i=s.length()-1;i>=0;i--){
            for (int j=i;j<s.length();j++){
                if((s.charAt(i)==s.charAt(j) && j-i<2) ||(s.charAt(i)==s.charAt(j) && dp[i+1][j-1])){
                    dp[i][j] = true;
                    val[i]=Math.min(val[i],val[j+1]+1);
                }
            }
        }
        return val[0]-1;
    }
    public boolean reverse(String s){
        StringBuffer  r = new StringBuffer(s);
        return r.reverse().toString().equals(s);
    }
}
