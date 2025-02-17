package boardgame;
import puzzle.solver.BreadthFirstSearch;

/**
 *Solving the boardgame using {@code BreadthFirstSearch}.
 */
public class MainSolver {
    /**
     * Use only for simulating moves.
     */
    public static void main(String[] args) {
        new BreadthFirstSearch<Integer>().solveAndPrintSolution(new BoardState());
    }

}