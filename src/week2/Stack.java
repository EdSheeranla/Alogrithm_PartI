package week2;

import java.util.List;

/**
 * Created by sheeran on 2017/3/24.
 * 使用链表来创建stack
 */
public class Stack {
    private Node first=null;
    private class Node{
        String item;
        Node next;
    }
    public boolean isEmpty(){
        return first.next==null;
    }
    public void push(String item){
        Node oldNode=first;
        first.item=item;
        first.next=null;
        first.next=oldNode;
    }
    public String pop(){
        String item=first.item;

        first=first.next;
        return item;
    }

}
