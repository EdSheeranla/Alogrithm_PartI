package DynamicProgram;

/**
 * Created by sheeran on 2017/4/11.
 * 给定一个n个矩阵的序列，我们需要求它们的乘，
 * 由于对于MatrixChain进行括号的位置不同，导致需要进行乘的次数也不同
 * 需要求最小进行乘积操作的方案
 */
public class MatrixChain {
    private int[][] m;  //存储需要的代价
    private int[][] s;  //记录最优值对应的k点

    class Matrix {
        int[][] value;
    }

    /**
     * 采用自底向上的动态规划
     *
     * @param mc 输入的矩阵chain
     */
    public void Matrix_Chain_Order(Matrix[] mc) {
        int n = mc.length - 1;
        //构建两个辅助表,m(1~n,1~n) s(1~n-1,2~n)
        m = new int[n + 1][n + 1];
        s = new int[n][n];
        for (int len = 2; len < n; len++) //len为matrix的长度
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                m[i][j]=-1;
                for(int k=1;k<j-1;k++) {
                    int q = m[i][k] + m[k + 1][j];
                    if(q<m[i][j]) {
                        m[i][j]=q;
                        s[i][j]=k;
                    }
                }
            }
    }

}
