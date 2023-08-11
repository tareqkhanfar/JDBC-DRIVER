package com.khanfar.clientside.Converter;

import java.sql.*;
import java.util.LinkedList;
import java.util.Properties;
import java.util.TimeZone;

public class MainTest {

    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        System.out.println("START");
      String connectionURL = "http://91.107.221.252:8080/jdbc";



        Class.forName("com.khanfar.clientside.Converter.XDriver");
        System.out.println("Started:" + new java.util.Date() + "  ->" + connectionURL);
    //    Connection con = DriverManager.getConnection(connectionURL, "root", "1234" );

        Properties properties = new Properties() ;
        properties.setProperty("user" , "root");
        properties.setProperty("password" , "1234");
        properties.setProperty("Paging" , "Disabled");
        Connection con = DriverManager.getConnection(connectionURL , properties);


        System.out.println("_________________________________________________________");

        System.out.println("DB_META_DATA");
        System.out.println("_________________________________________________________");

        DatabaseMetaData metaData = con.getMetaData() ;
        System.out.println(metaData.getURL());
        System.out.println(metaData.getDriverName());
        System.out.println(metaData.getUserName());
        System.out.println(metaData.getDatabaseProductName());
        System.out.println(metaData.getDriverName());
        System.out.println(metaData.getDriverVersion());

        System.out.println("_________________________________________________________");

/*
Meta data for resultSet : NUMBER_OF_COULMNS , CLOULMNS_NAME , COLUMN_TYPE
 */
      //  Statement st = con.createStatement();





     PreparedStatement   preparedStatement = con.prepareStatement("select  * from test ");


      ResultSet rs = preparedStatement.executeQuery();

        System.out.println(rs.getMetaData().getColumnType(2));

      while (rs.next()) {
          System.out.println(rs.getString(1)+"-->"+rs.getTimestamp(2));

      }



        System.out.println("___________________________________________________________________");

        preparedStatement =con.prepareStatement("select name , date_ , ISACTIVEAUTHOR from test where id =  ?") ;
        preparedStatement.setInt(1 ,1 );

        rs = preparedStatement.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString(0) + "--->" + rs.getDate(1) +"-->" + rs.getBoolean("ISACTIVEAUTHOR"));
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000000;

        System.out.println("TIME EXECUTION :  " + duration);
        System.exit(0);
    }
}