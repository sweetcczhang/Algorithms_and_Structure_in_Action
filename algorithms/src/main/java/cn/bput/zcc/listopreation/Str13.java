package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2018/3/28.
 */
public class Str13 {
    public int strStr(String source, String target) {
        // write your code here
        if(source.length()==0) return -1;
        if(target.length()==0) return 0;
        int[] next = new int[target.length()+1];
        int j=-1;
        int i=0;
        next[0]=-1;
        while(i<target.length()){
            if(j==-1 || target.charAt(i)==target.charAt(j)){
                j++;
                i++;
                next[i]=j;
            }else{
                j=next[j];
            }
        }
        i=0;
        j=0;
        while(i<source.length()){
            if(j==-1 || source.charAt(i)==target.charAt(j)){
                i++;
                j++;
            }else{
                j=next[j];
            }
            if(j==target.length()){
                return i-j;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Str13 str13=new Str13();
        str13.strStr("source","target");
    }
}
