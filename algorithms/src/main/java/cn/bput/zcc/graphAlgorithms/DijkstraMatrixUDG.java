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

    /**
     * floyd最短路径。
     * 即，统计图中各个顶点间的最短路径。
     *
     * 参数说明：
     *     path -- 路径。path[i][j]=k表示，"顶点i"到"顶点j"的最短路径会经过顶点k。
     *     dist -- 长度数组。即，dist[i][j]=sum表示，"顶点i"到"顶点j"的最短路径的长度是sum。
     */
    public void floyd(int[][] path, int[][] dist){
        // 初始化
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = 0; j < mVexs.length; j++) {
                dist[i][j] = mMtrix[i][j];    // "顶点i"到"顶点j"的路径长度为"i到j的权值"。
                path[i][j] = j;                // "顶点i"到"顶点j"的最短路径是经过顶点j。
            }
        }
        //计算最短路径
        for (int k=0; k<mVexs.length;k++){
            for (int i=0;i<mVexs.length;i++){
                for (int j=0;j<mVexs.length;j++){
                    // 如果经过下标为k顶点路径比原两点间路径更短，则更新dist[i][j]和path[i][j]
                    int tmp = (dist[i][k]==INF || dist[k][j]==INF)? INF :(dist[i][k]+dist[k][j]);
                    if(dist[i][j]>tmp){
                        // "i到j最短路径"对应的值设，为更小的一个(即经过k)
                        dist[i][j]=tmp;
                        // "i到j最短路径"对应的路径，经过k
                        path[i][j]=k;
                    }
                }
            }
        }
        // 打印floyd最短路径的结果
        System.out.printf("floyd: \n");
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = 0; j < mVexs.length; j++)
                System.out.printf("%2d  ", dist[i][j]);
            System.out.printf("\n");
        }
    }
    public void prim(int start){
        int num = mVexs.length;         // 顶点个数
        int index=0;                    // prim最小树的索引，即prims数组的索引
        char[] prims  = new char[num];  // prim最小树的结果数组
        int[] weights = new int[num];   // 顶点间边的权值

        // prim最小生成树中第一个数是"图中第start个顶点"，因为是从start开始的。
        prims[index++] = mVexs[start];

        // 初始化"顶点的权值数组"，
        // 将每个顶点的权值初始化为"第start个顶点"到"该顶点"的权值。
        for (int i = 0; i < num; i++ )
            weights[i] = mMtrix[start][i];
        // 将第start个顶点的权值初始化为0。
        // 可以理解为"第start个顶点到它自身的距离为0"。
        weights[start] = 0;
        for (int i=0;i<num;i++){
            // 由于从start开始的，因此不需要再对第start个顶点进行处理。
            if(start==i) continue;
            int j=0;
            int k=0;
            int min = INF;
            //在未被加入到最小生成树的顶点中，找出权值最小的顶点
            while(j<num){
                // 若weights[j]=0，意味着"第j个节点已经被排序过"(或者说已经加入了最小生成树中)。
                if(weights[j]!=0 && weights[j]<min){
                    min = weights[j];
                    k=j;
                }
                j++;
            }
            // 经过上面的处理后，在未被加入到最小生成树的顶点中，权值最小的顶点是第k个顶点。
            // 将第k个顶点加入到最小生成树的结果数组中
            prims[index++] = mVexs[k];
            // 将"第k个顶点的权值"标记为0，意味着第k个顶点已经排序过了(或者说已经加入了最小树结果中)。
            weights[k] = 0;
            // 当第k个顶点被加入到最小生成树的结果数组中之后，更新其它顶点的权值。
            for (j=0;j<num;j++){
                if(weights[j]!=0 && weights[j]>mMtrix[k][j]){
                    weights[j]=mMtrix[k][j];
                }
            }
        }
        //计算最小生成树的权值
        int sum=0;
        for (int i=1;i<index;i++){
            int min = INF;
            int n = getPosition(prims[i]);
            for (int j=0; j<i;j++){
                int m = getPosition(prims[j]);
                if(mMtrix[m][n]<min){
                    min = mMtrix[m][n];
                }
            }
            sum+=min;
        }
        // 打印最小生成树
        System.out.printf("PRIM(%c)=%d: ", mVexs[start], sum);
        for (int i = 0; i < index; i++)
            System.out.printf("%c ", prims[i]);
        System.out.printf("\n");
    }

    public void kruskal(){
        int index = 0;                      // rets数组的索引
        int[] vends = new int[mEdgNum];     // 用于保存"已有最小生成树"中每个顶点在该最小树中的终点。
        EData[] rets = new EData[mEdgNum];  // 结果数组，保存kruskal最小生成树的边
        EData[] edges;                      // 图对应的所有边

        //获取“图中所有的边”
        edges = getEdges();
        //将边按照全的大小进行排序（从小到大）
        sortEdges(edges,mEdgNum);
        for (int i=0;i<mEdgNum;i++){
            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);
            int m = getEnd(vends,p1);
            int n = getEnd(vends,p2);
            if(m!=n){
                vends[m]=n;
                rets[index++] = edges[i];
            }
        }
        // 统计并打印"kruskal最小生成树"的信息
        int length = 0;
        for (int i = 0; i < index; i++)
            length += rets[i].weight;
        System.out.printf("Kruskal=%d: ", length);
        for (int i = 0; i < index; i++)
            System.out.printf("(%c,%c) ", rets[i].start, rets[i].end);
        System.out.printf("\n");
    }

    // 边的结构体
    private static class EData {
        char start; // 边的起点
        char end;   // 边的终点
        int weight; // 边的权重

        public EData(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    /*
    * 获取图中的边
    */
    private EData[] getEdges() {
        int index=0;
        EData[] edges;

        edges = new EData[mEdgNum];
        for (int i=0; i < mVexs.length; i++) {
            for (int j=i+1; j < mVexs.length; j++) {
                if (mMtrix[i][j]!=INF) {
                    edges[index++] = new EData(mVexs[i], mVexs[j], mMtrix[i][j]);
                }
            }
        }

        return edges;
    }

    /*
    * 对边按照权值大小进行排序(由小到大)
    */
    private void sortEdges(EData[] edges, int elen) {

        for (int i=0; i<elen; i++) {
            for (int j=i+1; j<elen; j++) {

                if (edges[i].weight > edges[j].weight) {
                    // 交换"边i"和"边j"
                    EData tmp = edges[i];
                    edges[i] = edges[j];
                    edges[j] = tmp;
                }
            }
        }
    }

    /*
     * 获取i的终点
     */
    private int getEnd(int[] vends, int i) {
        while (vends[i] != 0)
            i = vends[i];
        return i;
    }
}
