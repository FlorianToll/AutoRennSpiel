package db;

public class DBPlayerContainer {
    private static DBPlayerContainer playerContainer;
    public DBPlayerContainer() {

    }



    public static DBPlayerContainer getInstance() {
        if(playerContainer == null) {
            playerContainer = new DBPlayerContainer();
        }
        return playerContainer;
    }
}
