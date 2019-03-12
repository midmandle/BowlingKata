package bowlingkata;

public class BonusCalculator {
    private final Frames frames;

    public BonusCalculator(Frames frames) {
        this.frames = frames;
    }

    void applyBonus(Roll roll) {
        frames.previousFrame().ifPresent(frame -> {
            applyStrikeBonus(roll, frame);
            applySpareBonus(roll, frame);
        });
    }

    void applySpareBonus(Roll roll, Frame previousFrame) {
        if (previousFrame.isSpare() && isInPlay()) {
            previousFrame.addBonus(roll);
        }
    }

    boolean isInPlay() {
        return frames.state() == FrameState.IN_PLAY;
    }

    void applyStrikeBonus(Roll roll, Frame previousFrame) {
        applyStrike(roll, previousFrame);
        applyStrikeBonusForSecondToLastFrame(roll);

    }

    void applyStrikeBonusForSecondToLastFrame(Roll roll) {
        frames.secondToLast().ifPresent(frame -> {
            applyStrikeToInPlay(roll, frame);
        });
    }

    void applyStrikeToInPlay(Roll roll, Frame frame) {
        if (isInPlay() || strikeInCurrentRoll())
            applyStrike(roll, frame);
    }

    boolean strikeInCurrentRoll() {
        return frames.currentFrame().isStrike();
    }

    void applyStrike(Roll roll, Frame frame) {
        if (frame.isStrike())
            frame.addBonus(roll);
    }
}