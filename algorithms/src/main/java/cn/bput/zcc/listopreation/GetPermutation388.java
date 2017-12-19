package cn.bput.zcc.listopreation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张城城 on 2017/12/19.
 */
public class GetPermutation388 {
    /**
     * 题目：第k个排列
     * 描述：给定 n 和 k，求123..n组成的排列中的第 k 个排列。
     * @param n
     * @param k
     * @return
     */
    public static String getPermutation(int n, int k) {
        // write your code here
        String result="";
        List<Integer> list = new ArrayList<Integer>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        for(int i=1;i<=n;i++){
            int temp = (k-1)/jiecheng(n-i);
            int a = list.get(temp);
            list.remove(temp);
            result = result+a;
            k = k-(temp)*jiecheng(n-i);
        }
        return result;
    }
    public static int jiecheng(int n){
        int result = 1;
        for(int i =n; i>=2;i--){
            result *=i;
        }
        return result;
    }
    public static void main(String[] args){
        getPermutation(4,7);
    }
}
