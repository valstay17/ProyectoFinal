package org.example.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import org.sqlite.JDBC;

public class ConexionDatos {
    private String baseDatos;
    private static ConexionDatos _instance;
    private Connection connection;

    private ConexionDatos(String dataBase){
        this.baseDatos = dataBase;
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:"+this.baseDatos);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static ConexionDatos getInstance(String baseDatos){
        if(_instance == null){
            _instance = new ConexionDatos(baseDatos);
        }else{
            System.out.println("Ya se creo");
        }
        return _instance;
    }
    public Connection getConnection(){
        return connection;
    }

}
