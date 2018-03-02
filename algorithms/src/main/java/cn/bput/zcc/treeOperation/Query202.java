package cn.bput.zcc.treeOperation;

/**
 * Created by 张城城 on 2018/3/2.
 */
public class Query202 {
    public int query(SegmentTreeNode root, int start, int end){
        if(root.start==start && root.end==end) return root.max;
        int mid = (root.end-root.start)/2+ root.start;
        if(end<=mid) {
            int result = query(root.left, start,end);
            return result;
        }
        if(start>=mid+1){
            int result = query(root.right,start,end);
            return result;
        }
        if(end>mid){
            int res1 = query(root.left,start,mid);
            int res2 = query(root.right,mid+1,end);
            return Math.max(res1,res2);
        }
        return 0;
    }
}
