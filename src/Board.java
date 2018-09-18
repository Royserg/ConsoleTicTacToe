import java.util.ArrayList;

public class Board {
    private char[] fields = new char[] {' ', 'X', 'O', ' ', ' ', ' ', ' ', ' ', ' ' };

    void drawBoard() {
        System.out.printf(" %c # %c # %c\n", fields[0], fields[1], fields[2]);
        System.out.println(" #########");
        System.out.printf(" %c # %c # %c\n", fields[3], fields[4], fields[5]);
        System.out.println(" #########");
        System.out.printf(" %c # %c # %c\n", fields[6], fields[7], fields[8]);
        System.out.println();
        System.out.println("============");
    }


}
