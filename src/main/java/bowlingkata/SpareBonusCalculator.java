package bowlingkata;

public class SpareBonusCalculator implements BonusCalculator {

    private final Frames frames;

    public SpareBonusCalculator(Frames frames) {
        this.frames = frames;
    }

    @Override
    public void applyBonus(Roll roll, Frame previousFrame) {
        if (previousFrame.isSpare() && frames.isInPlay()) {
            previousFrame.addBonus(roll);
        }
    }
}