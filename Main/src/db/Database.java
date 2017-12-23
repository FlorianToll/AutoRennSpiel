package db;

import java.sql.*;

public class Database {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private DBPlayer gameContainer = DBPlayer.getInstance();

    public Database() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/test?"
                        + "user=root");
    }

    private void saveToClassPlayer(ResultSet resultSet, int order) {
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String user = resultSet.getString("name");
                long gameScore = resultSet.getLong("gameScore");
                long gameWin = resultSet.getLong("gameWin");
                long gamesPlayed = resultSet.getLong("gamesPlayed");
                double winRatio = resultSet.getDouble("winRatio");
                if (order == 1) {
                    // gameContainer.player1 = new Player(id, user, gameScore, gameWin, gamesPlayed, winRatio);     Spielerdaten werden geladen todo: nur ein Spieler nötig = einer Pro pc
                }else if (order == 2) {
                    // gameContainer.player2 = new Player(id, user, gameScore, gameWin, gamesPlayed, winRatio);
                }else {
                    // error
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadFromDataBasePlayer1(String name) throws SQLException {
        selectPlayerByNameAndOrder(name, 1);
    }

    public void loadFromDataBasePlayer2(String name) throws SQLException {
        selectPlayerByNameAndOrder(name, 2);
    }

    private void selectPlayerByNameAndOrder(String name, int order) {
        try {
            statement = connect.createStatement();
            resultSet = statement
                    .executeQuery("select * from playerstats where name = '" + name + "'");
            saveToClassPlayer(resultSet, order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addNewPlayerToDataBase(String name) throws SQLException {
        try {
            preparedStatement = connect
                    .prepareStatement("Insert into playerstats (id, name, gameScore, gameWin, gamesPlayed, winRatio) values(default,'" + name + "', '0', '0', '0', '0')");
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }


    }

    /**
     * updates an existing player
     *
     * @param id
     * @param gameScore
     * @param gamesWonAgainstOtherPlayer
     * @param gamesPlayed
     * @throws SQLException
     */
    public void savePlayerInDataBase(int id, long gameScore, long gamesWonAgainstOtherPlayer, long gamesPlayed) throws SQLException {
        double a = gameScore;
        double b = gamesPlayed;
        double winRatio = a / b;
        try {
            preparedStatement = connect
                    .prepareStatement("UPDATE playerstats SET gameScore = '" + gameScore + "' WHERE id = " + id);
            preparedStatement.executeUpdate();
            preparedStatement = connect
                    .prepareStatement("UPDATE playerstats SET gameWin = '" + gamesWonAgainstOtherPlayer + "' WHERE id = " + id);
            preparedStatement.executeUpdate();
            preparedStatement = connect
                    .prepareStatement("UPDATE playerstats SET gamesPlayed = '" + gamesPlayed + "' WHERE id = " + id);
            preparedStatement.executeUpdate();
            preparedStatement = connect
                    .prepareStatement("UPDATE playerstats SET winRatio = '" + winRatio * 100 + "' WHERE id = " + id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
}
