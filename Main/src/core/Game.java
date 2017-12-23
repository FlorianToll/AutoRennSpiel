package core;

import db.Database;
import log.GameLogger;

public class Game {
    private World world;
    private GameLogger logger;
    private Database database;

    public Game(World w, Database db) {
        world = w;
        database = db;
    }

    public World getWorld() {
        return world;
    }

    public void setLogger(GameLogger g) {
        logger = g;
    }

    public Database getDatabase() {
        return database;
    }
}
