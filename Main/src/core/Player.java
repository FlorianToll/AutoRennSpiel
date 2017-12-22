package core;

import java.util.UUID;

public class Player {
    private static final UUID PUUID = UUID.randomUUID();
    private World world;

    public Player() {

    }

    public void join(World w) {
        world = w;
        w.addPlayer(this);
    }

    public UUID getUUID() {
        return PUUID;
    }
}