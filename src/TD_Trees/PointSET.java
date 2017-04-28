package TD_Trees;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;


/**
 * Created by sheeran on 2017/3/31.
 */
public class PointSET {
    private SET<Point2D> pointSet;
    private Node root;

    /**
     * 创建一个BST？ 然后用set来存储，使用root来进行树形结构的保持？
     */
    private class Node {
        Point2D point2D;
        Node left, right;
        int level;

        public Node(Point2D point2D, int level) {
            this.point2D = point2D;
            this.level = level;

        }
    }

    public PointSET() {
        pointSet = new SET<Point2D>();

    }                 // construct an empty set of points

    public boolean isEmpty() {
        return pointSet.isEmpty();
    }               // is the set empty?

    public int size() {
        return pointSet.size();
    }         // number of points in the set

    public void insert(Point2D p) {
        root=put(root,p);
        pointSet.add(p);
    }        // add the point to the set (if it is not already in the set)

    private Node put(Node x, Point2D p) {
        int level = 1;
        if (x == null) return new Node(p, level);
        if (level % 2 != 0) {
            if (x.point2D.x() > p.x()) return put(x.left, p);
            else return put(x.right, p);
        } else {
            if (x.point2D.y() > p.y()) return put(x.left, p);
            else return put(x.right, p);
        }
    }

    public boolean contains(Point2D p) {
        return pointSet.contains(p);
    }         // does the set contain point p?

    public void draw() {
        for (Point2D p:
             pointSet) {
            p.draw();
        }
    }    // draw all points to standard draw

    public Iterable<Point2D> range(RectHV rect) {
        Double rect_xmax=rect.xmax();
        Double rect_xmin=rect.xmin();
        Double rect_ymax=rect.ymax();
        Double rect_ymin=rect.ymin();
        Queue<Point2D> queue=new Queue<Point2D>();
        if(rect.contains(root.point2D)) queue.enqueue(root.point2D);

        return null;
    }// all points that are inside the rectangle
    private int isinLeft(RectHV rect,Node node){
        if(rect.contains(node.point2D)) return 0;
        if(rect.xmax()<node.point2D.x()) return -1;
        if(rect.xmin()>node.point2D.x()) return +1;
        return 0;
    }
    public Point2D nearest(Point2D p) {
        return null;
    }// a nearest neighbor in the set to point p; null if the set is empty

    public static void main(String[] args) {

    }        // unit testing of the methods (optional)
}
