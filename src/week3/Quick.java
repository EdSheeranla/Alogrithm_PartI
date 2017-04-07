package week3;

/**
 * Created by sheeran on 2017/3/27.
 */
public class Quick {
    public static void sort(Comparable[] a){
        sort(a,0,a.length-1);
    }
    public static void sort(Comparable[] a,int low,int high){
        if(low<=high) return ;
        int k=partition(a,0,a.length-1);
        partition(a,0,k-1);
        partition(a,k+1,a.length-1);

    }


    public static int partition(Comparable[] a, int low, int high) {
        int i = low;
        int j = high+1;
        while (true) {
            /**
             * 这里为什么要用++i 而不是i++,因为先赋值在进行运算
             */
            while (less(a[++i],a[low])) {
                if (i == high) break;
            }
            while (less( a[low],a[--j])) {
                if (j == low) break;
            }
            /**
             * 这里为什么使用的是大于等于 而不是大于
             */
            if(i>=j) break;
            exch(a, i, j);
        }
        exch(a,low,j);
        return j;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int x, int y) {
        Comparable aux = a[x];
        a[x] = a[y];
        a[y] = aux;
    }

    public static void main(String[] args) {
        Comparable[] a={4,8,4,3,6,7,9,2,7,2};
        Quick p=new Quick();
        p.partition(a,0,a.length-1);
    }
}
