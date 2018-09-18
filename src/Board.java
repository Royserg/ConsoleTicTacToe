import java.util.ArrayList;

public class Board {
    private char[] fields = new char[] {' ', 'X', 'O', ' ', ' ', ' ', ' ', ' ', ' ' };

    void drawBoard() {
        System.out.println();
        System.out.printf(" %c # %c # %c\n", fields[0], fields[1], fields[2]);
        System.out.println(" #########");
        System.out.printf(" %c # %c # %c\n", fields[3], fields[4], fields[5]);
        System.out.println(" #########");
        System.out.printf(" %c # %c # %c\n", fields[6], fields[7], fields[8]);
        System.out.println();
        System.out.println("============");
    }

    void markSpot(int index, char marker) {
        // mark field
        fields[index - 1] = marker;
    }

    String checkWinner() {
       // do the checking
        int empty = 0;
        for (char field : fields) {
            if (field == ' ') {
                empty++;
            }
        }

        if (empty == 0) return "Tie";

        return "none";
    }
}
