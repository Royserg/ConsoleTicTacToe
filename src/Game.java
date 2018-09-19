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

        startGame(player1, player2);

        // show result
        System.out.println("==== Score ======");
        System.out.println(player1.getName() + "'s score: " + player1.getScore());

        System.out.println(player2.getName() + "'s score: " + player2.getScore());
        System.out.println("=================");

        System.out.println("Goodbye");
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

    private static void playerMove() {
        System.out.print(playing.getName() + " [" + playing.getMarker() + "], ");

        // ask user input
        Scanner kbd = new Scanner(System.in);
        // validate provided spot
        int spot;

        do {
            System.out.print("make your move (1-9): ");
            while(!kbd.hasNextInt()) {
                System.out.print("Provide a number: ");
                kbd.next();
            }
            spot = kbd.nextInt();
        } while (spot < 1 || spot > 9 || board.fields[spot - 1] != ' ');

        // mark the spot on board
        board.markSpot(spot, playing.getMarker());
    }

    private static void startGame(Player player1, Player player2) {
        while (isRunning) {
            // info
            showRound();
            // show board
            board.drawBoard();

            // player moves
            playerMove();

            // == check winner after move ==
            char winCheck = board.checkWinner();

            if (winCheck != 'q') {
                board.drawBoard();
                isRunning = false;

                if (winCheck == player1.getMarker()) {
                    System.out.println(player1.getName() + " Won!!!");
                    player1.increaseScore();
                } else if (winCheck == player2.getMarker()){
                    System.out.println(player2.getName() + " Won!!");
                    player2.increaseScore();
                } else if (winCheck == 'f') {
                    System.out.println("It is a Tie");
                }

                // ask if want to play again
                String playAgain = userInput("Do you want to play again? Y/n: ");
                if (playAgain.equals("n")) {
                    break;
                }
                else {
                    // change Round number
                    roundNum++;
                    // clear the board
                    board.clearBoard();
                    playing = (playing == player1) ? player2 : player1;
                    isRunning = true;
                    startGame(player1, player2);
                }
            }

            // change player
            playing = (playing == player1) ? player2 : player1;
        }
    }

}
