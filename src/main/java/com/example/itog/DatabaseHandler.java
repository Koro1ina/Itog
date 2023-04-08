package com.example.itog;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    private Connection getDbConnection() throws ClassNotFoundException, SQLException {
        Map<String, String> env = System.getenv();
        String host = env.getOrDefault("DB_HOST", "localhost");;
        String port = env.getOrDefault("DB_PORT", "3306");
        String database = env.getOrDefault("DB_NAME", "user35");
        String user = env.getOrDefault("DB_USER", "root");
        String password = env.getOrDefault("DB_PASS", "root");

        String connectionUrl = String.format(
                "jdbc:mysql://%s:%s/%s?serverTimezone=UTC",
                host,
                port,
                database
        );

        Class.forName("com.mysql.cj.jdbc.Driver");


        if (dbConnection == null) {
            dbConnection = DriverManager.getConnection(
                    connectionUrl,
                    user,
                    password
            );
            System.out.println("Connected to database");
        }


        return dbConnection;
    }


    public void signUpUser(Client user) {
        String insert = "INSERT INTO " + Const.CLIENT_TABLE + "(" +
                Const.FIO_CLIENT + "," +
                Const.PASSPORT_CLIENT + "," + Const.DATEBD_CLIENT + "," +
                Const.LOGIN_CLIENT + "," + Const.PASSWORD_CLIENT + ")" +
                "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getFIO_CLIENT());
            prSt.setString(2, user.getPASSPORT_CLIENT());
            prSt.setString(3, user.getDATEBD_CLIENT());
            prSt.setString(4, user.getLOGIN_CLIENT());
            prSt.setString(5, user.getPASSWORD_CLIENT());

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUser(Client user) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.CLIENT_TABLE + " WHERE " +
                Const.LOGIN_CLIENT + "=? AND " + Const.PASSWORD_CLIENT + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getLOGIN_CLIENT());
            prSt.setString(2, user.getPASSWORD_CLIENT());

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public ResultSet getSotr(Sotr sotr) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.SOTR_TABLE + " WHERE " +
                Const.SOTR_LOGIN + "=? AND " + Const.SOTR_PASS + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, sotr.getLOGIN_SOTR());
            prSt.setString(2, sotr.getPASSWORD_SOTR());

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }
    public ArrayList<String> getBook() throws SQLException, ClassNotFoundException {
        String zapros = "select NameBook, Autor, Bookcol, Cell from sys.book";
        Statement statement = getDbConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(zapros);
        ArrayList<String> result = new ArrayList<>();
        while (resultSet.next()){
            result.add(resultSet.getString(1));
            result.add(resultSet.getString(2));
            result.add(resultSet.getString(3));
            result.add(resultSet.getString(4));

        }
        statement.close();
        return result;
    }
    public ArrayList<String> getfiltr(String Title) throws SQLException, ClassNotFoundException {
        String zapros = "select NameBook, Autor, Bookcol, Cell from sys.book WHERE Autor = '"+Title+"'";
        Statement statement = getDbConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(zapros);
        ArrayList<String> result = new ArrayList<>();
        while (resultSet.next()){
            result.add(resultSet.getString(1));
            result.add(resultSet.getString(2));
            result.add(resultSet.getString(3));
            result.add(resultSet.getString(4));

        }
        statement.close();
        return result;
    }
    public ArrayList<String> getAutor() throws SQLException, ClassNotFoundException {
        String zapros = "select Autor from sys.book";
        Statement statement = getDbConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(zapros);
        ArrayList<String> result = new ArrayList<>();
        while (resultSet.next()){
            result.add(resultSet.getString(1));
        }
        statement.close();
        return result;
    }

    public ArrayList<String> getSortirovcaAZ(String Title) throws SQLException, ClassNotFoundException {
        String zapros = "select NameBook, Autor, Bookcol, Cell from sys.book ORDER BY '"+Title+"'";
        Statement statement = getDbConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(zapros);
        ArrayList<String> result = new ArrayList<>();
        while (resultSet.next()){
            result.add(resultSet.getString(1));
            result.add(resultSet.getString(2));
            result.add(resultSet.getString(3));
            result.add(resultSet.getString(4));

        }
        statement.close();
        return result;
    }

    public ArrayList<String> getSortirovcaZA(String Title) throws SQLException, ClassNotFoundException {

        String zapros = "select NameBook, Autor, Bookcol, Cell from sys.book ORDER BY '"+Title+"' DESC";
        Statement statement = getDbConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(zapros);
        ArrayList<String> result = new ArrayList<>();
        while (resultSet.next()){
            result.add(resultSet.getString(1));
            result.add(resultSet.getString(2));
            result.add(resultSet.getString(3));
            result.add(resultSet.getString(4));

        }
        statement.close();
        return result;
    }

    public void initTable() throws SQLException, FileNotFoundException {
        if (dbConnection != null) {
            System.out.println("Connected to database");
        }
        String connStr = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        dbConnection = DriverManager.getConnection(connStr, dbUser, dbPass);
        PreparedStatement preparedStatement = dbConnection.prepareStatement("SHOW TABLES;");
        ResultSet resultSet = preparedStatement.executeQuery();
        if (!(resultSet.next())) {
            ScriptRunner scriptRunner = new ScriptRunner(dbConnection);
            Reader reader = new BufferedReader(new FileReader("script.sql"));
            scriptRunner.runScript(reader);
        }
//        String connectionString = "jdbc:mysql://" + dbHost + ":"
//                + dbPort + "/" + dbName;
//
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        dbConnection = DriverManager.getConnection(connectionString,
//                dbUser, dbPass);

    }

}
