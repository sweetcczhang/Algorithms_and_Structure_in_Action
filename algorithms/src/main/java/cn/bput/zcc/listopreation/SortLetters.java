package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/12/2.
 */
public class SortLetters {
    /**
     * 题目：
     * 给定一个只包含字母的字符串，按照先小写字母后大写字母的顺序进行排序。
     * @param chars
     */
    public void sortLetters(char[] chars) {
        // write your code here
        int right = chars.length-1;
        int left = 0;
        int target = 91;
        while (left<right){
            while (left<right&&chars[left]>target){
                left++;
            }
            while (left<right&&chars[right]<target){
                right--;
            }
            if(left<right){
                char a = chars[left];
                chars[left] = chars[right];
                chars[right] = a;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args){
        int a='a';
        int A='A';
        int z='z';
        int Z='Z';
        System.out.println("a:"+a);
        System.out.println("A:"+A);
        System.out.println("z:"+z);
        System.out.println("Z:"+Z);
    }

}
