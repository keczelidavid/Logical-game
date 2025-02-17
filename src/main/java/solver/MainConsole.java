package solver;
import boardgame.BoardState;
import java.util.Scanner;

/**
 * Play the game from the console.
 */
public class MainConsole {

    public static void main(String[] args) {

        BoardState GameByConsole = new BoardState();
        Scanner scanner = new Scanner(System.in);

        while (!GameByConsole.isSolved()){
            System.out.println("Choose a number of moves: 0-up, 1-right, 2-down, 3-left ");
            int move = scanner.nextInt();
            if(GameByConsole.isLegalMove(move)){
                GameByConsole.makeMove(move);
                System.out.println("Move is accepted");
            }
            else {
                System.out.println("Unaccepted move, try again: ");
            }
        }
        System.out.println("You Win!");
    }
}