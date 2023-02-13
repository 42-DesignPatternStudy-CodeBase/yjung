package state;

public class Player {
    PlayerLevel curLevel;

    public Player() {
        this.curLevel = new BeginnerLevel();
    }

    public PlayerLevel getLevel() {
        return this.curLevel;
    }

    public void setLevel(PlayerLevel level) {
        this.curLevel = level;
    }
    public void play(int time) {
        this.getLevel().run();
        for(int i =0; i<time; i++) {
            this.getLevel().jump();
        }
        this.getLevel().turn();
    }
    public void upgradeLevel(PlayerLevel level) {
        setLevel(level);
        this.getLevel().showLevelMessage();
    }
}
