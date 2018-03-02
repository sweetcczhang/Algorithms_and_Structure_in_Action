package cn.bput.zcc.treeOperation;

/**
 * Created by 张城城 on 2018/3/1.
 */
public class Build201 {
    public SegmentTreeNode build(int start, int end){
        if(start>end){
            return null;
        }
        if(start==end)
            return new SegmentTreeNode(start,end) ;
        SegmentTreeNode root = new SegmentTreeNode(start,end);
        root.left= build(start, (start+end)/2);
        root.right = build((start+end)/2+1,end);
        return root;
    }
}
