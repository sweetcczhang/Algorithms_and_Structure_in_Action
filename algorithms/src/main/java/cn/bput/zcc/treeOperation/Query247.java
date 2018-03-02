package cn.bput.zcc.treeOperation;

/**
 * Created by 张城城 on 2018/3/2.
 */
public class Query247 {
    public int query(SegmentTreeNode root, int start, int end){
        if (root==null || root.end<start || root.start>end) return 0;
        if(root.start>=start && root.end<=end) return root.count;
        int res1 = query(root.left, start,end);
        int res2 = query(root.right, start,end);
        return res1+res2;
    }
}
