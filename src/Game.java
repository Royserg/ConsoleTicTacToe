import java.util.Scanner;

public class Game {

    private static int roundNum = 1;
    private static Player playing;
    private static boolean isRunning;
    // initialize Board instance
    private static Board board = new Board();

    public static void main(String[] args) {
        System.out.println(">>> Tic Tac Toe <<<");

        /* get players names */
        String name1 = userInput("Player 1 name: ");
        String name2 = userInput("Player 2 name: ");

        /* create Player instances */
        Player player1 = new Player(name1, 'O');
        Player player2 = new Player(name2, 'X');

        /* === Starting Game === */
        isRunning = true;
        playing = player1;

        while (isRunning) {
            // info
            showRound();
            // show board
            board.drawBoard();
            // user moves
            System.out.print(playing.getName());
            int spot = Integer.parseInt(userInput(", make your move: "));

            playerMove(spot);

            // == end - check winner ==
            String winCheck = board.checkWinner();

            if (winCheck == "Tie") {
                isRunning = false;
                System.out.println("It is a Tie!!!");
                System.out.println("YOu wanna play again?");
                // some input awaiting magic TODO
            }

            // change player
            playing = (playing == player1) ? player2 : player1;
        }

        System.out.println("Shouldn't arrive here");

    }

    private static String userInput(String prompt) {
        System.out.print(prompt);
        /* == initialize scanner == */
        Scanner kbd = new Scanner(System.in);

        return kbd.nextLine();
    }

    private static void showRound() {
        System.out.println("============");
        System.out.println("= Round: " + roundNum + " =");
        System.out.println("============");
    }

    private static void playerMove(int spot) {
        // validate provided spot TODO

        // mark the board
        board.markSpot(spot, playing.getMarker());
    }

}
