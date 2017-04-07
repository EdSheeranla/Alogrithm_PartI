package week3;

/**
 * Created by sheeran on 2017/3/25.
 */

public class SortUtil {
    public static boolean less(Comparable t, Comparable v){
        return t.compareTo(v)<0;
    }
    public static void exchange(Comparable[] a,int i,int j){
        Comparable swap=a[i];
        a[i]=a[j];
        a[j]=swap;
    }
}
