package week3;

/**
 * Created by sheeran on 2017/3/25.
 */
public class InsertionSort {
    public static void sort2(Comparable[] a){
        int N=a.length;
        for (int i =0;i<N;i++){
            for(int j = i;j>0;j--){
                if(SortUtil.less(a[j],a[j-1]))
                    SortUtil.exchange(a,j,j-1);
                else
                    break;
            }
        }
    }
    public static void sort(Comparable[] a){
        int length=a.length;
        for(int i=0;i<length;i++){
            for(int j=i;j>0;j--){
                if(SortUtil.less(a[j],a[j-1]))
                    SortUtil.exchange(a,j,j-1);
                else
                    break;
            }
        }

    }

}
