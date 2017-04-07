import org.junit.Test;
import week3.Quick;

/**
 * Created by sheeran on 2017/3/27.
 */
public class PartitionTest {
    @Test
    public void testPartition(){
        Comparable[] a={4,8,4,3,6,7,9,2,7,2};
        Quick p=new Quick();
        p.partition(a,0,a.length);
    }
}
