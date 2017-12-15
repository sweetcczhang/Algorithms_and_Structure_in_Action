package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/12/14.
 */
public class TrapRainWater363 {
    /**
     * 题目：接雨水
     * 描述：
     * Given n non-negative integers representing an elevation map where the width of each bar is 1,
     * compute how much water it is able to trap after raining.
     * 解题思路：
     *  先遍历一遍找到最高点，然后分别从两边开始，往最高点所在位置遍历，水位只会增高不会减小，
     *且一直和最近遇到的最大高度持平，这样知道了实时水位，就可以边遍历边计算面积。
     *  左到最高点，海拔高度下降的时候计算水位，左边最近比他高的海拔 减去 自己的海拔 ，这是该海拔的水位量。
     *当遇到更高的海拔的时候更新海拔高度。
     *  右到最高点，海拔高度下降的时候计算水位, 右边最近比他高的海拔 减去 自己的海拔 ，这是该海拔的水位量。
     *当遇到更高的海拔的时候更新海拔高度。
     * @param heights
     * @return
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        if(heights==null || heights.length<3) return 0;
        int maxId=0;
        int max = heights[0];
        for(int i=1;i<heights.length;i++){
            if(heights[i]>max){
                max=heights[i];
                maxId=i;
            }
        }
        int area = 0;
        int root = heights[0];
        for(int i=1;i<maxId;i++){
            if(root<heights[i]){
                root = heights[i];
            }else {
                area += (root-heights[i]);
            }
        }
        root = heights[heights.length-1];
        for(int i= heights.length-2;i>maxId;i--){
            if(heights[i]>root){
                root = heights[i];
            }else {
                area += (root-heights[i]);
            }
        }
        return area;
    }
}
