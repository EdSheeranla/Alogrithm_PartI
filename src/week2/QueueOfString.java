package week2;

/**
 * Created by sheeran on 2017/3/24.
 * 使用链表来创建自己的queue，采用FIFO原则
 */
public class QueueOfString {
    private Node first,last;
    private class Node{
        String item;
        Node next;
    }
    public void enQueue(String item){
        Node olNode=last;
        last.item=item;
        last.next=null;
        if(isEmpty())
            first=last;
        else
            olNode.next=last;
    }
    public String deQueue(){
        String str=first.item;
        first = first.next;
        if(isEmpty())
            last=null;
        return str;
    }
    public boolean isEmpty(){
        return first==null;
    }

}
