package bowlingkata;

class Game {
    final Frames frames = new Frames();

    public Game() {
    }

    public int score() {
        return frames.score();
    }

    public void roll(int rollScore) {

        if (frames.getFrame(1).state() == FrameState.FINISHED) {
            frames.addFrame();
        }

        Roll roll = new Roll(rollScore);
        frames.addRollToCurrentFrame(roll);

        if (frames.size() > 1) {
            Frame previousFrame = frames.previousFrame();

            if (previousFrame.isSpare() || previousFrame.isStrike()) {
                previousFrame.addBonus(roll);
            }
        }
    }

}
