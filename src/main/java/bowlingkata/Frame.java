package bowlingkata;

public class Frame {
    private Roll firstRoll;
    private Roll secondRoll;

    public Frame() {

    }

    boolean isSpare() {
        return firstRoll.score + secondRoll.score == 10;
    }

    public FrameState state() {
        return firstRoll != null && secondRoll != null ? FrameState.FINISHED : FrameState.IN_PLAY;
    }


    public int secondRollScore() {
        return secondRoll == null ? 0 : secondRoll.score;
    }

    public void add(Roll roll) {
        if (firstRoll == null) {
            firstRoll = roll;
            return;
        }

        if(secondRoll == null) {
            secondRoll = roll;
            return;
        }

    }
}
