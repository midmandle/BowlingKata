package bowlingkata;

class Game {
    final Frames frames = new Frames();

    public Game() {
    }

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
        if (frames.size() > 1) {
            Frame previousFrame = frames.previousFrame();
            applyStrikeBonus(roll, previousFrame);
            applySpareBonus(roll, previousFrame);
        }
    }

    private void applySpareBonus(Roll roll, Frame previousFrame) {
        applyStrike(roll, previousFrame, previousFrame.isSpare() && isInPlay());
    }

    private boolean isInPlay() {
        return frames.state() == FrameState.IN_PLAY;
    }

    private void applyStrikeBonus(Roll roll, Frame previousFrame) {
        applyStrike(roll, previousFrame, previousFrame.isStrike());
        applyStrikeBonusForSecondToLastFrame(roll);

    }

    private void applyStrikeBonusForSecondToLastFrame(Roll roll) {
        if(frames.size() > 2 && isInPlay()) {
            Frame secondToLastFrame = frames.secondToLast();
            applyStrike(roll, secondToLastFrame, secondToLastFrame.isStrike());
        }
    }

    private void applyStrike(Roll roll, Frame frame, boolean strike) {
        if (strike)
            frame.addBonus(roll);
    }

}
