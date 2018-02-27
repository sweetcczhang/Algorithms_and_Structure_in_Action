package cn.bput.zcc.dataStruck;

import java.util.ArrayList;

/**
 * Created by 张城城 on 2018/2/27.
 */

/**
 * 堆的实现。
 * 堆逻辑上表现为二叉树，但是在物理上表现为数组。节点编号默认从零开始。
 * 构造函数：public Heap(boolean flag)当flag为true时构建小顶堆，当flag为false
 * 构建大顶堆
 * 方法：
 * public int poll() 返回堆顶元素，若堆为空则返回最大整数
 * public void offer(int data) 插入一个元素
 * public int size() 返回堆中元素的个数
 * public int top() 返回堆顶的元素
 *
 */
public class Heap {
    private ArrayList<Integer> array;
    private boolean flag;
    public Heap(boolean flag){
        this.flag = flag;
        this.array = new ArrayList<Integer>();
    }
    public int poll(){
        int top = top();
        if(top==Integer.MAX_VALUE){
            return top;
        }
        array.set(0,array.get(size()-1));
        array.remove(size()-1);
        shiftDown();
        return top;
    }

    public void shiftDown(){
        int index = 0;
        int len = size();
        int child ;
        int temp ;
        for(; 2*index+1<len;index=child){
            child = 2*index+1;
            if(child<len-1 && !isOrder(array.get(child),array.get(child+1))){
                child++;
            }
            if(isOrder(index,child)){
                break;
            }
            temp = array.get(index);
            array.set(index,array.get(child));
            array.set(child, temp);
        }
    }


    public void offer(int data){
        array.add(data);
        int index = array.size()-1;
        shiftUp(index);
    }

    public void shiftUp(int index){
        while (index!=0) {
            int parent = (index - 1) / 2;
            if (isOrder(array.get(parent), array.get(index))) {
                break;
            }
            int temp = array.get(parent);
            array.set(parent, array.get(index));
            array.set(index, temp);
            index = parent;
        }
    }
    public boolean isOrder(int parent, int child){
        if(flag){
            return parent>child ? false : true;
        }else {
            return parent>child ? true : false;
        }
    }

    public int top(){
        if(array.size()<1)
            return Integer.MAX_VALUE;
        else
            return array.get(0);
    }

    public int size(){
        return array.size();
    }
}
