package bowlingkata;

public class Frame {
    private Roll firstRoll;
    private Roll secondRoll;

    public Frame() {

    }

    boolean isSpare() {
        if(firstRoll != null && secondRoll != null)
            return firstRoll.score + secondRoll.score == 10;
        return false;
    }

    public FrameState state() {
        if(this.isStrike())
            return FrameState.FINISHED;
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

    public void addBonus(Roll roll) {
        secondRoll = new Roll(roll.score + secondRoll.score);
    }

    public int score() {
        int firstScore = firstRoll == null ? 0 : firstRoll.score;
        int secondScore = secondRoll == null ? 0 : secondRoll.score;
        return firstScore + secondScore;
    }

    public boolean isStrike() {
        if (firstRoll != null)
            return firstRoll.score == 10;

        return false;
    }
}
