package com.youssef.produits_app.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/produits_db", "root","");
            System.out.println("connected");

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("erreur");
        }
    }

    public static Connection getConnection(){
        return connection;
    }
}
