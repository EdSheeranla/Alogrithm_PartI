package week2;

import java.util.Iterator;

/**
 * Created by sheeran on 2017/3/24.
 * 使用动态增长的数组来创建StringQueue
 */
public class QueueOfString2 implements Iterable{

    private String[] queue=new String[1];

    private int head=0;
    private int tail=0;
    public void enQueue(String item){
        if(tail ==queue.length)
            resize(queue.length*2);
        queue[tail++]=item;

    }

    /**
     * 改变数组的大小的时候，head指向为0；tail指向不为null的最后一个元素
     * @param length
     */
    public void resize(Integer length){
        String[] copy = new String[length];
        for(int i = 0;i < queue.length ; i++){
            if(queue[i]!=null){
                copy[i]=queue[i];
                tail=i;
            }
        }
        head=0;
        queue = copy;
    }

    public String deQueue(){
        String str= queue[++head];
        if(head ==queue.length/4)
            resize(queue.length/2);
        return str;
    }
    public Boolean isEmpty(){
        return false;
    }

    public Iterator iterator() {
        return new Iterator() {
            public boolean hasNext() {
                return queue[tail]!=null;
            }

            public Object next() {
                return queue[tail++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
