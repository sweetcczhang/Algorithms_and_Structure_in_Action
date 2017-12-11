package cn.bput.zcc.graphAlgorithms;

import java.io.IOException;
import java.util.Scanner;

/**
 * Java: 邻接表表示的"无向图(List Undirected Graph)"
 *
 * Created by 张城城 on 2017/12/10.
 */
public class ListUDG {
    //邻接表中对应的链表节点
    class ENode{
        int ivex;           // 该边所指向的顶点的位置
        ENode nextENode;   // 指向下一条弧的指针
    }
    //邻接表中的顶点
    class VNode{
        char data;     //顶点信息
        ENode firstEdge;   //指向第一条依附该顶点的弧
    }

    private VNode[] mVexs;  //顶点数组

    /**
     * 创建图（自己输入数据）
     */

    public ListUDG(){
        //输入顶点和边数
        System.out.printf("input vertex number: ");
        int vlen = readInt();
        System.out.printf("input edge number: ");
        int elen = readInt();
        if ( vlen < 1 || elen < 1 || (elen > (vlen*(vlen - 1)))) {
            System.out.printf("input error: invalid parameters!\n");
            return ;
        }
        //初始化“顶点”
        mVexs = new VNode[vlen];
        for(int i =0; i<mVexs.length;i++){
            System.out.printf("vertex(%d): ", i);
            mVexs[i] = new VNode();
            mVexs[i].data = readChar();
            mVexs[i].firstEdge = null;
        }
        // 初始化"边"
        for (int i =0;i<elen;i++){
            // 读取边的起始顶点和结束顶点
            System.out.printf("edge(%d):", i);
            char c1 = readChar();
            char c2 = readChar();
            int p1 = getPosition(c1);
            int p2 = getPosition(c2);
            // 初始化 node1
            ENode node1 = new ENode();
            node1.ivex =p2;
            // 将node1链接到"p1所在链表的末尾"
            if(mVexs[p1].firstEdge == null)
                mVexs[p1].firstEdge = node1;
            else
                linkLast(mVexs[p1].firstEdge, node1);
            // 初始化node2
            ENode node2 = new ENode();
            node2.ivex = p1;
            // 将node2链接到"p2所在链表的末尾"
            if(mVexs[p2].firstEdge == null)
                mVexs[p2].firstEdge = node2;
            else
                linkLast(mVexs[p2].firstEdge, node2);
        }
    }


    /**
     * 创建图(用已提供的矩阵)
     *
     * 参数说明：
     *     vexs  -- 顶点数组
     *     edges -- 边数组
     */
    public ListUDG(char[] vexs, char[][] edges){

        //初始化顶点和边数
        int vlen = vexs.length;
        int elen = edges.length;

        //初始化顶点
        mVexs = new VNode[vlen];
        for (int i=0; i<vlen; i++){
            mVexs[i] = new VNode();
            mVexs[i].data = vexs[i];
            mVexs[i].firstEdge =null;
        }
        //初始化边
        for(int i=0; i<elen; i++){

            char ch1 = edges[i][0];
            char ch2 = edges[i][1];

            int p1 = getPosition(ch1);
            int p2 = getPosition(ch2);
            ENode node1 = new ENode();
            node1.ivex = p2;
            if(mVexs[p1].firstEdge==null){
                mVexs[p1].firstEdge = node1;
            }else {
                linkLast(mVexs[p1].firstEdge,node1);
            }
            ENode node2 = new ENode();
            node1.ivex = p1;
            if(mVexs[p2].firstEdge == null){
                mVexs[p2].firstEdge = node2;
            }else {
                linkLast(mVexs[p2].firstEdge, node2);
            }

        }
    }

    /**
     * 深度优先搜索遍历图的递归实现
     */

    public void dfs(int i, boolean[] visited){
        ENode node;
        visited[i] = true;
        System.out.printf("%c ", mVexs[i].data);
        node = mVexs[i].firstEdge;
        while (node != null){
            if(!visited[node.ivex]){
                dfs(node.ivex,visited);
            }
            node = node.nextENode;
        }
    }
    /**
    * 深度优先搜索遍历图
    */
    public void DFS(){
        boolean[] visited = new boolean[mVexs.length];
        //初始化所有顶点都没有被访问
        for(int i=0;i<mVexs.length;i++){
            visited[i]=false;
        }
        System.out.printf("DFS:");
        for(int i=0; i<mVexs.length;i++){
            if(!visited[i]){
                dfs(i,visited);
            }
            System.out.println();
        }
    }

    public void BFS(){
        int head = 0;
        int rear = 0;
        int[] queue = new int[mVexs.length];    //辅助队列
        boolean[] visited = new boolean[mVexs.length];  //顶点访问标记

        for(int i =0; i<mVexs.length;i++){
            visited[i] = false;
        }
        System.out.printf("BFS: ");
        for(int i=0;i<mVexs.length;i++){
            if(!visited[i]){
                visited[i]=true;
                System.out.printf("%c ", mVexs[i].data);
                queue[rear++] = i;       //入队列
            }
            while (head!=rear){
                int j = queue[head++];   //出队列
                ENode node = mVexs[j].firstEdge;
                while (node!=null){
                    int k = node.ivex;
                    if(!visited[k]){
                        visited[k] = true;
                        System.out.printf("%c ", mVexs[k].data);
                        queue[rear++] = k;
                    }
                    node = node.nextENode;
                }
            }
        }
        System.out.printf("\n");
    }




    private void linkLast(ENode list, ENode node){
        ENode p = list;
        while (p.nextENode!=null){
            p = p.nextENode;
        }
        p.nextENode = node;
    }

    /*
     * 返回ch位置
     */
    private int getPosition(char ch) {
        for(int i=0; i<mVexs.length; i++)
            if(mVexs[i].data==ch)
                return i;
        return -1;
    }


    /*
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


    /*
     * 读取一个输入字符
     */
    private int readInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}

