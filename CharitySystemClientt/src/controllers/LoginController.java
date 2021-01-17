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
import rmi.Vinterface;
import rmi.LoginInterface;
import rmi.*;
import java.util.Properties;

import javax.swing.JOptionPane;
import rmi.LoginGUI;
import rmi.HomeGUI;
import rmi.Vform;

public class LoginController {
    LoginGUI gui;
    Registry r;
    HomeGUI hgui;
    Vform vgui;
    
     public LoginController(LoginGUI gui, Registry r) {
        this.gui = gui;
        this.r = r;
        this.hgui= hgui;
        this.vgui=vgui;
        gui.getjButton1().addActionListener(new LoginBtnAction());
//        gui.getjTextField1().addActionListener(new UsernameAction());
//        gui.getjTextField2().addActionListener(new PasswordAction());
        gui.getjButton2().addActionListener(new RegisterAction());
        hgui.getjButton1().addActionListener(new AuctionButton());
        hgui.getjButton2().addActionListener(new VolunteerButton());
         hgui.getjButton3().addActionListener(new DonorButton());
         hgui.getjButton4().addActionListener(new EventButton());
         hgui.getjButton5().addActionListener(new MerchButton());
         vgui.getjButton1().addActionListener(new UpdateVolunterButton());
       
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
        HomeGUI HG=new HomeGUI();
        HG.setVisible(true);}
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

 class AuctionButton implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                AuctionInterface AI=(AuctionInterface) r.lookup("Auction");
            
         AuctionGUI g=new AuctionGUI();
        g.setVisible(true);
           }catch(RemoteException ex){
         Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

    }
    catch(NotBoundException ex){
             Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

    }
    }
 
 }

class VolunteerButton implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                
               Vinterface VI =(Vinterface) r.lookup("Volunteer");
            
         Vform vg=new Vform();
        vg.setVisible(true);
           }catch(RemoteException ex){
         Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

    }
    catch(NotBoundException ex){
             Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

    }
    }
 
 }

class DonorButton implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                
               DonorInterface DI =(DonorInterface) r.lookup("Donor");
            
         Vform vg=new Vform();
        vg.setVisible(true);
           }catch(RemoteException ex){
         Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

    }
    catch(NotBoundException ex){
             Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

    }
    }
 
 }
class EventButton implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                
              EventInterface EI =(EventInterface) r.lookup("Event");
            
         EventGui eg=new  EventGui();
        eg.setVisible(true);
           }catch(RemoteException ex){
         Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

    }
    catch(NotBoundException ex){
             Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

    }
    }
 
 }
class MerchButton implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                
             EventInterface EI =(EventInterface) r.lookup("Event");
            
         EventGui eg=new  EventGui();
        eg.setVisible(true);
           }catch(RemoteException ex){
         Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

    }
    catch(NotBoundException ex){
             Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

    }
    }
 
 }
     

class UpdateVolunterButton implements ActionListener{
  @Override 
    public void actionPerformed(ActionEvent ae){
    try{
    
     Vinterface VI =(Vinterface) r.lookup("Volunteer");
    String name= vgui.getjTextField1().getText();
    String email= vgui.getjTextField7().getText();
    String skills=vgui.getjTextField2().getText();
    String level=vgui.getjTextField3().getText();
    String interest=vgui.getjTextField4().getText();
   String experience=vgui.getjTextField5().getText();
     VI.Updatedata( name,email, skills,level,interest,experience);
    
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


