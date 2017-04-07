package CollinearPoints;

/**
 * Created by sheeran on 2017/3/26.
 */
public class BruteCollinearPoints {
    private LineSegment[] lineSegments = null;
    private int size = 0;
    private int N = 0;
    private Point[] points = null;

    /**
     * 找到所有的四个点以上的线段
     * 想法1：将所有的点进行排序，对排序之后的数组进行遍历，求出两点之间的slop，由于slop是递增的，
     * 所以当连续相等的slop的个数大于4的时候，就可以
     *
     * @param points
     */
    public BruteCollinearPoints(Point[] points) {
        this.points = points;
        int N = points.length;
        lineSegments = new LineSegment[N];
    } // finds all line segments containing 4 points

    private void Sort(Point[] points, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (less(points[j], points[j - 1]))
                    exc(points[j], points[j - 1]);
                else
                    break;
            }
        }
    }

    private boolean less(Point a, Point b) {
        return a.compareTo(b) > -1;
    }

    private void exc(Point a, Point b) {
        Point temp = a;
        a = b;
        b = temp;
    }

    public int numberOfSegments() {
        return size;
    }

    public LineSegment[] segments() {
        Sort(points, N);
        findSegment();
        return lineSegments;
    }

    private void findSegment() {
        for (int i = 0; i < N; i++) {
            Point start = points[i];
            for (int j = i; j < N; j++) {
                int n = 0;
                Point end = points[j];
                if (start.slopeTo(end) == start.slopeTo(points[j - 1]))
                    n++;
                else if (n >= 4) {
                    size++;
                    LineSegment segment = new LineSegment(start, end);
                    lineSegments[size] = segment;
                    n = 0;
                }
            }
        }
    }
}
