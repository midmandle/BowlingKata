package bowlingkata;

class Game {
    final Frames frames = new Frames();

    public int score() {
        return frames.score();
    }

    public void roll(int rollScore) {

        if (isFinished()) {
            frames.addFrame();
        }

        Roll roll = new Roll(rollScore);
        frames.addRollToCurrentFrame(roll);
        applyBonus(roll);
    }

    private boolean isFinished() {
        return frames.state() == FrameState.FINISHED;
    }

    private void applyBonus(Roll roll) {
        frames.previousFrame().ifPresent(frame -> {
            applyStrikeBonus(roll, frame);
            applySpareBonus(roll, frame);
        });
    }

    private void applySpareBonus(Roll roll, Frame previousFrame) {
        if (previousFrame.isSpare() && isInPlay()) {
            previousFrame.addBonus(roll);
        }
    }

    private boolean isInPlay() {
        return frames.state() == FrameState.IN_PLAY;
    }

    private void applyStrikeBonus(Roll roll, Frame previousFrame) {
        applyStrike(roll, previousFrame);
        applyStrikeBonusForSecondToLastFrame(roll);

    }

    private void applyStrikeBonusForSecondToLastFrame(Roll roll) {
        frames.secondToLast().ifPresent(frame -> {
            applyStrikeToInPlay(roll, frame);
        });
    }

    private void applyStrikeToInPlay(Roll roll, Frame frame) {
        if(isInPlay() || strikeInCurrentRoll())
            applyStrike(roll, frame);
    }

    private boolean strikeInCurrentRoll() {
        return frames.currentFrame().isStrike();
    }

    private void applyStrike(Roll roll, Frame frame) {
        if (frame.isStrike())
            frame.addBonus(roll);
    }

}
