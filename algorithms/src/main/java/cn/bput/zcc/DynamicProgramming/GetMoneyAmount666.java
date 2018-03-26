package cn.bput.zcc.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class GetMoneyAmount666 {
    public int findSolution(int start,int end, int[][]dp){
        if(start>=end){
            return 0;
        }
        if(dp[start][end]!=0){
            return dp[start][end];
        }
        dp[start][end] = Integer.MAX_VALUE;
        for(int i=start;i<=end;i++){
            int left =findSolution(start,i-1,dp);
            int right =findSolution(i+1,end,dp);
            int temp = Math.max(left,right)+i;
            dp[start][end] = Math.min(temp,dp[start][end]);
            if(start==1 && end==10)
            System.out.println(i+":dp["+start+"]["+end+"]="+ temp);

        }

        return dp[start][end];
    }
    public int getMoneyAmount(int n){
        int[][] dp = new int[n+1][n+1];
        int result = findSolution(1,n,dp);
        return result;
    }

    public int binarySerach(int[] nums,int tartget){
        int start =0;
        int end = nums.length-1;
        int result =0;
        while(start<=end){
            int mid =(end-start)/2+start;
            if(nums[mid]==tartget){
                System.out.println(result);
                return mid;
            }else if(tartget<nums[mid]){
                end=mid-1;
            }else {
                start=mid+1;
            }
            result += nums[mid];
        }
        return -1;
    }

    public static void main(String[] args){
        GetMoneyAmount666 s = new GetMoneyAmount666();
        s.getMoneyAmount(10);
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        for(int i=1;i<=10;i++){
            s.binarySerach(nums,i);
        }
    }
}
