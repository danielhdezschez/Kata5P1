/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author yadai
 */
public class SqlitePeopleStore {

    private final String url;

    public String getUrl() {
        return url;
    }
    
    public SqlitePeopleStore(String url) {
        this.url = url;
    }
    
    private static void connect() {
        Connection conn = null;
    try {
        String url = "jdbc:sqlite:C:\\Users\\yadai\\Documents\\NetBeansProjects\\Kata5P1\\src\\kata5\\KATA5.db";
        conn = DriverManager.getConnection(url);
        System.out.println("Connexión a SQLite establecida");
        
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
    
    
    
}


