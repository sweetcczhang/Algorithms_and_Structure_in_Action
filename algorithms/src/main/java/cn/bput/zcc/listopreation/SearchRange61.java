package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/12/3.
 */
public class SearchRange61 {
    public static int[] searchRange(int[] A, int target) {
        // write your code here
        int left = 0;
        int right = A.length-1;
        int[] result = new int[2];
        int start,end;
        int flag=-1;
        while (left<=right){
            int mid = (left+right) / 2;
            if(A[mid]==target){
                flag=mid;
                break;
            }
            if(A[mid]<target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        if(flag==-1){
            result[0]=flag;
            result[1]=flag;
            return result ;
        }
        start=end=flag;
        while (start>0&&A[start-1]==target) start--;
        while (end<A.length-1&&A[end+1]==target) end++;
        result[0]=start;
        result[1] = end;
        return result;
    }
    public static void main(String [] args){
        int[] a ={1,3,5,6,8,9};
        searchRange(a,7);
    }

}
