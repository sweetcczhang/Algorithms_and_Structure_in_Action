package cn.bput.zcc.leetcode;

/**
 * Created by zcc
 * Date on 2018/8/4
 */
public class KMP {

    public void getNext(String p, int[] next){
        next[0]=-1;
        int i = 0;
        int j = -1;
        while(i<p.length()){
            if (j==-1 || p.charAt(i)==p.charAt(j)){
                next[++i]=(++j);
            }else {
                j = next[j];
            }
        }
    }

    public void kmp(String s, String p){
        int[] next = new int[p.length()];
        getNext(p, next);
        int i =0;
        int j =0;
        while (i<s.length()){
            if(j==-1 || s.charAt(i)==p.charAt(j)){
                i++;
                j++;
            }else {
                j = next[j];
            }
        }
    }

    public void get_set(int[]b, int[] next, int n){
        for (int i=2, j=0;i<n; i++){


            if(j==0 || b[i]==b[j+1]){
                j++;
            }
            next[i]= j;


            while (j!=0 && b[i]!=b[j+1]) j = next[j];
            if(b[i] == b[j+1]) j++;
            next[i] = j;
        }
    }
}
