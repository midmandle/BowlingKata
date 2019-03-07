package bowlingkata;

class Game {
    private int score;

    public Game() {
        this.score = 0;
    }

    int score() {
        return this.score;
    }


    public void roll(int rollScore) {
        this.score += rollScore;
    }
}
