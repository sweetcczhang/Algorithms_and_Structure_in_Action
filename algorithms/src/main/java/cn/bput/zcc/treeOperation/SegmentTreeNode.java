package cn.bput.zcc.treeOperation;

/**
 * Created by 张城城 on 2018/3/1.
 */
public class SegmentTreeNode {
    public int start, end, max;
    public SegmentTreeNode left, right;
    public SegmentTreeNode(int start,int end){
        this.start =start;
        this.end = end;
        this.left=this.right = null;
    }
    public SegmentTreeNode(int start, int end, int max){
        this.start = start;
        this.end = end;
        this.max = max;
        this.left = null;
        this.right = null;
    }
}
