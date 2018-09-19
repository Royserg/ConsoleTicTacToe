class Player {

    private String name;
    private char marker;
    private int score;

    Player(String name, char marker) {
        this.name = name;
        this.marker = marker;
        this.score = 0;
    }

    String getName() {
        return name;
    }

    char getMarker() {
        return marker;
    }

    int getScore() {
        return score;
    }

    void increaseScore() {
        score += 1;
    }

}
