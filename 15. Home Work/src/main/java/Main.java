import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String version = "v0.1";
    private static int programmStep = 1; // Start position
    private static final String ANSI_GREEN = "\u001B[32m"; // Color for commands
    private static final String ANSI_BLUE = "\u001B[34m"; // Info color
    static final String ANSI_RESET = "\u001B[0m"; // Reset color
    static final String ANSI_PURPLE = "\u001B[35m"; // Color for results

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        DBWorker dbWorker = new DBWorker(new DBconfig());
        Description description = new Description();
        dbCommands dbCommands = new dbCommands(dbWorker, scanner);
        Map<Integer, List<String>> dbDescription = new HashMap<>();

        // Program steps
        // 1 - Welcome
        description.addDescription("\nWelcome to DB Controller " + version + "!\n");
        description.addDescription(ANSI_BLUE + "What to do?:\n" + ANSI_RESET);

        description.addDescription(ANSI_GREEN + "connect - connect to db;\n");
        description.addDescription("quit - exit from DB Controller;\n" + ANSI_RESET);
        dbDescription.put(1, description.getDescriptions());
        description.reset();
        // END
        // 2 - Create, Remove, Show table;
        description.addDescription(ANSI_BLUE + "Now you can:\n" + ANSI_RESET);

        description.addDescription(ANSI_GREEN + "create table - create new table by name;\n");
        description.addDescription("remove table - remove table by name;\n");
        description.addDescription("show tables - print all tables in db;\n");
        description.addDescription("single - work with single table(add, delete etc.);\n");
        description.addDescription("disconnect - exit from DB Controller;\n");
        description.addDescription("quit - exit from DB Controller;\n" + ANSI_RESET);
        dbDescription.put(2, description.getDescriptions());
        description.reset();
        // END
        // 3 - Actions with single table
        description.addDescription(ANSI_BLUE + "Single table operations:\n" + ANSI_RESET);

        description.addDescription(ANSI_GREEN + "add - add new data in a table;\n");
        description.addDescription("delete - delete data from a table;\n");
        description.addDescription("find - find data in a table;\n");
        description.addDescription("print - print all data from table;\n");
        description.addDescription("back - return to previous menu;\n");
        description.addDescription("quit - exit from DB Controller;\n" + ANSI_RESET);
        dbDescription.put(3, description.getDescriptions());
        description.reset();
        // END
        String command;

        do {
            Description.printDescriptions(dbDescription.get(programmStep));
            command = scanner.next();
            switcher(command, dbWorker, dbCommands);
        } while (!command.equalsIgnoreCase("quit")); // do something while command != quit

        // Close connection if quit;
        try {
            dbWorker.closeConnection();
        } catch (Exception e) {
            // IGNORE
        } finally {
            System.out.println("Programm finished!\nThank you for use.");
        }

    }

    /**
     * Switcher contains all logic for do while cycle
     *
     * @param command    - User input command
     * @param dbWorker   - Work with database
     * @param dbCommands - Prepare and send sql queries through out dbWorker, return/print result
     */
    private static void switcher(String command, DBWorker dbWorker, dbCommands dbCommands) {
        if (programmStep == 1) {
            // Try to connect
            if ("connect".equals(command)) {
                boolean dbConnectRes = true;
                try {
                    dbWorker.getDbConnect();
                } catch (SQLException e) {
                    dbConnectRes = false;
                    e.printStackTrace();
                }
                System.out.println(dbConnectRes ? ANSI_PURPLE + "Connect successful" + ANSI_RESET : "Connect failed");
                programmStep = dbConnectRes ? 2 : 1;
            }else if(!"quit".equals(command)){
                    System.out.println("Warning: bad command!");
            }
        } else if (programmStep == 2) {
            switch (command) {
                case "create table":
                    System.out.println(command);
                    boolean queryResult = true;
                    try {
                        dbCommands.createTable();
                    } catch (SQLException e) {
                        queryResult = false;
                        e.printStackTrace();
                    } finally {
                        System.out.println(queryResult ? ANSI_PURPLE + "Table was created" + ANSI_RESET : "Table not created");
                    }
                    break;
                case "remove table":
                    int dbRemove = 0;
                    try {
                        dbRemove = dbCommands.removeTable();
                    } catch (SQLException e) {
                        dbRemove = 1;
                    } finally {
                        if (dbRemove == -1) {
                            System.out.println("В базе данных нет таблиц для удаления");
                        } else {
                            System.out.println((dbRemove == 1) ? "Такой таблицы нет в базе" : ANSI_PURPLE + "Таблица удалена" + ANSI_RESET);
                        }
                        // continue
                    }
                    break;
                case "single":
                    programmStep = 3;
                    // continue
                    break;
                case "show tables":
                    ResultSet res = null;
                    String tablesInDB = "";
                    try {
                        tablesInDB = dbCommands.showTables();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println(ANSI_PURPLE + "Tables in DB are" + tablesInDB + ANSI_RESET);
                    }
                    break;
                case "disconnect":
                    dbWorker.closeConnection();
                    System.out.println(ANSI_PURPLE + "DB disconnected" + ANSI_RESET);
                    programmStep = 1;
                    break;
                default:
                    System.out.println("Warning: bad command!");
                    break;
            }
        } else if (programmStep == 3) {
            switch (command) {
                case "add":
                    String result = "";
                    try {
                        result = dbCommands.addData();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println(result);
                    }
                    break;
                case "delete":
                    int affectedRows = 1;
                    try {
                        affectedRows = dbCommands.delete();
                    } catch (SQLException e) {
                        affectedRows = 0;
                        e.printStackTrace();
                    } finally {
                        if (affectedRows == -1) {
                            System.out.println("Таблица не найдена в базе");
                        } else {
                            System.out.println((affectedRows != 0) ? ANSI_PURPLE + "Удалено записей " + affectedRows + ANSI_RESET : "Удалить запись не удалось");
                        }
                    }
                    break;
                case "find":
                    try {
                        dbCommands.findData();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } finally {
                        // continue
                    }
                    break;
                case "print":
                    try {
                        dbCommands.printDataFromTable();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } finally {
                        // just continue in any case
                    }
                    break;
                case "back":
                    programmStep = 2;
                    // go to step 2
                    break;
                default:
                    System.out.println("Warning: bad command!");
                    break;
            }
        }


    }


}
