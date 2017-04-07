package week3;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by sheeran on 2017/3/25.
 * 创建一个queue能够随机的返回一个queue中的成员
 * 创建一个数组来存储
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] storage;
    private int N=0;
    private int size=0;
    public RandomizedQueue() {
        Object[] objs=new Object[1];
        storage = (Item[]) objs;
    }                 // construct an empty randomized queue

    public boolean isEmpty() {
        return N==0;
    }                 // is the queue empty?

    public int size() {
        return size;
    }                        // return the number of items on the queue

    public void enqueue(Item item) {
        storage[N++]=item;
        size++;
    }
    // add the item

    /**
     * 这里可以使用将最后一个数和我们需要取出的数进行交换
     * 同时这里的数组尺寸大小的考虑
     * @return
     */
    public Item dequeue() {
        Random random = new Random(47);
        Item randomItem=null;
        while((randomItem=storage[random.nextInt(N)])!=null){
        }
        randomItem=null;
        size--;
        return randomItem;
    }
    // remove and return a random item
    public void resize(int length){
        Object[] copy=new Object[length];
        for (int i =0;i<length;i++){
            copy[i]=storage[i];
        }
    }
    public Item sample() {
        Random random = new Random(47);
        Item randomItem=null;
        while((randomItem=storage[random.nextInt(N)])!=null){
            return randomItem;
        }
        return null;
    }                     // return (but do not remove) a random item

    public Iterator<Item> iterator() {
            return new Iterator<Item>() {
                public boolean hasNext() {
                    return size==0;
                }

                public Item next() {
                    return dequeue();
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
    }     // return an independent iterator over items in random order

    public static void main(String[] args) {

    }// unit testing (optional)
}
