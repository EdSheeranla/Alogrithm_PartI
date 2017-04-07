package puzzle;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
/**
 * Created by sheeran on 2017/3/28.
 * 8-puzzle 问题，这个问题没有弄清楚，只是单纯的把代码根据别人的想法敲了一遍
 */
public class Solver {
    private SearchNode lastSearch;
    private class SearchNode implements Comparable<SearchNode> {
        Board board;
        SearchNode parent;
        int moves = 0;
        int priorty = board.manhattan() + moves;

        public SearchNode(Board board, SearchNode parent) {
            this.board = board;
            this.parent = parent;
            this.moves=parent.moves+1;
        }

        public SearchNode(Board board, SearchNode parent, int moves) {
            this.board = board;
            this.parent = parent;
            this.moves = moves;
        }

        @Override
        public int compareTo(SearchNode o) {
            if (this.board.equals(0)) return 0;
            if (this.priorty < o.priorty) return -1;
            return 1;
        }
    }

    public Solver(Board initial) {
        //insert inintial into openSet
        SearchNode initialNode = new SearchNode(initial, null, 0);
        SearchNode initialTwinNode = new SearchNode(initial.twin(), null, 0);
        MinPQ<SearchNode> twinOpenSet = new MinPQ<SearchNode>();
        MinPQ<SearchNode> openSet = new MinPQ<SearchNode>();
        twinOpenSet.insert(initialTwinNode);
        openSet.insert(initialNode);
        while(true){
            lastSearch=trace(openSet);
            if(lastSearch!=null&&trace(twinOpenSet)!=null)
                return;
        }
    }

    // find a solution to the initial board (using the A* algorithm)
    private SearchNode trace(MinPQ<SearchNode> searchNodes) {
        if (searchNodes.isEmpty()) return null;
        SearchNode betterNode = searchNodes.delMin();
        if (betterNode.board.isGoal()) return betterNode;
        for (Board board : betterNode.board.neighbors()) {
            if (!board.equals(betterNode.parent) || betterNode.parent == null) {
                searchNodes.insert(new SearchNode(board, betterNode));
            }
        }
        return null;
    }


    public boolean isSolvable() {

        return lastSearch!=null;
    }
    // is the initial board solvable?

    public int moves() {

        return lastSearch!=null?0:lastSearch.moves;
    }
    // min number of moves to solve initial board; -1 if unsolvable

    public Iterable<Board> solution() {
        Stack<Board> searchTrace=new Stack<Board>();
        searchTrace.push(lastSearch.board);
        while(lastSearch.parent!=null){
            searchTrace.push(lastSearch.parent.board);
            lastSearch=lastSearch.parent;
        }
        return searchTrace;
    }
    // sequence of boards in a shortest solution; null if unsolvable

    public static void main(String[] args) {

    }
    // solve a slider puzzle (given below)
}
