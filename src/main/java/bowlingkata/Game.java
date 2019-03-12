package bowlingkata;

class Game {
    final Frames frames = new Frames();
    private final BonusCalculator strikeBonusCalculator = new StrikeBonusCalculator(frames);
    private final BonusCalculator spareBonusCalculator = new SpareBonusCalculator(frames);

    public int score() {
        return frames.score();
    }

    public void roll(int rollScore) {

        if (isFinished()) {
            frames.addFrame();
        }

        Roll roll = new Roll(rollScore);
        frames.addRollToCurrentFrame(roll);

        frames.applyBonus(previousFrame -> {
            strikeBonusCalculator.applyBonus(roll, previousFrame);
            spareBonusCalculator.applyBonus(roll, previousFrame);
        });
    }

    private boolean isFinished() {
        return frames.state() == FrameState.FINISHED;
    }
}
