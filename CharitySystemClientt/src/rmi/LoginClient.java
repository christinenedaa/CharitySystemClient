/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.LoginGUI;

/**
 *
 * @author Shrouk
 */
public class LoginClient {
    
public static void main(String[] args) {
        try {
            
           LoginGUI gui=new LoginGUI();
            gui.setVisible(true);
    
            
            // Connecting to the RMI Registry created on the server
            Registry registry = LocateRegistry.getRegistry(1099);

            // Search for the stub "calc"
          LoginController control=new LoginController(gui,registry);

            
           
            
           
        } catch (Exception ex) {
            System.out.println("Exception occured"+ex);
        }
    }
}

