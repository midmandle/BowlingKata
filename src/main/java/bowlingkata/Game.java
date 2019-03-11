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
        frames.getFrame(1).add(roll);

        if (frames.size() > 1) {
            if (frames.getFrame(2).isSpare()) {
                frames.getFrame(2).addBonus(roll);
            }
        }
    }

}
