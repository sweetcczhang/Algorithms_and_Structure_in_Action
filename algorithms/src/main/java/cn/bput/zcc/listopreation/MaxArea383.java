package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/12/18.
 */
public class MaxArea383 {
    /**
     * 题目： 装最多水的容器
     * 描述：
     * 给定 n 个非负整数 a1, a2, ..., an, 每个数代表了坐标中的一个点 (i, ai)。画 n 条垂直线，
     * 使得 i 垂直线的两个端点分别为(i, ai)和(i, 0)。找到两条线，使得其与 x 轴共同构成一个容
     * 器，以容纳最多水。
     * @param heights
     * @return
     */
    public int maxArea(int[] heights){
        if(heights==null|| heights.length<2) return 0;
        int left =0;
        int right = heights.length-1;
        int max = 0;
        int subMax = 0;
        while (left<right){
            if(heights[left]<heights[right]){
                subMax = (right-left)*heights[left];
                left++;
            }else {
                subMax = (right-left)*heights[right];
                right--;

            }
            max = Math.max(subMax, max);
        }
        return max;
    }
}
