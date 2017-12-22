package core;

public class Auto {
    private Player player;
    private World world;

    public Auto() { }
    public Auto(World w) {
        world = w;
    }

    public void setPlayer(Player p) {
        if (player != null)
            player = p;
    }

    public Player getPlayer() {
        return player;
    }

    public World getWorld() {
        return world;
    }
}