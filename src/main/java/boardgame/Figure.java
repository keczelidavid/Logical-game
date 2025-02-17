package boardgame;

import lombok.Getter;

/**
 * It is necessary to create the {@code Figure} class to store the current position and direction of the {@code Figure}.
 * There is a composition relationship between the {@code BoardState} class and the {@code Figure} class.
 * The {@code BoardState} class is able to modify the attributes of the {@code Figure} instance because it's a composition between them.
 */
@Getter
public class Figure {

    private int row;

    private int col;

    private Direction direction;

    /**
     * Parameterized constructor for the {@code Figure} class.
     * @param row Line of the current state
     * @param col Column of the current state
     * @param direction Direction of movement from the previous to the next state
     */
    public Figure(int row, int col, Direction direction) {
        this.row = row;
        this.col = col;
        this.direction = direction;
    }

    /**
     * A parameterless constructor that places the {@code Figure} in the initial state, allowing it to move.
     * Default state: bottom-left corner and facing upwards.
     */

    public Figure (){
        this.row = 6;
        this.col = 0;
        this.direction = Direction.UP;
    }

    /**
     *Setting row.
     * @param row Set of the actual {@code Figure} row coordinate.
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     *Setting col.
     * @param col Set of the actual {@code Figure} col coordinate.
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     *Setting direction
     * @param direction Sets of the actual {@code Figure} direction.
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
