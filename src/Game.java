import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        System.out.println(">>> Tic Tac Toe <<<");

        /* get players names */
        String name1 = userInput("Player 1 name: ");
        String name2 = userInput("Player 2 name: ");

        /* create Player objects */
        Player player1 = new Player(name1);
        Player player2 = new Player(name2);

        System.out.println(player1.getName());
        System.out.println(player2.getName());

    }

    private static String userInput(String prompt) {
        System.out.print(prompt);
        /* == initialize scanner == */
        Scanner kbd = new Scanner(System.in);

        return kbd.nextLine();
    }
}
