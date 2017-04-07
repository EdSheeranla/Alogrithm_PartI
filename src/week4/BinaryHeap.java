package week4;

import java.util.Vector;

/**
 * Created by sheeran on 2017/3/28.
 */
public class BinaryHeap<KEY extends Comparable<KEY>> {
    private KEY[] pq;
    private int N=0;
    public BinaryHeap(int initCapacity){
        pq=(KEY[]) new Comparable[initCapacity+1];
    }
    /**
     * 有child来查找parent进行比较
     * @param k
     */
    public void swim(int k) {

        while (k>1 && less(k/2,k)) {
            exc(k/2,k);
            k=k/2;
        }

    }
    public void insert(KEY v){
        pq[++N]=v;
        swim(N);
    }
    public KEY delMax(){
        KEY max=pq[1];
        exc(1,N--);
        sink(1);
        pq[N+1]=null;
        return max;
    }
    /**
     * 从parent来查找children进行比较
     * @param k
     */
    public void sink(int k){
        while(2*k<=N){
            int j = 2*k;
            if(j<N && less(j,j+1)) j++;
            if(!less(k,j)) break;
            exc(k,j);
            k=j;
        }
    }

    private boolean less(int a, int b) {
        return pq[a].compareTo(pq[b]) < 0;
    }

    private void exc(int a, int b) {
        KEY aux = pq[a];
        pq[a] = pq[b];
        pq[b] = aux;
    }

    public static void main(String[] args) {
        BinaryHeap<Integer> bh=new BinaryHeap<Integer>(5);
        for(int i=1;i<6;i++){
            bh.insert(i);
        }
        bh.delMax();

    }
}
