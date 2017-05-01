package DynamicProgram;

/**
 * Created by sheeran on 2017/5/1.
 * Talk is cheap show me code.
 */
public class CompletePakeage {
    /**
     * 求解完全背包问题
     * 描述:n种商品,每种商品可以挑选多件
     *
     * @param c c[i] 第i种商品的花费
     * @param w w[i] 第i种商品的价值
     * @param V 背包容量
     * @return 价值数组
     */
    public int[] solution(int[] c, int[] w, int V) {
        int[] f = new int[V];
        for (int i = 0; i < c.length; i++) {
            for (int j = c[i]; j < V; j++) {
                f[j] = Math.max(f[j], f[j - c[i]] + w[i]);
            }
        }
        return f;
    }
}
