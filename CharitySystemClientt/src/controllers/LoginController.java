/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Shrouk
 */
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import Interface.LoginInterface;
import java.util.Properties;

import javax.swing.JOptionPane;
import rmi.LoginGUI;

public class LoginController {
    LoginGUI gui;
    Registry r;
    
     public LoginController(LoginGUI gui, Registry r) {
        this.gui = gui;
        this.r = r;
        gui.getjButton1().addActionListener(new LoginBtnAction());
        gui.getjTextField1().addActionListener(new UsernameAction());
        gui.getjTextField2().addActionListener(new PasswordAction());
        gui.getjButton2().addActionListener(new RegisterAction());
        gui.getjTextField2();
        gui.getjTextField2();
    }

    
     class LoginBtnAction implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
         
            try {
                 LoginInterface LG=(LoginInterface) r.lookup("Profile");
                  Properties prop = new Properties();
                   String Username = gui.getjTextField1().getText();
                   String password = String.valueOf(gui.getjPasswordField2().getPassword());
       // String password = String.valueOf(gui.getjTextField2().getText());
        //String select = SelectBox.getSelectedItem().toString(); 
        MongoClient client = new MongoClient();
   MongoDatabase charity=client.getDatabase("CharityDB");
              MongoCollection profile=charity.getCollection("Profile");
              
        
        if (Username.equals("") && password.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Username and Password are Empty please Enter Values");
         
        }     
        
        else if (password.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Password is Empty please Enter Value");
        }
        else if(Username.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Username is Empty please Enter Value");
        }
             
        LG.Login(Username, password);
   
        
             }catch(RemoteException ex){
         Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

    }
    catch(NotBoundException ex){
             Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

    }
    }
    
    
    }
     class RegisterAction implements ActionListener{
  @Override 
    public void actionPerformed(ActionEvent ae){
    try{
    
     LoginInterface LG=(LoginInterface) r.lookup("Profile");
    String intername= gui.getjTextField2().getText();
    String interpass=String.valueOf(gui.getjPasswordField2().getPassword());
   
     LG.Sign( intername, interpass);
    
    }catch(RemoteException ex){
         Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

    }
    catch(NotBoundException ex){
             Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

    }
    }
 
 
 }
     
  /////////////////////////////////////////////////////////////////////////////////   
     
     
     
private static  class UsernameAction implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
}
private static class PasswordAction implements ActionListener {

        public PasswordAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }



}