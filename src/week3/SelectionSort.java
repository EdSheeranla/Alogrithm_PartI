package week3;

/**
 * Created by sheeran on 2017/3/25.
 */


public class SelectionSort {

    public static void sort(Comparable[] comparables){
        for(int i=0;i<comparables.length;i++){
            int min = i;
            for(int j=i;j<comparables.length;j++){
                if(SortUtil.less(comparables[j],comparables[min]))
                    SortUtil.exchange(comparables,j,min);
                min=j;
            }
        }

    }

    public static void main(String[] args){
        Comparable[] nums={1,5,6,7,5,7,2,1};
        for(int i =0;i<nums.length;i++){
            int min=i;
            for(int j=0;j<nums.length;j++){
                if(SortUtil.less(nums[j],nums[min]))
                    min=j;
                SortUtil.exchange(nums,min,j);
            }
        }
    }
}
