package bowlingkata;

public class Frame {
    final Roll firstRoll;
    final Roll secondRoll;
    private FrameState frameState = FrameState.IN_PLAY;

    public Frame(int firstRoll, int secondRoll) {
        this.firstRoll = new Roll(firstRoll);
        this.secondRoll = new Roll(secondRoll);
    }

    public Frame(Roll firstRoll, Roll secondRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

    boolean isSpare() {
        return firstRoll.score + secondRoll.score == 10;
    }

    public FrameState state() {
        return frameState;
    }
}
