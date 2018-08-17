package cn.bput.zcc;

/**
 * Created by zcc
 * Date on 2018/8/16
 */
public class Hello {
    public static double myPow(double x, int n) {
        if(n<0) n=-n;
        double result = myPow1(x,n);
        if(n<0) return 1/result;
        return result;

    }
    public static double myPow1(double x, int n){
        if(n==0) return 1.0;
        double result = myPow1(x,n/2)*myPow1(x,n/2);
        if(n%2==1){
            result *=x;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(myPow(2.0000,-2));
    }
}
