package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/12/9.
 */
public class LongestCommonPrefix78 {
    public String longestCommonPrefix(String[] strs) {
        // write your code here
        if(strs ==null || strs.length==0) return "";
        if(strs.length==1) return strs[0];
        int size = strs.length;
        int min =Integer.MAX_VALUE;
        for(int i = 0;i<strs.length;i++){
            if(strs[i].length()<min){
                min = strs[i].length();
            }
        }
        String result = "";
        String first = strs[0];
        for(int i=0;i<min;i++){
            char a = first.charAt(i);
            int  sum = 1;
            for(int j=1;j<strs.length;j++){
                if(strs[j].charAt(i)==a){
                    sum++;
                }
            }
            if(sum==size){
                result = result+a;
            }else {
                break;
            }
        }
        return result;
    }
}
