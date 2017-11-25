package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/11/25.
 */
public class PlusOne {

    /**
     * 给定一个非负数，表示一个数字数组，在该数的基础上+1，返回一个新的数组。
     * 该数字按照大小进行排列，最大的数在列表的最前面。
     *
     * 解题思路把数组转换成一个字符串，然后加一。之后再转换成字符串，避免进位的麻烦。
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits){
        int len = digits.length;
        String result = "";
        for(int i=0; i<len; i++){
            result += digits[i];
        }
        Long flag = Long.valueOf(result)+1;
        result = String.valueOf(flag);
        int[] answer = new int[result.length()];
        for(int i=0; i<result.length();i++){
            answer[i] = Integer.valueOf(result.charAt(i)+"");

        }
        return answer;
    }
    public static void main(String[] args){
        int [] a={0};
        plusOne(a);
    }
}
