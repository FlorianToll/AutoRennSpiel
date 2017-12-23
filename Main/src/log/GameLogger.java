package log;

import core.World;

public class GameLogger extends Logger {
    private World world;

    public GameLogger(World world) {
        this.world = world;
    }
}
