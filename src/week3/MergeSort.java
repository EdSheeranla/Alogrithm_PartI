package week3;

import java.util.HashMap;

/**
 * Created by sheeran on 2017/3/25.
 */
public class MergeSort {

    public void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    //    private static void sort(Comparable[] a, Comparable[] aux, int low, int high) {
//        if (high <= low)
//            return;
//        int mid = low + (high - low) / 2;
//        sort(a, aux, low, mid);
//        sort(a, aux, mid + 1, high);
//        merge(a, aux, low, mid, high);
//    }
//
//
//
//
//    private static boolean isSort(Comparable[] comparables) {
//        return true;
//    }
//
//    private static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high) {
//        for (int i = 0; i < a.length; i++) {
//            aux[i] = a[i];
//        }
//
//        int i = low, j = mid + 1;
//        for (int k = low; k <= high; k++) {
//            if (i > mid) a[k] = aux[j++];
//            else if (j > mid) a[k] = aux[i++];
//            else if (less(a[j], aux[i])) a[k] = aux[j++];
//            else a[k] = aux[i++];
//        }
//    }
    private static void sort(Comparable[] a, Comparable[] aux, int low, int hi) {
        if (low > hi) return;
        int mid = (hi - low) / 2 + low;
        //进行递归排序
        sort(a, aux, low, mid);
        sort(a, aux, mid + 1, hi);
        //对排序后的数组进行合并
        merge(a, aux, low, mid, hi);
    }

    private static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int hi) {
        for (int i = 0; i<a.length;i++){
            aux[i]=a[i];
        }
        int i=low;
        int j=mid+1;
        for(int k=low;k<=hi;k++){
            if(less(a[j],aux[i])) a[k]=aux[j++];

        }
        HashMap map=new HashMap();




    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}
