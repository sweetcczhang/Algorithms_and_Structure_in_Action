package cn.bput.zcc.graphAlgorithms;

import java.io.IOException;
import java.util.Scanner;

public class DijkstraListUDG {
    private static int INF = Integer.MAX_VALUE;

    // 邻接表中表对应的链表的顶点
    private class  ENode{
        int ivex;   // 该边所指向的顶点的位置
        int weight;  // 该边的权
        ENode nextEdge; // 指向下一条弧的指针
    }
    // 邻接表中表的顶点
    private class VNode {
        char data;          // 顶点信息
        ENode firstEdge;    // 指向第一条依附该顶点的弧
    }
    private int mEdgNum;    // 边的数量
    private VNode[] mVexs;  // 顶点数组
    public DijkstraListUDG() {

        // 输入"顶点数"和"边数"
        System.out.printf("input vertex number: ");
        int vlen = readInt();
        System.out.printf("input edge number: ");
        int elen = readInt();
        if ( vlen < 1 || elen < 1 || (elen > (vlen*(vlen - 1)))) {
            System.out.printf("input error: invalid parameters!\n");
            return ;
        }

        // 初始化"顶点"
        mVexs = new VNode[vlen];
        for (int i = 0; i < mVexs.length; i++) {
            System.out.printf("vertex(%d): ", i);
            mVexs[i] = new VNode();
            mVexs[i].data = readChar();
            mVexs[i].firstEdge = null;
        }

        // 初始化"边"
        mEdgNum = elen;
        for (int i = 0; i < elen; i++) {
            // 读取边的起始顶点和结束顶点
            System.out.printf("edge(%d):", i);
            char c1 = readChar();
            char c2 = readChar();
            int weight = readInt();

            int p1 = getPosition(c1);
            int p2 = getPosition(c2);
            // 初始化node1
            ENode node1 = new ENode();
            node1.ivex = p2;
            node1.weight = weight;
            // 将node1链接到"p1所在链表的末尾"
            if(mVexs[p1].firstEdge == null)
                mVexs[p1].firstEdge = node1;
            else
                linkLast(mVexs[p1].firstEdge, node1);
            // 初始化node2
            ENode node2 = new ENode();
            node2.ivex = p1;
            node2.weight = weight;
            // 将node2链接到"p2所在链表的末尾"
            if(mVexs[p2].firstEdge == null)
                mVexs[p2].firstEdge = node2;
            else
                linkLast(mVexs[p2].firstEdge, node2);
        }
    }
    public DijkstraListUDG(char[] vexs, EData[] edges){
        // 初始化"顶点数"和"边数"
        int vlen = vexs.length;
        int elen = edges.length;

        // 初始化"顶点"
        mVexs = new VNode[vlen];
        for (int i = 0; i < mVexs.length; i++) {
            mVexs[i] = new VNode();
            mVexs[i].data = vexs[i];
            mVexs[i].firstEdge = null;
        }

        // 初始化"边"
        mEdgNum = elen;
        for (int i = 0; i < elen; i++) {
            // 读取边的起始顶点和结束顶点
            char c1 = edges[i].start;
            char c2 = edges[i].end;
            int weight = edges[i].weight;

            // 读取边的起始顶点和结束顶点
            int p1 = getPosition(c1);
            int p2 = getPosition(c2);
            // 初始化node1
            ENode node1 = new ENode();
            node1.ivex = p2;
            node1.weight = weight;
            // 将node1链接到"p1所在链表的末尾"
            if(mVexs[p1].firstEdge == null)
                mVexs[p1].firstEdge = node1;
            else
                linkLast(mVexs[p1].firstEdge, node1);
            // 初始化node2
            ENode node2 = new ENode();
            node2.ivex = p1;
            node2.weight = weight;
            // 将node2链接到"p2所在链表的末尾"
            if(mVexs[p2].firstEdge == null)
                mVexs[p2].firstEdge = node2;
            else
                linkLast(mVexs[p2].firstEdge, node2);
        }
    }
    /**
    * 将node节点链接到list的最后
    */
    private void linkLast(ENode list, ENode node) {
        ENode p = list;

        while(p.nextEdge!=null)
            p = p.nextEdge;
        p.nextEdge = node;
    }

    /**
     * 返回ch在数组中的位置
     * @param ch
     * @return
     */
    private int getPosition(char ch) {
        for(int i=0; i<mVexs.length; i++)
            if(mVexs[i].data==ch)
                return i;
        return -1;
    }

    /**
     * 读取一个输入字符
     */
    private char readChar() {
        char ch='0';

        do {
            try {
                ch = (char)System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while(!((ch>='a'&&ch<='z') || (ch>='A'&&ch<='Z')));

        return ch;
    }

    /**
     * 读取一个输入字符
     */
    private int readInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
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
    private void DFS(int i, boolean[] vistited){
        ENode node;
        vistited[i]= true;
        System.out.println(mVexs[i].data);
        node = mVexs[i].firstEdge;
        while (node!=null){
            if(!vistited[i]){
                DFS(node.ivex,vistited);
            }
            node = node.nextEdge;
        }
    }
    public void DFS(){
        boolean[] visited = new boolean[mVexs.length];
        System.out.print("DFS:");
        for (int i=0;i< mVexs.length;i++){
            if(!visited[i]){
                DFS(i,visited);
            }
        }
        System.out.println();
    }
    public void BFS(){
        int head =0;
        int rear = 0;
        int[] queue = new int[mVexs.length];
        boolean[] visited =new boolean[mVexs.length];
        for (int i=0;i<mVexs.length;i++){
            if(!visited[i]){
                visited[i]=true;
                System.out.printf("%c",mVexs[i]);
                queue[rear++]=i;
            }
            while (head!=rear){
                int j=queue[head++];
                ENode node = mVexs[i].firstEdge;
                while (node!=null){
                    if(!visited[node.ivex]){
                        visited[node.ivex]=true;
                        System.out.printf("%c",mVexs[node.ivex]);
                        queue[rear++]= node.ivex;
                    }
                    node= node.nextEdge;
                }
            }
        }
        System.out.println();
    }
    /*
     * 获取边<start, end>的权值；若start和end不是连通的，则返回无穷大。
     */
    private int getWeight(int start, int end) {

        if (start==end)
            return 0;

        ENode node = mVexs[start].firstEdge;
        while (node!=null) {
            if (end==node.ivex)
                return node.weight;
            node = node.nextEdge;
        }

        return INF;
    }
    public void dijkstra(int vs,int[] prev, int[] dist){
        // flag[i]=true表示"顶点vs"到"顶点i"的最短路径已成功获取。
        boolean[] flag = new boolean[mVexs.length];

        // 初始化
        for (int i = 0; i < mVexs.length; i++) {
            flag[i] = false;            // 顶点i的最短路径还没获取到。
            prev[i] = 0;                // 顶点i的前驱顶点为0。
            dist[i] = getWeight(vs, i); // 顶点i的最短路径为"顶点vs"到"顶点i"的权。
        }
        flag[vs]=true;
        dist[vs]=0;
        int k=0;
        for (int i=0;i<mVexs.length;i++){
            int min =INF;
            for(int j=0;j<mVexs.length;i++){
                if(flag[j]==false && dist[j]<min){
                    min =dist[j];
                    k=j;
                }
            }
            flag[k]=true;
            for(int j=0;j<mVexs.length;j++){
                int tmp = getWeight(k,j);
                tmp = (tmp==INF? INF:(min+tmp));
                if(flag[j]==false && tmp<dist[j]){
                    dist[j]=tmp;
                    prev[j]=k;
                }
            }
        }
        // 打印dijkstra最短路径的结果
        System.out.printf("dijkstra(%c): \n", mVexs[vs].data);
        for (int i = 0; i < mVexs.length; i++)
            System.out.printf("  shortest(%c, %c)=%d\n", mVexs[vs].data, mVexs[i].data, dist[i]);
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
        //初始化
        for (int i=0;i<mVexs.length;i++){
            for(int j=0;j<mVexs.length;j++){
                dist[i][j]= getWeight(i,j);
                path[i][j] = j;
            }
        }
        for (int k=0;k<mVexs.length;k++){
            for(int i=0;i<mVexs.length;i++){
                for (int j=0;j<mVexs.length;j++){
                    int temp = (dist[i][k]==INF || dist[k][j]==INF)? INF:(dist[i][k]+dist[k][j]);
                    int s =1;
                    if(dist[i][j]>temp){
                        dist[i][j]=temp;
                        path[i][j]=k;
                    }
                }
            }
        }
    }
}
