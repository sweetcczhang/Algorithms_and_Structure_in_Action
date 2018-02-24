package cn.bput.zcc.matrixOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SetZeroes {
    public void setZeroes(int[][] matrix){
        if(matrix==null || matrix.length==0) return;
        List<Point> list = new ArrayList<Point>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i =0; i< m; i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    Point point = new Point(i,j);
                    list.add(point);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            Point point = list.get(i);
            for(int j=0;j<m;j++){
                matrix[j][point.j]=0;
            }
            for (int j=0;j<n;j++){
                matrix[point.i][j]=0;
            }
        }
    }
    class Point{
        public int i;
        public int j;
        public Point(int i,int j){
        this.i=i;
        this.j = j;
        }
        public  Point(){

        }
    }
}
