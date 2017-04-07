package week3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

import java.awt.event.ItemEvent;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by sheeran on 2017/3/24.
 */
public class Deque<Item> implements Iterable<Item>{
    private Node<Item> first;
    private Node<Item> last;
    private int n;
    private class Node<Item>{
        Item item;
        Node<Item> prev;
        Node<Item> next;
    }
    public Deque(){
        first=null;
        last=null;
    }                           // construct an empty deque
    public boolean isEmpty() {
        return last.next==null;
    }                // is the deque empty?

    public int size()  {
        return  n;
    }                      // return the number of items on the deque
    public void addFirst(Item item){
        Node<Item> oldFirst=first;
        Node<Item> newNode=new Node<Item>();
        newNode.item=item;
        first=newNode;
        //当first为null的时候，将first的prev设置为last
        if(last.prev==null)
            first=last;
        oldFirst.next=first;
        n++;
    }          // add the item to the front
    public void addLast(Item item)  {
        Node<Item> oldLast=last;
        Node<Item> newNode=new Node<Item>();
        newNode.item=item;
        last=newNode;
        last.prev=oldLast;
        n++;
    }         // add the item to the end
    public Item removeFirst()      {
        first=first.next;
        return first.item;

    }          // remove and return the item from the front
    public Item removeLast()      {
        last=last.prev;
        return last.item;
    }           // remove and return the item from the end
    public Iterator<Item> iterator()   {
        return new Iterator<Item>() {
            public boolean hasNext() {

                return last.next==null;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public Item next() {

                return removeFirst();
            }
        };
    }      // return an iterator over items in order from front to end
    public static void main(String[] args) {

    }  // unit testing (optional)
}
