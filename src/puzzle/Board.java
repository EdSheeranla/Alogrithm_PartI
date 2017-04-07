package puzzle;

import edu.princeton.cs.algs4.MinPQ;

import java.util.Comparator;

/**
 * Created by sheeran on 2017/3/28.
 */
public class Board {
    private int[][] blocks;
    private int N;

    public Board(int[][] blocks) {
        N = blocks.length;
        this.blocks = new int[N][N];
        copy(blocks);
        this.blocks = blocks;

    }

    private void copy(int[][] blocks) {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                this.blocks[i][j] = blocks[i][j];
    }

    // construct a board from an n-by-n array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public int dimension() {
        return N;
    }

    // board dimension n
    public int hamming() {
        return 0;
    }

    // number of blocks out of place
    public int manhattan() {
        int distance = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (blocks[i][j] != 0)
                    distance += Math.abs((blocks[i][j] - 1) / N - j) + Math.abs(blocks[i][j] % N);
        return distance;
    }

    // sum of Manhattan distances between blocks and goal
    public boolean isGoal() {
        return hamming() == 0;
    }

    // is this board the goal board?
    public Board twin() {
        int[][] twinBlocks = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                twinBlocks[i][j] = blocks[i][j];
        if (blocks[0][0] != 0 && blocks[0][1] != 0) {
            int temp = twinBlocks[0][0];
            twinBlocks[0][0] = twinBlocks[0][1];
            twinBlocks[0][1] = twinBlocks[0][0];
        } else {
            int temp = twinBlocks[1][0];
            twinBlocks[1][0] = twinBlocks[1][1];
            twinBlocks[1][1] = twinBlocks[1][0];
        }
        return new Board(twinBlocks);
    }

    // a board that is obtained by exchanging any pair of blocks
    public boolean equals(Object y) {
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != Board.class) return false;
        Board temp = (Board) y;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (blocks[i][j] != temp.blocks[i][j]) return false;
        return true;
    }

    // does this board equal y?
    public Iterable<Board> neighbors() {
        int blank_x = 0;
        int blank_y = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (blocks[i][j] == 0) {
                    blank_x = i;
                    blank_y = j;
                    break;
                }
        final MinPQ<Board> boardMinPQ=new MinPQ<Board>(new Comparator<Board>() {
            @Override
            public int compare(Board o1, Board o2) {
                if(o1.manhattan()<o2.manhattan()) return -1;
                else if(o1.manhattan()==o2.manhattan()) return 0;
                else return 0;
            }
        });
        if(blank_x!=0&&blank_y!=0&&blank_x!=N&&blank_y!=N) {
            //当blank在中间的时候有4个 neighbor
            boardMinPQ.insert(swap(blank_x, blank_y, blank_x - 1, blank_y - 1));
            boardMinPQ.insert(swap(blank_x, blank_y, blank_x - 1, blank_y + 1));
            boardMinPQ.insert(swap(blank_x, blank_y, blank_x + 1, blank_y + 1));
            boardMinPQ.insert(swap(blank_x, blank_y, blank_x + 1, blank_y - 1));
        }else if(blank_x==0&&blank_y==0){
            boardMinPQ.insert(swap(blank_x,blank_y,blank_x+1,blank_y));
            boardMinPQ.insert(swap(blank_x,blank_y,blank_x,blank_y+1));
        }else if(blank_x==0&&blank_y==N){
            boardMinPQ.insert(swap(blank_x,blank_y,blank_x+1,blank_y));
            boardMinPQ.insert(swap(blank_x,blank_y,blank_x,blank_y-1));
        }else if(blank_x==N&&blank_y==0){
            boardMinPQ.insert(swap(blank_x,blank_y,blank_x-1,blank_y));
            boardMinPQ.insert(swap(blank_x,blank_y,blank_x,blank_y+1));
        }else if(blank_x==N&&blank_y==N){
            boardMinPQ.insert(swap(blank_x,blank_y,blank_x-1,blank_y));
            boardMinPQ.insert(swap(blank_x,blank_y,blank_x,blank_y-1));
        }else if(blank_x==0&&blank_y!=0&&blank_y!=N){
            boardMinPQ.insert(swap(blank_x,blank_y,blank_x,blank_y-1));
            boardMinPQ.insert(swap(blank_x,blank_y,blank_x,blank_y+1));
        }else if(blank_y==0&&blank_x!=0&&blank_x!=N){
            boardMinPQ.insert(swap(blank_x,blank_y,blank_x-1,blank_y));
            boardMinPQ.insert(swap(blank_x,blank_y,blank_x+1,blank_y));
        }
        return boardMinPQ;
    }
    //swap the block
    private Board swap(int blank_x,int blank_y,int x,int y){
        int[][] neighborBlocks = new int[N][N];
        for(int i =0;i<N;i++)
            for(int j=0;j<N;j++)
                neighborBlocks[i][j]=blocks[i][j];
        neighborBlocks[blank_x][blank_y]=neighborBlocks[x][y];
        neighborBlocks[x][y]=0;
        return new Board(neighborBlocks);
    }

    // all neighboring boards
    public String toString() {
        return "";
    }
    // string representation of this board (in the output format specified below)

    public static void main(String[] args) {
    }
    // unit tests (not graded)
}
