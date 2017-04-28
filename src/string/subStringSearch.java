package string;

/**
 * Created by sheeran on 2017/4/23.
 */
public class subStringSearch {
    /**
     * 最原始的暴力搜索子字符串的方法
     * @param txt
     * @param patt
     * @return
     */
    public static int search(String txt,String patt){
        int M=txt.length();
        int N=patt.length();
        for(int i=0;i<M;i++){
            int j;
            for(j=0;j<N;j++){
                if(txt.charAt(i+j)!=patt.charAt(j)) break;
                if(j==N-1) return i;
            }
        }
        return M;
    }

    /**
     * 采用显式回退的暴力搜索方法
     * @param txt
     * @param patt
     * @return
     */
    public static int backSearch(String txt,String patt){
        int i,M=txt.length();
        int j,N=patt.length();
        for(i=0,j=0;i<M&&j<N;i++){
            if(txt.charAt(i)==patt.charAt(j)) j++;
            else {
                i-=j;
                j=0;
            }
        }
        return M;
    }

    public static void main(String[] args) {
        System.out.println(search("aaaaabb","abb"));
    }
}
