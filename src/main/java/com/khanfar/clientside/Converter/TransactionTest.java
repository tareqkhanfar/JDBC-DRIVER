package com.khanfar.clientside.Converter;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class TransactionTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("START");
        String connectionURL = "http://localhost:8080/jdbc";

        Class.forName("com.khanfar.clientside.Converter.XDriver");

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1234");
        //   properties.setProperty("Paging" , "Disabled");
        Connection con = DriverManager.getConnection(connectionURL, properties);
        try {


            DatabaseMetaData metaData = con.getMetaData();
            System.out.println(metaData.getURL());
            System.out.println(metaData.getDriverName());

           // con.setAutoCommit(false);
            System.out.println("start ");
            PreparedStatement statement = con.prepareStatement("insert into test values (? , ? , ? , ?)");
            statement.setInt(1, 28);
            statement.setString(2, "Ahmad mars");
            statement.setString(3, "20/09/2030");
            statement.setInt(4, 0);
            statement.executeUpdate();

            System.out.println("insert finished ");

            Thread.sleep(5000);

            statement = con.prepareStatement("delete  from test where id = ?");
            statement.setInt(1, 27);
            statement.executeUpdate();
            System.out.println("delete  finished ");
           // con.commit();


        }
        catch (SQLException e ) {
           // con.rollback();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
           // con.setAutoCommit(true);
        }



        }

    public static void main2(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("START");
        String connectionURL = "http://localhost:8080/jdbc";

        Class.forName("com.khanfar.clientside.Converter.XDriver");

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1234");
        //   properties.setProperty("Paging" , "Disabled");
        Connection con = DriverManager.getConnection(connectionURL, properties);
        try {


            DatabaseMetaData metaData = con.getMetaData();
            System.out.println(metaData.getURL());
            System.out.println(metaData.getDriverName());

            con.setAutoCommit(false);
            System.out.println("start ");
            PreparedStatement statement = con.prepareStatement("insert into test values (? , ? , ? , ?)");
            statement.setInt(1, 27);
            statement.setString(2, "Ahmad mars");
            statement.setString(3, "20/09/2030");
            statement.setInt(4, 0);
            statement.executeUpdate();

            System.out.println("insert finished ");

            Thread.sleep(5000);

            statement = con.prepareStatement("delete  from test where id = ?");
            statement.setInt(1, 26);
            statement.executeUpdate();
            System.out.println("delete  finished ");
            con.commit();


        }
        catch (SQLException e ) {
            con.rollback();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            con.setAutoCommit(true);
        }



    }


}
