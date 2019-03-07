package bowlingkata;

public class Frame {
    public final int firstRoll;
    public final int secondRoll;

    public Frame(int firstRoll, int secondRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

    boolean isSpare() {
        return firstRoll + secondRoll == 10;
    }
}
