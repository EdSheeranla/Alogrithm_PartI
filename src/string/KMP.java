package string;

/**
 * Created by sheeran on 2017/4/23.
 */
public class KMP {
    private String patt;
    private int[][] dfa;

    /**
     * 根据给定的pattern计算对应的dfa数组
     * @param patt
     */
    public KMP(String patt){
        this.patt=patt;
        int M=patt.length();
        int R=256;
        dfa=new int[R][M];
        dfa[patt.charAt(0)][0]=1;
        for(int X=0,j=1;j<M;j++){
            for(int c=0;c<R;c++) {
                dfa[c][j] = dfa[c][X];
            }
            dfa[patt.charAt(j)][j]=j+1;
            X=dfa[patt.charAt(j)][X];
        }
    }

    /**
     * 再对应的txt中查找指定的pattern字符串
     * @param txt
     * @return
     */
    public int search(String txt){
        int i,j,N=txt.length();
        int M=patt.length();
        for(i=0,j=0;i<N&&j<M;i++){
            j=dfa[txt.charAt(i)][j];
        }
        if(j==M) return i-M;
        else return N;
    }
}
