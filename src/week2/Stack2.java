package week2;

/**
 * Created by sheeran on 2017/3/24.
 * 使用数组来创建stack
 */
public class Stack2 {
    private int N=0;
    private String[] stack;

    public void push(String item){
        if(N==stack.length){
            resize(stack.length);
        }
        stack[N++]=item;


    }

    /**
     * 数组进行动态扩容
     * @param length
     */
    private void resize(int length) {
        String[] copy= new String[length*2];
        for(int i = 0;i<stack.length;i++){
            copy[i]=stack[i];
        }
        stack=copy;
    }

    public boolean isEmpty(){
        return N==0;
    }
    public String pop(){
        stack[N]=null;
        if( N>0 && N==stack.length/4)
            resize(stack.length/2);
        return stack[N--];
    }
}
