/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kata5;

import control.Conexion;
import control.MailListReader;
import java.io.IOException;
import java.util.List;
import model.Mail;
import control.Conexion;


public class Kata5 {
    public static void main(String[] args) throws IOException {
        Conexion cox = new Conexion("C:\\Users\\yadai\\Documents\\NetBeansProjects\\Kata5P1\\src\\kata5\\KATA5.db");
        cox.connect();
        cox.showAll();
        cox.createNewTable("""
                           CREATE TABLE IF NOT EXISTS EMAIL (
                            Id integer PRIMARY KEY AUTOINCREMENT,
                            Mail text NOT NULL);""");
        List<Mail> emails = MailListReader.read("C:\\Users\\yadai\\Documents\\NetBeansProjects\\Kata5P1\\src\\kata5\\email.txt");
        cox.insertarEmail(emails);
        cox.close();
    }
   
    
    
    
    
}