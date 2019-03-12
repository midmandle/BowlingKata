package bowlingkata;

public class SpareBonusCalculator {

    private final Frames frames;

    public SpareBonusCalculator(Frames frames) {
        this.frames = frames;
    }

    void applySpareBonus(Roll roll, Frame previousFrame) {
        if (previousFrame.isSpare() && frames.isInPlay()) {
            previousFrame.addBonus(roll);
        }
    }
}