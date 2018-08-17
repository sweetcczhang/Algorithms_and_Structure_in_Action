package cn.bput.zcc;

import sun.jvm.hotspot.jdi.IntegerValueImpl;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by zcc
 * Date on 2018/8/11
 */
public class Ab {

    public static int test(int n,int m){
        if (n==0 || m==0) return 1;
        return test(n-1, m) + test(n, m-1);
    }
    public PriorityQueue<String> priorityQueue = new PriorityQueue<String>();
    public void dfs(String str, PriorityQueue<String> result, List<Integer> path){
        HashMap<String,String> hashMap = new HashMap<String, String>();
    }
    public void getScore(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] score = new int[n];
        int[] wakeup = new int[n];
        int sum =0;
        for (int i=0;i<n;i++){
            score[i] = in.nextInt();
            sum +=score[i];
        }
        for (int i=0;i<n;i++){
            wakeup[i] = in.nextInt();
        }
        if (k>=n) {
            System.out.println(sum);
            return;
        }
        sum = 0;
        int max =0;
        for (int i=0;i<n;i++){
            if (wakeup[i]==1){
                sum +=score[i];
            }else {
                int bound = (i+k-1)<n? i+k-1:n-1;
                int value=0;
                for (int j=i;i<=bound;j++){
                    if (wakeup[i]==0){
                        value += score[i];
                    }
                }
                if (value>max){
                    max = value;
                }
            }
        }
        System.out.println(sum+max);
    }

    public static void main(String[] args){
        num();
    }

    public static void num(){
        Scanner scanner = new Scanner(System.in);

        int n = Integer.valueOf(scanner.nextLine());
        System.out.println(n);
        String l = scanner.nextLine();
        String[] s= l.split(" ");

        System.out.println(l+":"+s.length);
        int [] b = new int[n];
        for (int i=0; i<n; i++){
            if (i==0){
                b[i] =Integer.valueOf(s[i]);
            }else {
                b[i] = b[i-1] + Integer.valueOf(s[i]);
            }
            System.out.println(b[i]);
        }
        int m = Integer.valueOf(scanner.nextLine());
        System.out.println(m);
        int[] a = new int[m];


        for (int i=0; i<m;i++){
            a[i] = scanner.nextInt();
        }
        for (int i=0;i<m;i++){
            System.out.println(find(b,a[i]));
        }

    }
    public static int find(int[] b, int k){
        for (int i=0; i<b.length;i++){
            if (b[i]>=k){
                return i+1;
            }
        }
        return 0;
    }
}
