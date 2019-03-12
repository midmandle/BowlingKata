package bowlingkata;

public class StrikeBonusCalculator {
    private Frames frames;

    public StrikeBonusCalculator(Frames frames) {
        this.frames = frames;
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
        if (frames.isInPlay() || strikeInCurrentRoll())
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