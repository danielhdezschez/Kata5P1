/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kata5;


public class Kata5 {
    public static void main(String[] args) {
        Conexion cox = new Conexion("C:\\Users\\yadai\\Documents\\NetBeansProjects\\Kata5P1\\src\\kata5\\KATA5.db");
        cox.connect();
        cox.showAll();
        cox.createNewTable("""
                           CREATE TABLE IF NOT EXISTS EMAIL (
                            Id integer PRIMARY KEY AUTOINCREMENT,
                            Mail text NOT NULL);""");
        cox.close();
    }
   
    
    
    
    
}