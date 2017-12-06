package cn.bput.zcc.DynamicProgramming;

/**
 * Created by 张城城 on 2017/12/5.
 */
public class Jump117 {
    public int jump(int[] A){
        int[] min=new int[A.length];
        if(A.length==1) return 0;
        for(int i=0;i<A.length;i++){
            for(int j=i+1;j<=i+A[i]&&j<A.length;j++){
                if(min[j]==0){
                    min[j]=min[i]+1;
                }
            }
        }
        return min[A.length-1];
    }

    public static void main(String[] args){
        int[] a ={2,3,1,1,4};
        Jump117 jump117=new Jump117();
        jump117.jump(a);
    }
}
