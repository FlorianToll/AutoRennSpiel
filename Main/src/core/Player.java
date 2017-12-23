package core;

import db.DBPlayerContainer;
import evt.PlayerLeaveReason;

import java.util.UUID;

public class Player {
    private final UUID PUUID = UUID.randomUUID();
    private World world = null;
    private long millisIdle = 0;
    DBPlayerContainer playerContainer =  DBPlayerContainer.getInstance();

    public Player() {
        playerContainer.setID(PUUID);
    }

    public Player(World w) {
        world = w;
        world.addPlayer(this);
    }

    public void join(World w) {
        if (world != null) {
            world.kickPlayer(this, PlayerLeaveReason.KICKED_BY_CONSOLE);
        }
        world = w;
        w.addPlayer(this);
    }

    public void leaveWorld() {
        if (world != null) {
            world.kickPlayer(this, PlayerLeaveReason.DISCONNECTED);
        }
        world = null;
    }

    public UUID getUUID() {
        return PUUID;
    }

    public long getMillisIdle() {
        return millisIdle;
    }

    public void idlePlus(long what) {
        millisIdle += what;
    }
}