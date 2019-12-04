import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class dbCommands {
    private DBWorker dbWorker;
    private Scanner scanner;

    dbCommands(DBWorker dbWorker, Scanner scanner) {
        this.dbWorker = dbWorker;
        this.scanner = scanner;
    }

    /**
     * Creates table. Universal method;
     *
     * @return affected rows int
     * @throws SQLException - throws sql exceptions
     */
    public int createTable() throws SQLException {
        String sqlQuery = "Create table ";
        System.out.println("Set table name:");
        sqlQuery += scanner.next();
        System.out.println("How many fields you need?:");
        int howMany = scanner.nextInt();
        int counter = 1;
        sqlQuery += " ( ";
        while (howMany > 0) {
            System.out.println("Set field " + (counter++) + " name TYPE:");
            sqlQuery += (howMany-- == 1) ? scanner.next() : scanner.next() + ", ";
        }
        sqlQuery += ");";
        return dbWorker.updateQuery(sqlQuery);
    }

    /**
     * Delete any table in db
     *
     * @return affected rows int
     * @throws SQLException - throws sql exceptions
     */
    public int removeTable() throws SQLException {
        String tablesInDB = this.showTables();
        int affectedRows = -1;
        if (!tablesInDB.equals("EMPTY")) {
            System.out.println("Input table name for remove" + tablesInDB + ":");
            String sqlQuery = "Drop table ";
            sqlQuery += scanner.next() + ";";
            affectedRows = dbWorker.updateQuery(sqlQuery);
        }
        return affectedRows;
    }

    /**
     * Get all tables from db
     *
     * @return String with tables names - format [tb1, tb2, etc.]
     * @throws SQLException - throws sql exceptions
     */
    public String showTables() throws SQLException {
        String sqlQuery = "show tables;";
        ResultSet res = dbWorker.simpleQuery(sqlQuery);
        return printTables(res);
    }

    /**
     * Format tables names from db
     *
     * @param res - ResultSet from SHOW TABLES query
     * @return Formatted string or EMPTY
     * @throws SQLException - throws sql exceptions
     */
    public String printTables(ResultSet res) throws SQLException {
        String printResult = "";
        printResult += " [";
        String fromDBRes = "";
        while (res.next()) {
            fromDBRes += res.getString("Tables_in_superkur_jdbc") + ", ";
        }
        if (fromDBRes.length() != 0) {
            printResult += fromDBRes.substring(0, fromDBRes.length() - 2) + "]";
        } else {
            printResult = "EMPTY";
        }
        DBWorker.statement.close();
        return printResult;
    }

    /**
     * Get columns names by table name
     *
     * @param tableName - String name of table
     * @return ResultSet with columns
     * @throws SQLException - throws sql exceptions
     */
    private ResultSet getColumns(String tableName) throws SQLException {
        String sqlQuery = "SELECT *\n" +
                "FROM INFORMATION_SCHEMA.COLUMNS\n" +
                "WHERE TABLE_NAME = '" + tableName + "'";
        return dbWorker.simpleQuery(sqlQuery);
    }

    /**
     * Get single string with columns names
     *
     * @param tableName - String name of table
     * @return String in format "col1, col2, etc."
     * @throws SQLException - throws sql exceptions
     */
    private String getFormattedColumns(String tableName) throws SQLException {
        String sqlQuery = "SELECT *\n" +
                "FROM INFORMATION_SCHEMA.COLUMNS\n" +
                "WHERE TABLE_NAME = '" + tableName + "'";
        ResultSet res = dbWorker.simpleQuery(sqlQuery);
        String columns = "";
        while (res.next()) {
            columns += res.getString("COLUMN_NAME") + ", ";
        }
        return columns.substring(0, columns.length() - 2);
    }

    /**
     * Section of crud operations
     * Add data to any table in db. Universal method.
     *
     * @throws SQLException - throws sql exceptions
     */
    public String addData() throws SQLException {
        String sqlQuery = "INSERT INTO ";
        String tablesInDB = this.showTables();
        if (!tablesInDB.equals("EMPTY")) {
            System.out.println("Input table name from" + tablesInDB + ":");
            String tableName = scanner.next();
            sqlQuery += tableName + " SET ";
            ResultSet tableColumns = this.getColumns(tableName);
            String partQuery = "";
            while (tableColumns.next()) {
                String columnName = tableColumns.getString("COLUMN_NAME");
                String columnType = tableColumns.getString("COLUMN_TYPE");
                System.out.printf("Input value for field \"%s\" with type \"%s\"\n",
                        columnName,
                        columnType
                );
                String userInput = scanner.next();
                partQuery += columnName + "='" + userInput + "', ";
            }
            if (!partQuery.equals("")) {
                sqlQuery += partQuery.substring(0, partQuery.length() - 2) + ";";
                int affectedRows = dbWorker.updateQuery(sqlQuery);
                return (affectedRows > 0) ? "Добавлена новая запись" : "Не удалось добавить данные";
            } else {
                return "Укажите корректную таблицу";
            }
        }
        return "DB EMPTY";
    }

    /**
     * Delete any row/rows by field LIKE value condition
     *
     * @return int affectedRows (0, -1, n);
     * @throws SQLException - throws sql exceptions
     */
    public int delete() throws SQLException {
        String sqlQuery;
        int affectedRows = 0;
        String tablesInDB = this.showTables();
        if (!"EMPTY".equals(tablesInDB)) {
            System.out.println("Input table name from" + tablesInDB + ":");
            String tableName = scanner.next();
            if (tablesInDB.contains(tableName)) {
                System.out.println("Input delete condition " + getFormattedColumns(tableName) + " :");
                String deleteCondition = scanner.next();
                System.out.println("Input keyword for condition " + deleteCondition + ":");
                String keyword = scanner.next();
                sqlQuery = String.format("DELETE FROM %s WHERE %s LIKE %s;",
                        tableName,
                        deleteCondition,
                        "'%" + keyword + "%'"
                );
                affectedRows = dbWorker.updateQuery(sqlQuery);
            } else {
                return -1; // No such table
            }
        }
        return affectedRows;
    }

    /**
     * Print data from choosen table
     *
     * @throws SQLException - throws sql exceptions
     */
    public void printDataFromTable() throws SQLException {
        String tablesInDB = this.showTables();
        if (!"EMPTY".equals(tablesInDB)) {
            System.out.println("Choose table name from" + tablesInDB + ":");
            String tableName = scanner.next();
            if (tablesInDB.contains(tableName)) {
                String sqlQuery = String.format("SELECT * FROM %s;",
                        tableName
                );
                ResultSet data = dbWorker.simpleQuery(sqlQuery);
                ResultSet columns = getColumns(tableName);
                printData(data, columns);
            } else {
                System.out.println("No such table");
            }
        }
    }

    /**
     * Find data from chosen table by field condition, sorted by chosen field for search
     *
     * @throws SQLException - throws sql exceptions
     */
    public void findData() throws SQLException {
        String tablesInDB = this.showTables();
        if (!"EMPTY".equals(tablesInDB)) {
            System.out.println("Choose table name from" + tablesInDB + ":");
            String tableName = scanner.next();
            if (tablesInDB.contains(tableName)) {
                System.out.println("Input find condition " + getFormattedColumns(tableName) + " :");
                String findCondition = scanner.next();
                System.out.println("Input keyword for condition " + findCondition + ":");
                String keyword = scanner.next();
                String sqlQuery = String.format("SELECT * FROM %s WHERE %s LIKE %s ORDER BY %s;",
                        tableName,
                        findCondition,
                        "'%" + keyword + "%'",
                        findCondition
                );
                ResultSet data = dbWorker.simpleQuery(sqlQuery);
                ResultSet columns = getColumns(tableName);
                printData(data, columns);
            } else {
                System.out.println("No such table");
            }
        }
    }

    /**
     * Print data from any table by data, columns. Universal method
     *
     * @param data    - Table fields
     * @param columns - Columns names
     * @throws SQLException - throws sql exceptions
     */
    private void printData(ResultSet data, ResultSet columns) throws SQLException {
        List<String> tColumns = new ArrayList<>();
        long rowCounter = 0;
        while (columns.next()) {
            tColumns.add(columns.getString("COLUMN_NAME"));
        }
        while (data.next()) {
            rowCounter++;
            System.out.println(Main.ANSI_PURPLE + "==========================================");
            for (String colName : tColumns) {
                System.out.println(colName + ": " + data.getString(colName));
            }
        }
        System.out.println("==========================================");
        System.out.println((rowCounter == 0) ? "В таблице нет записей" + Main.ANSI_RESET : "Выведено записей " + rowCounter + Main.ANSI_RESET);
    }
}
