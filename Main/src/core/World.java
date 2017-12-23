package core;

import evt.*;

import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class World {
    private ArrayList<Player> players = new ArrayList<>();
    private Dimension Boundaries;
    private WorldListener listener;
    private Duration playerTimeoutLimit;
    private Timer timeoutTimer;

    public World(int x, int y) {
        Boundaries = new Dimension(x, y);
        playerTimeoutLimit = Duration.ofSeconds(500);
        timeoutTimer = new Timer();
        timeoutTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (Player player : players) {
                    if (player.getMillisIdle() >= playerTimeoutLimit.toMillis()) {
                        kickPlayer(player, PlayerLeaveReason.KICKED_BY_CONSOLE);
                        if (listener != null)
                            listener.onPlayerLeave(new PlayerLeaveEvent(player, PlayerLeaveReason.KICKED_BY_CONSOLE));
                    } else {
                        player.idlePlus(10);
                    }
                }
            }
        }, 0, 10);
    }

    public void addPlayer(Player p) {
        for (Player player : players) {
            if (player.getUUID().equals(p.getUUID()))
                return;
        }
        players.add(p);
        if (listener != null)
            listener.onPlayerJoin(new PlayerJoinEvent(p));
    }

    public void kickPlayer(Player p, PlayerLeaveReason reason) {
        for (Player player : players) {
            if (player.getUUID().equals(p.getUUID())) {
                players.remove(player);
                if (listener != null)
                    listener.onPlayerLeave(new PlayerLeaveEvent(player, reason));
            }
        }
    }

    public Player[] getPlayers() {
        return (Player[])players.toArray();
    }

    public void setListener(WorldListener w) {
        listener = w;
    }

    public Duration getTimeout() {
        return playerTimeoutLimit;
    }

    public void setTimeout(Duration p) {
        playerTimeoutLimit = p;
    }
}