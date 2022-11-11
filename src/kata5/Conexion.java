/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author yadai
 */
public class Conexion {

    public Conexion(String FileName) {
        this.FileName = FileName;
    }
    
    private final String FileName;
    private Connection conn;


    public void connect() {
        conn = null;
    try {
        String url = "jdbc:sqlite:" + FileName;
        conn = DriverManager.getConnection(url);
        System.out.println("Connexión a SQLite establecida");
        
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } 
}
    public void showAll(){
        String sql = "SELECT * FROM PEOPLE";
        try (
                Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)){
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "\t" +
            rs.getString("Name") + "\t" +
            rs.getString("Apellidos") + "\t" +
            rs.getString("Departamento") + "\t");
        }   
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void close() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Conexion cerrada");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void createNewTable(String sql) {
    try (
    Statement stmt = conn.createStatement()) {
    stmt.execute(sql);
    System.out.println("Tabla creada");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
  }
    
}
