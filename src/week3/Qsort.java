package week3;

import java.util.Arrays;

/**
 * Created by sheeran on 2017/3/27.
 * 三路排序
 */
public class Qsort {
    public void sort(Comparable[] a, int low, int high) {
        if (low > high) return;
        Comparable v = a[low];
        int lt = low;
        int gt = high;
        int i = low;
        while (i < gt) {
            int comp = a[i].compareTo(v);
            if (less(a[i], v)) exch(a, i++, lt++);
            else if (less(v, a[i])) exch(a, i, gt--);
            else i++;
        }
        sort(a,low,lt-1);
        sort(a,gt+1,high);

    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int x, int y) {
        Comparable aux = a[x];
        a[y] = a[x];
        a[x] = aux;
    }
}
