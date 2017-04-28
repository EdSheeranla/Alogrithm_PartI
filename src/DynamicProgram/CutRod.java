package DynamicProgram;


/**
 * Created by sheeran on 2017/4/11.
 * 已知一段长度为i英寸的钢条，将其分割为短钢条进行出售
 * 钢条长度和价格  长度  1 2 3 4 5 6 7 8 9 10
 * 价格  1 5 8 9 10 7 17 20 24 30
 * 求出售钢条收益最大的方案
 */
public class CutRod {
    private final static int[] PRICE = {0, 1, 5, 8, 9, 10, 7, 17, 20, 24, 30};   //钢条对应的价格,index表示长度,value表示价格

    /**
     * 自顶向下的递归求解
     *
     * @param len 钢条长度
     * @return 最大收益
     */
    public int cut_Rod(int len) {
        if (len == 0) return 0;
        int Max_Price = -1;
        for (int i = 1; i <= len; i++)
            Max_Price = Math.max(Max_Price, PRICE[i] + cut_Rod(len - i));
        return Max_Price;
    }

    /**
     * 带备忘录的自顶向下递归求解
     *
     * @param len
     * @return
     */
    public int memoization_Cut_Rod(int len) {
        int r[] = new int[len + 1];
        for (int i = 0; i < len + 1; i++) r[i] = -1; //对于备忘录进行初始化
        return memoization_Cut_Rod_Aux(len, r);
    }

    /**
     * 进行递归求解
     *
     * @param len
     * @param r   备忘录
     * @return
     */
    private int memoization_Cut_Rod_Aux(int len, int[] r) {
        if (r[len] != -1) return r[len];
        if (len == 0) return 0;
        int Max_Price = -1;
        for (int i = 1; i <= len; i++)
            Max_Price = Math.max(Max_Price, PRICE[i] + cut_Rod(len - i));
        //将递归的结果存到备忘录中
        r[len] = Max_Price;
        return Max_Price;
    }

    /**
     * 采用自底向上的递归进行动态规划
     *
     * @param len
     * @return
     */
    private int[] s=null;
    public int bouutom_Up_Cut_Rod2(int len) {
        s=new int[len+1];
        int[] r = new int[len+1];
        r[0] = 0;
        int Max_Price = -1;
        for (int j = 1; j <= len; j++) {
            for (int i = 1; i <= j; i++){
                //将最优切割进行了保存
                if(Max_Price<PRICE[i] + r[j - i]){
                    Max_Price=PRICE[i]+r[j-i];
                    s[j]=i;
                }
            }
            r[j] = Max_Price;
        }
        for(int i:s){
            System.out.println(i);

        }
        return Max_Price;
    }

    public int bouutom_Up_Cut_Rod(int len) {
        int[] r = new int[len+1];
        r[0] = 0;
        int Max_Price = -1;
        for (int j = 1; j <= len; j++) {
            /**
             * 从最底层开始向上进行查找，并且将每一层的最优解保存，然后进行比较
             */
            for (int i = 1; i <= j; i++){
                Max_Price = Math.max(Max_Price, PRICE[i] + r[j - i]);
            }
            r[j] = Max_Price;
        }
        return Max_Price;
    }

    public static void main(String[] args) {
        CutRod cd = new CutRod();
        long start = System.currentTimeMillis();
        System.out.println(cd.cut_Rod(10) + "          耗时" + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        System.out.println(cd.memoization_Cut_Rod(10) );
        System.out.println(cd.bouutom_Up_Cut_Rod2(4));

    }

}
