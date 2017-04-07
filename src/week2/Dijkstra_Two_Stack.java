package week2;

import java.util.*;
import java.util.Stack;

/**
 * Created by sheeran on 2017/3/24.
 */
public class Dijkstra_Two_Stack {
    /**
     * 采用Dijkstra双栈法进行计算
     * 遇到数字放入value stack
     * 遇到操作符放入operation stack
     * 遇到左括号hulue，遇到右括号，将value stack的两个数和operation stack中操作符进行运算
     */
    private static java.util.Stack<String> operationStack=new Stack<String>();
    private static java.util.Stack<Double> valueStack=new Stack<Double>();
    private static class Data{

        public boolean isEmpty;
    }
    public static void main(String[] args) {
        Data StdIn =new Data();
        while(!StdIn.isEmpty){

        }
    }

}
