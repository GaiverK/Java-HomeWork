import java.sql.*;

public class DBWorker {
    public static Connection dbConnect = null;
    public static Statement statement;
    private final DBconfig dBconfig;

    public DBWorker(DBconfig dBconfig) {
        this.dBconfig = dBconfig;
    }

    public Connection getDbConnect() throws SQLException {
        Connection connection = DriverManager.getConnection(dBconfig.URL, dBconfig.USER, dBconfig.PASS);
        dbConnect = connection;
        return dbConnect;
    }

    public ResultSet simpleQuery(String sql) throws SQLException {
        statement = dbConnect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }

    public int updateQuery(String sql) throws SQLException {
        statement = dbConnect.createStatement();
        int columns = statement.executeUpdate(sql);
        statement.close();
        return columns;
    }

    public void closeConnection() {
        try {
            dbConnect.close();
            dbConnect = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
