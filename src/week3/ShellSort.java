package week3;

/**
 * Created by sheeran on 2017/3/25.
 */
public class ShellSort {
    public static void sort(Comparable[] a){
        int N=a.length;
        int h=1;
        while(h<N)
            h=h*3+1;
        while(h>0){
            for(int i= h;i<N;i++){
                for(int j=i;j>0;j-=h) {
                    if (SortUtil.less(a[i], a[i - h]))
                        SortUtil.exchange(a, i, i - h);
                }
            }
            h=h/3;
        }
    }
}
