package cn.bput.zcc.sortAlgorithms;

public class SortColors143 {
    /**
     * 算法思想：每次先把未排序的数组的最大值和最小值进行确定。然后缩小数组的范围重复此操作。
     * 数组中总共有k种数，每次确定两个数的排序。
     * @param colors
     * @param k
     */
    public void sortColors(int[] colors, int k){
        int count=0;
        int start=0;
        int end=colors.length-1;
        while (count<k){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i=start;i<=end;i++){
                min = Math.min(min,colors[i]);
                max = Math.max(max,colors[i]);
            }
            int left=start;
            int right=end;
            int cur = left;
            while (cur<=right){
                if(colors[cur]==min){
                    swap(colors,cur,left);
                    left++;
                    cur++;
                }else if(colors[cur]>min && colors[cur]<max){
                    cur++;
                }else {
                    swap(colors,cur,right);
                    right--;
                }
            }
            count +=2;
            start = left;
            end = right;
        }
    }
    public void swap(int[] colors, int i,int j){
        int temp = colors[i];
        colors[i]=colors[j];
        colors[j] = temp;
    }
}
