package evt;

import core.Player;

public class PlayerTimeoutEvent {
    private Player player;

    public PlayerTimeoutEvent(Player p) {
        player = p;
    }
}
