package bowlingkata;

public class BonusCalculator {
    private final Frames frames;
    private final StrikeBonusCalculator strikeBonusCalculator;
    private final SpareBonusCalculator spareBonusCalculator;

    public BonusCalculator(Frames frames) {
        this.frames = frames;
        strikeBonusCalculator = new StrikeBonusCalculator(this.frames);
        spareBonusCalculator = new SpareBonusCalculator(this.frames);
    }

    void applyBonus(Roll roll) {
        frames.previousFrame().ifPresent(frame -> {
            strikeBonusCalculator.applyStrikeBonus(roll, frame);
            spareBonusCalculator.applySpareBonus(roll, frame);
        });
    }
}