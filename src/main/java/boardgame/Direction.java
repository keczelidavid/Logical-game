package boardgame;
import lombok.Getter;

/**
 * Represents the four direction.
 */
@Getter
public enum Direction {
    /**
     * Up direction and it's value.
     */
    UP (0),
    /**
     * Right direction and it's value.
     */
    RIGHT (1),
    /**
     * down direction and it's value.
     */
    DOWN (2),
    /**
     * left direction and it's value
     */
    LEFT (3);

    /**
     * Stores the numeric value of the corresponding direction: up(0), right(1), down(2), left(3)
     */
    public final int value;

    /**
     * Creates {@code Direction} enum with the given direction.
     * @param i Value of represent direction
     */
    Direction(int i) {
        if (i < 0 || i > 3) {
            throw new IllegalArgumentException("Invalid direction value. Expected a value between 0 and 3.");
        }else{
            this.value = i;
        }
    }

}
