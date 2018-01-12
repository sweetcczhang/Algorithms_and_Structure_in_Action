package cn.bput.zcc.sortAlgorithms;

import java.util.Stack;

/**
 * Created by 张城城 on 2018/1/12.
 */
public class Tower {
    private Stack<Integer> disks;
    /*
    * @param i: An integer from 0 to 2
    */
    public Tower(int i) {
        // create three towers
        disks = new Stack<Integer>();
    }
    /*
     * @param d: An integer
     * @return: nothing
     */
    public void add(int d) {
        // Add a disk into this tower
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("Error placing disk " + d);
        } else {
            disks.push(d);
        }
    }

    /*
     * @param t: a tower
     * @return: nothing
     */
    public void moveTopTo(Tower t) {
        // Move the top disk of this tower to the top of t.
        if(!disks.isEmpty()){
            Integer top = disks.pop();
            t.add(top);
        }
    }

    /*
     * @param n: An integer
     * @param destination: a tower
     * @param buffer: a tower
     * @return: nothing
     */
    public void moveDisks(int n, Tower destination, Tower buffer) {
        // Move n Disks from this tower to destination by buffer tower
        if (n==0) return;
        if(n==1){
            moveTopTo(destination);
        }else {
            moveDisks(n-1,buffer,destination);
            moveTopTo(destination);
            buffer.moveDisks(n-1, destination, this);
        }
    }
    /*
     * @return: Disks
     */
    public Stack<Integer> getDisks() {
        // write your code here
        return disks;
    }
}
