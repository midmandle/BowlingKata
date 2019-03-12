package bowlingkata;

public class StrikeBonusCalculator implements BonusCalculator {
    private Frames frames;

    public StrikeBonusCalculator(Frames frames) {
        this.frames = frames;
    }

    @Override
    public void applyBonus(Roll roll, Frame previousFrame) {
        applyBonusForPreviousFrame(roll, previousFrame);
        applyBonusForSecondToLastFrame(roll);

    }

    void applyBonusForSecondToLastFrame(Roll roll) {
        frames.secondToLast().ifPresent(frame -> {
            applyStrikeToInPlay(roll, frame);
        });
    }

    void applyStrikeToInPlay(Roll roll, Frame frame) {
        if (frames.isInPlay() || strikeInCurrentRoll())
            applyBonusForPreviousFrame(roll, frame);
    }

    boolean strikeInCurrentRoll() {
        return frames.currentFrame().isStrike();
    }

    void applyBonusForPreviousFrame(Roll roll, Frame frame) {
        if (frame.isStrike())
            frame.addBonus(roll);
    }
}