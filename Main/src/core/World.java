package core;

import java.awt.*;
import java.util.ArrayList;

public class World {
    private ArrayList<Player> players = new ArrayList<>();
    private Dimension Boundaries;

    public World(int x, int y) {
        Boundaries = new Dimension(x, y);
    }

    public void addPlayer(Player p) {
        players.add(p);
    }

    public void kickPlayer(Player p) {
        for (Player player : players) {
            if (player.getUUID().equals(p.getUUID()))
                players.remove(player);
        }
    }

    public Player[] getPlayers() {
        return (Player[])players.toArray();
    }
}