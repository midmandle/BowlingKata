package bowlingkata;

class Game {
    final Frames frames = new Frames();

    public Game() {
    }

    public int score() {
        return frames.score();
    }

    public void roll(int rollScore) {

        if (frames.state() == FrameState.FINISHED) {
            frames.addFrame();
        }

        Roll roll = new Roll(rollScore);
        frames.addRollToCurrentFrame(roll);

        if (frames.size() > 1) {
            Frame previousFrame = frames.previousFrame();

            if (previousFrame.isStrike()) {
                previousFrame.addBonus(roll);
            }

            if (previousFrame.isSpare() && frames.state() == FrameState.IN_PLAY) {
                previousFrame.addBonus(roll);
            }
        }
    }

}
