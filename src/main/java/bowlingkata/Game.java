package bowlingkata;

class Game {
    final Frames frames = new Frames();
    private final BonusCalculator bonusCalculator = new BonusCalculator(frames);

    public int score() {
        return frames.score();
    }

    public void roll(int rollScore) {

        if (isFinished()) {
            frames.addFrame();
        }

        Roll roll = new Roll(rollScore);
        frames.addRollToCurrentFrame(roll);
        bonusCalculator.applyBonus(roll);
    }

    private boolean isFinished() {
        return frames.state() == FrameState.FINISHED;
    }

}
