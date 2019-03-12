package bowlingkata;

public class BonusCalculator {
    private final Frames frames;
    private final StrikeBonusCalculator strikeBonusCalculator;

    public BonusCalculator(Frames frames) {
        this.frames = frames;
        strikeBonusCalculator = new StrikeBonusCalculator(this.frames);
    }

    void applyBonus(Roll roll) {
        frames.previousFrame().ifPresent(frame -> {
            strikeBonusCalculator.applyStrikeBonus(roll, frame);
            applySpareBonus(roll, frame);
        });
    }

    void applySpareBonus(Roll roll, Frame previousFrame) {
        if (previousFrame.isSpare() && frames.isInPlay()) {
            previousFrame.addBonus(roll);
        }
    }
}