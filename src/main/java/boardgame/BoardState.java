package boardgame;
import lombok.Getter;
import puzzle.State;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents the model of the game. Storing the state of the game and the actual position of the {@code Figure}.
 * It implements the State interface methods.
 * @see <a href="https://arato.inf.unideb.hu/jeszenszky.peter/swe/lab/swe-assignments_hu.pdf">1.29 választható házifeladat</a>
 */
@Getter
public class BoardState implements State<Integer>{

    /**
     * Maximum value of the table.
     */
    public static final int BOARD_SIZE_MAX_LENGTH = 7;

    /**
     * Minimum value of the table.
     */
    public static final int BOARD_SIZE_MIN_LENGTH = 0;

    private final char[][] board;
    private Figure figure;

    /**
     * Creates a new {@code BoardState} object with the given table which is never changing during the game.
     * Once instantiate {@code Figure} class using  parameterless constructor that contains the starting position.
     * Table representation 3 colors: 'b' => blue, 'w' => white, 'r' => red.
     * The table target state value is 'c'
     */
    public BoardState(){
        board = new char[][] {
                {'b', 'w', 'w', 'w', 'r', 'w', 'c'},
                {'b', 'w', 'b', 'w', 'w', 'b', 'w'},
                {'w', 'r', 'b', 'r', 'w', 'w', 'w'},
                {'b', 'b', 'b', 'w', 'b', 'w', 'w'},
                {'r', 'r', 'w', 'r', 'r', 'w', 'w'},
                {'w', 'w', 'b', 'r', 'w', 'w', 'r'},
                {'w', 'w', 'r', 'r', 'w', 'w', 'w'}
        };
        figure = new Figure();
    }

    /**
     * Use for making changes in the table of the {@code Figure}.
     * @param row Row of the boardgame's {@code Figure}
     * @param col Col of the boardgame's {@code Figure}
     * @param direction Direction of the boardgame's {@code Figure}
     * @return new {@code Figure} settings
     */
    public BoardState setFigure(int row, int col, Direction direction) {
        if (row < BOARD_SIZE_MIN_LENGTH || row > BOARD_SIZE_MAX_LENGTH || col < BOARD_SIZE_MIN_LENGTH || col > BOARD_SIZE_MAX_LENGTH) {
            throw new IllegalArgumentException("Invalid setting Figure Coordinates.");
        }
        this.figure = new Figure(row, col, direction);
        return this;
    }

    /**
     * @return true value if the {@code Figure}coordinates are in the goal state
     */
    @Override
    public boolean isSolved() {
        return board[figure.getRow()][figure.getCol()] == 'c';
    }

    /**
     * Examines that given move is exportable with the direction of travel,
     * color in given position and in the given move.
     * @param move value can be: 0-up, 1-right, 2-down, 3-left.
     * @return Returns true if the given move can be a legal move.
     */
    @Override
    public boolean isLegalMove(Integer move) {
        if (move < 0 || move > 3) {
            throw new IllegalArgumentException("Invalid move value. Expected a value between 0 and 3.");
        }

        boolean isLegal = false;
        int newRow = figure.getRow();
        int newCol = figure.getCol();
        char color = board[figure.getRow()][figure.getCol()];

        //If the Figure on the WHITE field, only way to go FORWARD in the same direction of travel
        if (color == 'w'){
            if (figure.getDirection().getValue() == move){
                isLegal = true;
            }
        }
        //If the Figure on the RED field are two way to go FORWARD in the same direction of travel or to the RIGHT in the same direction of travel
        else if (color == 'r'){
            if (figure.getDirection().getValue() == move){
                isLegal = true;
            } else if ((figure.getDirection().getValue()+1) % 4 == move) {
                isLegal = true;
            }
        }
        //If the Figure on the BLUE field are two way to go FORWARD in the same direction of travel or to the LEFT in the same direction of travel
        else if (color == 'b'){
            if (figure.getDirection().getValue() == move){
                isLegal = true;
            } else if ((figure.getDirection().getValue()-1 + 4) % 4 == move) {
                isLegal = true;
            }
        }

        switch (move) {
            case 0 -> newRow--; //Move up
            case 1 -> newCol++; //Move right
            case 2 -> newRow++; //Move down
            case 3 -> newCol--; //Move left
        }
        if (newRow < BOARD_SIZE_MIN_LENGTH || newRow >= BOARD_SIZE_MAX_LENGTH || newCol < BOARD_SIZE_MIN_LENGTH || newCol >= BOARD_SIZE_MAX_LENGTH) {
            isLegal = false;
        }
        return isLegal;
    }

    /**
     * Make the move and refresh the actual position of the {@code Figure}.
     * @param move expects a value of 0-up, 1-right, 2-down, 3-left
     */
    @Override
    public void makeMove(Integer move) {
        switch(move) {
            case 0 -> {
                figure.setRow(figure.getRow() -1 ); // Move up
                figure.setDirection(Direction.UP);
            }
            case 1 -> {
                figure.setCol(figure.getCol() +1 ); // Move right
                figure.setDirection(Direction.RIGHT);
            }
            case 2 -> {
                figure.setRow(figure.getRow() +1 ); // Move down
                figure.setDirection(Direction.DOWN);
            }
            case 3 -> {
                figure.setCol(figure.getCol() -1 ); // Move left
                figure.setDirection(Direction.LEFT);
            }
        }
    }

    /**
     * @return Returns all legal moves of {@code Figure}'s actual position.
     */
    @Override
    public Set<Integer> getLegalMoves() {
        Set<Integer> legalMoves = new HashSet<>();
        for (int i = 0; i<4; i++){
            if (isLegalMove(i)){
                legalMoves.add(i);
            }
        }
        return legalMoves;
    }

    /**
     * Creates a copy of the table and {@code Figure}.
     * @return The created copy of the model.
     */
    @Override
    public State<Integer> clone() {
            final BoardState copy;
            try {
                copy = (BoardState) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
            copy.figure = new Figure();
            copy.figure.setRow(this.figure.getRow());
            copy.figure.setCol(this.figure.getCol());
            copy.figure.setDirection(this.figure.getDirection());
            return copy;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        else if (o == null || getClass() != o.getClass())
            return false;
        BoardState that = (BoardState) o;
        if (this.figure.getRow() != that.figure.getRow() || this.figure.getCol() != that.figure.getCol() || this.figure.getDirection() != that.figure.getDirection()){
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
            int result = 0;
            result = result + this.figure.getRow();
            result = result + this.figure.getCol();
            result = result + this.figure.getDirection().hashCode();

        return result;
    }
    @Override
    public String toString() {
        return "Figure: x: " + figure.getRow() + " y: " + figure.getCol();
    }
}
