package week3;

import edu.princeton.cs.algs4.StdIn;

/**
 * Created by sheeran on 2017/3/25.
 */
public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue randomizedQueue=new RandomizedQueue();
        if(args.length<1){
            throw new IllegalArgumentException("IllegalArgument");
        }
        if(args[0].equals("3")){
            String input=StdIn.readLine();
            for (String in: input.split(" ")) {
                randomizedQueue.enqueue(in);
            }
        }
        if(args[0].equals("8")){
            String input=StdIn.readLine();
            for (String in: input.split(" ")) {
                randomizedQueue.enqueue(in);
            }
        }


        StdIn.readLine();
    }
}
