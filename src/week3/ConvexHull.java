package week3;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Stack;

/**
 * Created by sheeran on 2017/3/25.
 * 凸包问题
 */
public class ConvexHull {
    public void find(Point2D a,Point2D b,Point2D c){
        Stack<Point2D> point2DStack=new Stack<Point2D>();
        point2DStack.push(a);
        point2DStack.push(b);
        if(Point2D.ccw(a,b,c)<=0){

        }
    }
}
