package DynamicProgram;

import org.junit.Test;

/**
 * Created by sheeran on 2017/5/1.
 * Talk is cheap show me code.
 */
public class ZeroOnePackage {
    /**
     * 对 0-1背包问题进行求解
     *
     * @param c c[i]  第i件商品的花费
     * @param w w[i]  第i件商品的价值
     * @param V 背包的容量
     * @return
     */
    public static int[] solution(int[] c, int[] w, int V) {
        int N = c.length;
        int[] f = new int[V];
        //初始化
        for (int i = 0; i < V; i++)
                f[i] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = V-1; j > c[i]; j--)
                f[j] = Math.max(f[j], f[j - c[i]] + w[i]);
        }
        return f;
    }

    public static void main(String[] args) {
        int[] c={2,2,6,5,4};
        int[] w={6,3,5,4,6};
        int V=10;
        solution(c,w,V);
    }

}
