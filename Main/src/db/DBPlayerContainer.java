package db;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

public class DBPlayerContainer {


    private static DBPlayerContainer playerContainer;

    public int win;
    public int fails;
    public int gamesPlayed;
    public UUID id;
    public Duration playTime;
    public Instant lastTimeSeen;



    public DBPlayerContainer() {

    }



    public void setFails(int x) {
        this.fails += x;
    }

    public int getFails() {
        return fails;
    }

    public void setGamesPlayed(int x) {
        this.gamesPlayed += x;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setWin(int x) {
        this.win += x;
    }

    public int getWin() {
        return win;
    }

    public void setLastTimeSeen(Instant lastTimeSeen) {
        this.lastTimeSeen = lastTimeSeen;
    }

    public Instant getLastTimeSeen() {
        return lastTimeSeen;
    }

    public void setPlayTime(Duration x) {
        this.playTime.plus(x);
    }

    public Duration getPlayTime() {
        return playTime;
    }

    public void setID(UUID x) {
        this.id = x;
    }

    public UUID getId() {
        return id;
    }


    public static DBPlayerContainer getInstance() {
        if(playerContainer == null) {
            playerContainer = new DBPlayerContainer();
        }
        return playerContainer;
    }
}
