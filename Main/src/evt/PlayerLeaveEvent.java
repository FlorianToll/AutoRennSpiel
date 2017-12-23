package evt;

import core.Player;
import java.time.Instant;

public class PlayerLeaveEvent {
    private final Player player;
    private final Instant time;
    private final PlayerLeaveReason reason;

    public PlayerLeaveEvent(Player p, PlayerLeaveReason r) {
        player = p;
        time = Instant.now();
        reason = r;
    }

    public Player getPlayer() {
        return player;
    }

    public Instant getTime() {
        return time;
    }

    public PlayerLeaveReason getReason() {
        return reason;
    }
}