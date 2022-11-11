/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kata5;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Kata5 {
    public static void main(String[] args) {
        Connection conn = connect("C:\\Users\\yadai\\Documents\\NetBeansProjects\\Kata5P1\\src\\kata5\\KATA5.db");
        showAll(conn);
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Conexion cerrada");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private static Connection connect(String FileName) {
        Connection conn = null;
    try {
        String url = "jdbc:sqlite:" + FileName;
        conn = DriverManager.getConnection(url);
        System.out.println("Connexión a SQLite establecida");
        
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } 
    return conn;
}
    private static void showAll(Connection conn){
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
    
}