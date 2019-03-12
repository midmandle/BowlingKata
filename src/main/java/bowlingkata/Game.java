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

        applyBonus(roll);
    }

    private void applyBonus(Roll roll) {
        if (frames.size() > 1) {
            Frame previousFrame = frames.previousFrame();

            applyStrikeBonus(roll, previousFrame);

            applySpareBonus(roll, previousFrame);
        }
    }

    private void applySpareBonus(Roll roll, Frame previousFrame) {
        if (previousFrame.isSpare() && frames.state() == FrameState.IN_PLAY) {
            previousFrame.addBonus(roll);
        }
    }

    private void applyStrikeBonus(Roll roll, Frame previousFrame) {
        if (previousFrame.isStrike()) {
            previousFrame.addBonus(roll);
        }

        if(frames.size() > 2 && frames.state() == FrameState.IN_PLAY) {
            Frame secondToLastFrame = frames.getFrame(3);
            if (secondToLastFrame.isStrike())
                secondToLastFrame.addBonus(roll);
        }

    }

}
