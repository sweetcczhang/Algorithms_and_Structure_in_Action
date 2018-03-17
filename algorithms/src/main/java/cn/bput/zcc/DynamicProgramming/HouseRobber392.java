package cn.bput.zcc.DynamicProgramming;

public class HouseRobber392 {
    public  long houseRobber1(int[] A){
        if(A==null || A.length==0) return 0;
        if(A.length ==1) return A[0];
        if(A.length ==2 ) return Math.max(A[0],A[1]);
        long max0 = 0;
        long max1 = A[0];
        long max2 = A[1];
        for(int i=2;i<A.length;i++){
            long max3 = A[i] + Math.max(max0,max1);
            max0 =max1;
            max1 = max2;
            max2 = max3;
        }
        return Math.max(max1,max2);
    }
    public int houseRobber2(int[] nums){

        return 0;
    }
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if(A==null || B==null ||A.equals("") || B.equals("")) return 0;
        int[][]dp =new int[A.length()+1][B.length()+1];
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=A.length();i++){
            for(int j=1;j<B.length();j++){
                if(A.charAt(i-1)==B.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=0;
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return dp[A.length()-1][B.length()-1];
    }
}
