package boardgame;
import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class BoardStateTest {
    BoardState stateWhite1 = new BoardState(); // the original initial state
    BoardState stateWhite2 = new BoardState().setFigure(0,6,Direction.UP); // a goal state
    BoardState stateWhite3 = new BoardState().setFigure(1,1,Direction.LEFT); // a non-goal state
    BoardState stateWhite4 = new BoardState().setFigure(6,6,Direction.DOWN); // a dead-end state with no legal moves
    BoardState stateRed1 = new BoardState().setFigure(0,4,Direction.UP); // a non-goal state
    BoardState stateRed2 = new BoardState().setFigure(0,4,Direction.RIGHT); // a non-goal state
    BoardState stateRed3 = new BoardState().setFigure(0,4,Direction.DOWN); // a non-goal state
    BoardState stateRed4 = new BoardState().setFigure(0,4,Direction.LEFT); // a non-goal state
    BoardState stateBlue1 = new BoardState().setFigure(0,0,Direction.UP); // a non-goal state
    BoardState stateBlue2 = new BoardState().setFigure(0,0,Direction.RIGHT); // a non-goal state
    BoardState stateBlue3 = new BoardState().setFigure(0,0,Direction.DOWN); // a non-goal state
    BoardState stateBlue4 = new BoardState().setFigure(0,0,Direction.LEFT); // a non-goal state

    @Test
    void isLegalMove_shouldThrowIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> stateWhite1.isLegalMove(-1));
        assertThrows(IllegalArgumentException.class, () -> stateWhite1.isLegalMove(100));
    }
    @Test
    void isSolved() {
        assertFalse(stateWhite1.isSolved());
        assertTrue(stateWhite2.isSolved());
        assertFalse(stateWhite3.isSolved());
        assertFalse(stateWhite4.isSolved());
        assertFalse(stateWhite4.isSolved());
        assertFalse(stateRed1.isSolved());
        assertFalse(stateBlue1.isSolved());
    }
    @Test
    void isLegalMove_state1() {
        assertTrue(stateWhite1.isLegalMove(Direction.UP.value));
        assertFalse(stateWhite1.isLegalMove(Direction.RIGHT.value));
        assertFalse(stateWhite1.isLegalMove(Direction.DOWN.value));
        assertFalse(stateWhite1.isLegalMove(Direction.LEFT.value));

        assertFalse(stateRed1.isLegalMove(Direction.UP.value));
        assertTrue(stateRed1.isLegalMove(Direction.RIGHT.value));
        assertFalse(stateRed1.isLegalMove(Direction.DOWN.value));
        assertFalse(stateRed1.isLegalMove(Direction.LEFT.value));

        assertFalse(stateBlue1.isLegalMove(Direction.UP.value));
        assertFalse(stateBlue1.isLegalMove(Direction.RIGHT.value));
        assertFalse(stateBlue1.isLegalMove(Direction.DOWN.value));
        assertFalse(stateBlue1.isLegalMove(Direction.LEFT.value));
    }
    @Test
    void isLegalMove_state2() {
        assertFalse(stateWhite2.isLegalMove(Direction.UP.value));
        assertFalse(stateWhite2.isLegalMove(Direction.RIGHT.value));
        assertFalse(stateWhite2.isLegalMove(Direction.DOWN.value));
        assertFalse(stateWhite2.isLegalMove(Direction.LEFT.value));

        assertFalse(stateRed2.isLegalMove(Direction.UP.value));
        assertTrue(stateRed2.isLegalMove(Direction.RIGHT.value));
        assertTrue(stateRed2.isLegalMove(Direction.DOWN.value));
        assertFalse(stateRed2.isLegalMove(Direction.LEFT.value));

        assertFalse(stateBlue2.isLegalMove(Direction.UP.value));
        assertTrue(stateBlue2.isLegalMove(Direction.RIGHT.value));
        assertFalse(stateBlue2.isLegalMove(Direction.DOWN.value));
        assertFalse(stateBlue2.isLegalMove(Direction.LEFT.value));
    }
    @Test
    void isLegalMove_state3() {
        assertFalse(stateWhite3.isLegalMove(Direction.UP.value));
        assertFalse(stateWhite3.isLegalMove(Direction.RIGHT.value));
        assertFalse(stateWhite3.isLegalMove(Direction.DOWN.value));
        assertTrue(stateWhite3.isLegalMove(Direction.LEFT.value));

        assertFalse(stateRed3.isLegalMove(Direction.UP.value));
        assertFalse(stateRed3.isLegalMove(Direction.RIGHT.value));
        assertTrue(stateRed3.isLegalMove(Direction.DOWN.value));
        assertTrue(stateRed3.isLegalMove(Direction.LEFT.value));

        assertFalse(stateBlue3.isLegalMove(Direction.UP.value));
        assertTrue(stateBlue3.isLegalMove(Direction.RIGHT.value));
        assertTrue(stateBlue3.isLegalMove(Direction.DOWN.value));
        assertFalse(stateBlue3.isLegalMove(Direction.LEFT.value));
    }
    @Test
    void isLegalMove_state4() {
        assertFalse(stateWhite4.isLegalMove(Direction.UP.value));
        assertFalse(stateWhite4.isLegalMove(Direction.RIGHT.value));
        assertFalse(stateWhite4.isLegalMove(Direction.DOWN.value));
        assertFalse(stateWhite4.isLegalMove(Direction.LEFT.value));

        assertFalse(stateRed4.isLegalMove(Direction.UP.value));
        assertFalse(stateRed4.isLegalMove(Direction.RIGHT.value));
        assertFalse(stateRed4.isLegalMove(Direction.DOWN.value));
        assertTrue(stateRed4.isLegalMove(Direction.LEFT.value));

        assertFalse(stateBlue4.isLegalMove(Direction.UP.value));
        assertFalse(stateBlue4.isLegalMove(Direction.RIGHT.value));
        assertTrue(stateBlue4.isLegalMove(Direction.DOWN.value));
        assertFalse(stateBlue4.isLegalMove(Direction.LEFT.value));
    }
    @Test
    void getLegalMovesTest() {
        //stateWhite
        Set<Integer> expectedMovesState1 = Set.of(Direction.UP.value);
        assertEquals(expectedMovesState1, stateWhite1.getLegalMoves());

        Set<Integer> expectedMovesState2 = Set.of();
        assertEquals(expectedMovesState2, stateWhite2.getLegalMoves());

        Set<Integer> expectedMovesState3 = Set.of(Direction.LEFT.value);
        assertEquals(expectedMovesState3, stateWhite3.getLegalMoves());

        Set<Integer> expectedMovesState4 = Set.of();
        assertEquals(expectedMovesState4, stateWhite4.getLegalMoves());

        //stateRed
        Set<Integer> expectedMovesState5 = Set.of(Direction.RIGHT.value);
        assertEquals(expectedMovesState5, stateRed1.getLegalMoves());

        Set<Integer> expectedMovesState6 = Set.of(Direction.RIGHT.value, Direction.DOWN.value);
        assertEquals(expectedMovesState6, stateRed2.getLegalMoves());

        Set<Integer> expectedMovesState7 = Set.of(Direction.DOWN.value, Direction.LEFT.value);
        assertEquals(expectedMovesState7, stateRed3.getLegalMoves());

        Set<Integer> expectedMovesState8 = Set.of(Direction.LEFT.value);
        assertEquals(expectedMovesState8, stateRed4.getLegalMoves());

        //stateBlue
        Set<Integer> expectedMovesState9 = Set.of();
        assertEquals(expectedMovesState9, stateBlue1.getLegalMoves());

        Set<Integer> expectedMovesState10 = Set.of(Direction.RIGHT.value);
        assertEquals(expectedMovesState10, stateBlue2.getLegalMoves());

        Set<Integer> expectedMovesState11 = Set.of(Direction.DOWN.value, Direction.RIGHT.value);
        assertEquals(expectedMovesState11, stateBlue3.getLegalMoves());

        Set<Integer> expectedMovesState12 = Set.of(Direction.DOWN.value);
        assertEquals(expectedMovesState12, stateBlue4.getLegalMoves());
    }
    @Test
    void testEquals() {
        assertTrue(stateWhite1.equals(stateWhite1));

        var clone = stateWhite1.clone();
        clone.makeMove(Direction.RIGHT.value);
        assertFalse(clone.equals(stateWhite1));

        assertFalse(stateWhite1.equals(null));
        assertFalse(stateWhite1.equals("Hello, World!"));
        assertFalse(stateWhite1.equals(stateWhite2));
        assertFalse(stateWhite2.equals(stateWhite3));
    }
    @Test
    void testHashCode() {
        assertTrue(stateWhite1.hashCode() == stateWhite1.hashCode());
        assertTrue(stateWhite1.hashCode() == stateWhite1.clone().hashCode());
    }
    @Test
    void testClone() {
        var clone = stateWhite1.clone();
        assertTrue(clone.equals(stateWhite1));
        assertNotSame(clone, stateWhite1);
    }
    @Test
    void testToString() {
        assertEquals("Figure: x: 6 y: 0", stateWhite1.toString());
        assertEquals("Figure: x: 0 y: 6", stateWhite2.toString());
        assertEquals("Figure: x: 1 y: 1", stateWhite3.toString());
        assertEquals("Figure: x: 6 y: 6", stateWhite4.toString());
    }
}