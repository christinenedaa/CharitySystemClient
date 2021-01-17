/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
import rmi.LoginInterface;
import rmi.*;
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
//        gui.getjTextField1().addActionListener(new UsernameAction());
//        gui.getjTextField2().addActionListener(new PasswordAction());
        gui.getjButton2().addActionListener(new RegisterAction());
       
    }

    
     class LoginBtnAction implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
         
           
            
                   String Username = gui.getjTextField1().getText();
                   String password = String.valueOf(gui.getjPasswordField2().getPassword());
                   
                    
                try {
                  LoginInterface  li = (LoginInterface) r.lookup("Profile");
                     boolean result=li.Login(Username, password);
                     
                       if (Username==null || password==null)
        {
            JOptionPane.showMessageDialog(null, "Username or Password are Empty please Enter Values");
         
        }     
        
        else if (result==true){
        AuctionGUI g=new AuctionGUI();
        g.setVisible(true);}
        else {
                JOptionPane.showMessageDialog(null,"Password and username are incorrect");
                }
                } catch (RemoteException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
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
}
 

     
  /////////////////////////////////////////////////////////////////////////////////   
//     
//     
//     
//private static  class UsernameAction implements ActionListener {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//}
//private static class PasswordAction implements ActionListener {
//
//        public PasswordAction() {
//        }
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//    }
//


