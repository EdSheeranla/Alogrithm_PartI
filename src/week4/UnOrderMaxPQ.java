package week4;

/**
 * Created by sheeran on 2017/3/28.
 */
public class UnOrderMaxPQ < KEY extends Comparable<KEY>>{
    private KEY[] pq;
    private int N=0;

    public UnOrderMaxPQ(KEY v,int capacity){
        pq=(KEY[])new Comparable[capacity];
    }
    public void insert(KEY v){
       pq[N++]=v;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public KEY delMax(){
        if(N==0) throw new NullPointerException();
        int max=0;
        for(int i=0;i<N;i++){
            if(less(max,i))
                max=i;
            exc(max,N-1);
        }
        return pq[N--];
    }
    private boolean less(int a,int b){
        return pq[a].compareTo(pq[b])<0;
    }
    private void exc(int a,int b){
        KEY aux=pq[a];
        pq[b]=pq[a];
        pq[a]=aux;
    }

}
