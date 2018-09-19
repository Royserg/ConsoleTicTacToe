
public class Board {
    public char[] fields = new char[] {' ', 'X', 'O', ' ', ' ', ' ', ' ', ' ', ' ' };
    public int[][] winOptions = {
                                    {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                                    {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                                    {0, 4, 8}, {2, 4, 6}
                                };

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

    char checkWinner() {

        // check if any player won
        for (int[] winSequence: winOptions) {
            char firstSymbol = fields[winSequence[0]];

            for (int j = 1; j < winSequence.length; j++)
                if (firstSymbol != fields[winSequence[j]] || firstSymbol == ' ') {
                    // other field(s) are different
                    firstSymbol = 'q';
                }

            if (firstSymbol != 'q') {
                return firstSymbol;
            }
        }

        return 'q';
    }
}

