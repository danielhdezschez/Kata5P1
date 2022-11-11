/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author yadai
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import model.Mail;

/**
 *
 * @author yadai
 */
public class MailListReader {
    
    private static final String REGEX = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    
    public static List<Mail> read(String fileName) throws FileNotFoundException, IOException {
	String email; 
        List<Mail> emails = new ArrayList<Mail>();
        FileReader a = new FileReader(new File(fileName));
	BufferedReader archivo = new BufferedReader(a); 
	while((email = archivo.readLine())!=null) { 
            if( ValidEmail(email) ) {
                emails.add(new Mail(email));
            }
		 
	} 
	archivo.close(); 
        return emails;
    }

    private static boolean ValidEmail(String email) {
        return Pattern.compile(REGEX).matcher(email).matches();
    }
}
