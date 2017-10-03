package cn.bput.zcc.bitoperation;

import java.util.Scanner;

/**
 * Created by 张城城 on 2017/10/3.
 */
public class CountOnes {

    /**
     * 统计一个int类型数据中1的个数
     * @param nums
     * @return
     */
    public int countOnes(int nums){
        String result = Integer.toBinaryString(nums);
        int count=0;
        int count1=0;
        int num=nums;
        while(num!=0){
            count1++;
            num = num&(num-1);
        }
        System.out.println("count1==================>"+count1);
        for(int i =0; i<result.length();i++){
            if (result.charAt(i)=='1')
                count++;
            System.out.println(result.charAt(i));
        }
        System.out.println("count==================>"+count);
        return count;
    }

    /**
     * 给出两个32位的整数N和M，以及两个二进制位的位置i和j。
     * 写一个方法来使得N中的第i到j位等于M（M会是N中从第i为开始到第j位的子串）
     * @param n
     * @param m
     * @param i
     * @param j
     * @return
     */
    public int updateBits(int n, int m, int i, int j){
        int result = 0;
        int left = 0;
        // 如果 j=31，j+1则是向前移动32位，按照我的计算是应该等于0，但是打印出来的结果却是-1
        // 所以此处应该判断j是否小于31.
        if(j<31) {
            left = -1 << j + 1;
       }
        int right = (1<<i) -1;
        int well = left | right;
        n = well & n;
        m = m <<i;
        result = n | m;
        return result;
    }

    /**
     * 统计一个int类型数据转化为二进制后其中1的个数
     * @param a
     * @return
     */
    public int getBitCount(int a){
        int count =0;
        while(a!=0){
            count++;
            a = a&(a-1);
        }
        return count;
    }



    public static void main(String[] args){
        int a = 35;
        String result = Integer.toBinaryString(a);
        System.out.println(a);
        System.out.println(result);
//        int one =(0<<1)+1;
//        String result = Integer.toBinaryString(-521);
//        System.out.println(result);
        CountOnes ones=new CountOnes();
        int s=ones.updateBits(35,41,3,9);
        System.out.println(s);
//        Scanner in = new Scanner(System.in);
//        while(true) {
//            int a = in.nextInt();
//            ones.countOnes(a);
//        }
    }
}
