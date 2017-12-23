package db;

public class DBPlayer {
    private static DBPlayer ourInstance = new DBPlayer();

    public static DBPlayer getInstance() {
        return ourInstance;
    }

    private DBPlayer() {

    }
}
