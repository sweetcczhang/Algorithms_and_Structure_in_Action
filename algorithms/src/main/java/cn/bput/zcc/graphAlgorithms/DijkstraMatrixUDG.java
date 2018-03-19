package cn.bput.zcc.graphAlgorithms;

import java.io.IOException;
import java.util.Scanner;

public class DijkstraMatrixUDG {
    private int mEdgNum; //边的数量
    private char[] mVexs; //顶点集合
    private int[][] mMtrix; //邻接矩阵
    private static final int INF = Integer.MAX_VALUE;  //最大值

    public DijkstraMatrixUDG(){
        //输入顶点数和边数
        System.out.println("input vertex number:");
        int vlen=readInt();
        System.out.println("input edge number");
        int elen = readInt();
        if(vlen<1 || elen<1 ||(elen>(vlen*(vlen-1)))){
            System.out.println("input error: invalid parameters!");
            return;
        }
        //初始化顶点
        mVexs = new char[vlen];
        for (int i=0;i<vlen;i++){
            System.out.printf("vertex(%d): ", i);
            mVexs[i] = readChar();
        }
        //1.初始化边
        mEdgNum = elen;
        mMtrix = new int[vlen][vlen];
        for (int i=0;i<vlen;i++){
            for (int j=0;j<vlen;j++){
                if(i==j) mMtrix[i][j]=0;
                else mMtrix[i][j]=INF;
            }
        }
        // 2.初始化“边”的权值，根据用户的输入进行初始化
        for (int i=0;i<elen;i++){
            System.out.printf("edge(%d):",i);
            char c1 = readChar();
            char c2 = readChar();
            int weight = readInt();
            int p1 = getPosition(c1);
            int p2 = getPosition(c2);
            if(p1==-1 || p2==-1){
                System.out.printf("input error: invalid edge!\n");
                return ;
            }
            mMtrix[p1][p2] = weight;
            mMtrix[p2][p1] = weight;
        }

    }
    public DijkstraMatrixUDG(char[] vexs, int[][] matrix){
        int vlen = vexs.length;
        mVexs = new char[vlen];
        for (int i=0;i<vlen;i++){
            mVexs[i]=vexs[i];
        }
        mMtrix = new int[vlen][vlen];
        for(int i=0;i<vlen;i++){
            for (int j=0;j<vlen;j++){
                mMtrix[i][j]= matrix[i][j];
            }
        }
        mEdgNum = 0;
        for(int i=0;i<vlen;i++){
            for (int j=i+1;j<vlen;j++){
                if (mMtrix[i][j]!=INF){
                    mEdgNum++;
                }
            }
        }
    }
    public int getPosition(char ch){
        for(int i=0;i<mVexs.length;i++){
            if(mVexs[i]==ch) return i;
        }
        return -1;
    }

    /**
     * 读取一个字符
     * @return
     */
    private char readChar(){
        Scanner scanner= new Scanner(System.in);
        char ch ='0';
        do{
            try {
                ch = (char) System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }while (!((ch>='a' && ch<='z') || (ch>='A' && ch<= 'Z')));
        return ch;
    }
    /**
     * 读取一个整数
     * @return
     */
    private int readInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /**
     * 返回顶点v的第一个邻接顶点的索引，失败则返回-1
     * @param v
     * @return
     */
    private int firstVertex(int v){
        if(v<0 || v>(mVexs.length-1)){
            return -1;
        }
        for (int i=0;i<mVexs.length;i++){
            if(mMtrix[v][i]!=0 && mMtrix[v][i]!=INF){
                return i;
            }
        }
        return -1;
    }

    /**
     *  返回顶点v相对于w的下一个邻接顶点的索引，失败则返回-1
     * @param v
     * @param w
     * @return
     */
    private int nextVertex(int v, int w){
        if (v<0 || v>(mVexs.length-1) || w<0 || w>(mVexs.length-1))
            return -1;
        for(int i=w+1;i<mVexs.length;i++){
            if(mMtrix[v][i]!=0 && mMtrix[v][i]!=INF){
                return i;
            }
        }
        return -1;
    }
    public void DFS(int i, boolean[] visited){
        visited[i]=true;
        System.out.printf("%c",mVexs[i]);
        for (int w= firstVertex(i);w>=0; w=nextVertex(i,w)){
            if(!visited[w]){
                DFS(w,visited);
            }
        }
    }
    public void DFS(){
        boolean[] visited = new boolean[mVexs.length];
        System.out.print("DFS:");
        for(int i=0;i<mVexs.length;i++){
            if(!visited[i]){
                DFS(i,visited);
            }
        }
    }
    public void BFS(){
        int head =0;
        int rear=0;
        int [] queue= new int[mVexs.length];
        boolean[] visited = new boolean[mVexs.length];
        System.out.printf("DFS:");
        for(int i=0;i<mVexs.length;i++){
            if(!visited[i]){
                visited[i]=true;
                System.out.printf("%c",mVexs[i]);
                queue[rear++]=i;
            }
            while (head!=rear){
                int j = queue[head++];
                for (int k= firstVertex(j);k>=0; k=nextVertex(j,k)){
                    if(!visited[k]){
                        visited[k]=true;
                        System.out.printf("%c",mVexs[k]);
                        queue[rear++]=k;
                    }
                }
            }
        }
        System.out.println();
    }

    /**
     * Dijkstra最短路径。
     * 即，统计图中"顶点vs"到其它各个顶点的最短路径。
     *
     * 参数说明：
     *       vs -- 起始顶点(start vertex)。即计算"顶点vs"到其它顶点的最短路径。
     *     prev -- 前驱顶点数组。即，prev[i]的值是"顶点vs"到"顶点i"的最短路径所经历的全部顶点中，位于"顶点i"之前的那个顶点。
     *     dist -- 长度数组。即，dist[i]是"顶点vs"到"顶点i"的最短路径的长度。
     */
    public void dijkstra(int vs, int[] prev, int[] dist){
        // flag[i]=true表示"顶点vs"到"顶点i"的最短路径已成功获取
        boolean[] flag = new boolean[mVexs.length];
        for (int i=0;i<mVexs.length;i++){
            flag[i]=false;      // 顶点i的最短路径还没获取到。
            prev[i]=0;          // 顶点i的前驱顶点为0
            dist[i] = mMtrix[vs][i]; // 顶点i的最短路径为"顶点vs"到"顶点i"的权。
        }
        flag[vs]=true;
        dist[vs] = 0;

        // 遍历mVexs.length-1次；每次找出一个顶点的最短路径。
        int k=0;
        for (int i=0;i<mVexs.length;i++){
            // 寻找当前最小的路径；
            // 即，在未获取最短路径的顶点中，找到离vs最近的顶点(k)。
            int min = INF;
            for (int j=0; j<mVexs.length;j++){
                if(flag[j]==false && dist[j]<min){
                    min=dist[j];
                    k=j;
                }
            }
            // 标记"顶点k"为已经获取到最短路径
            flag[k]=true;
            // 修正当前最短路径和前驱顶点
            // 即，当已经"顶点k的最短路径"之后，更新"未获取最短路径的顶点的最短路径和前驱顶点"。
            for (int j=0;j<mVexs.length;j++){
                int tmp = (mMtrix[k][j]==INF? INF : (min+ mMtrix[k][j]));
                if(flag[j]==false && (tmp<dist[j])){
                    dist[j]=tmp;
                    prev[j]=k;
                }
            }
        }
        System.out.printf("dijkstra(%c): \n", mVexs[vs]);
        for (int i=0; i < mVexs.length; i++)
            System.out.printf("  shortest(%c, %c)=%d\n", mVexs[vs], mVexs[i], dist[i]);
    }
}
