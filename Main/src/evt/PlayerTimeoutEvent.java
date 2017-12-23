package evt;

import core.Player;

import java.time.Instant;

public class PlayerTimeoutEvent {
    private Player player;
    private Instant time;

    public PlayerTimeoutEvent(Player p) {
        player = p;
        time = Instant.now();
    }

    public Player getPlayer() {
        return player;
    }

    public Instant getTime() {
        return time;
    }
}
