package cn.bput.zcc.heapOperation;

import cn.bput.zcc.hashtableOperation.Point;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by 张城城 on 2018/2/27.
 */
public class KCloseset612 {
    public Point[] kClosest(Point[] points,Point origin, int k){
        Point[] result = new Point[k];
        PriorityQueue<Node> pd = new PriorityQueue<Node>(points.length, new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                if(o1.len!=o2.len){
                    return o1.len-o2.len;
                }else if (o1.point.x!=o2.point.x){
                     return o1.point.x-o2.point.x;
                }else {
                    return o1.point.y-o2.point.y;
                }
            }
        });
        for(int i=0;i<points.length;i++){
            int len = (points[i].x-origin.x)*(points[i].x-origin.x)+(points[i].y-origin.y)*(points[i].y-origin.y);
            pd.offer(new Node(points[i], len));
        }
        for(int i=0;i<k;i++){
            result[i]=pd.poll().point;
        }

        return result;

    }
    class  Node{
        Point point;
        int len;
        public  Node(Point point, int len){
            this.point = point;
            this.len = len;
        }
    }
}
