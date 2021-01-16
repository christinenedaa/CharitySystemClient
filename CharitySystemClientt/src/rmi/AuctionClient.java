/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;
import controllers.AuctionguiController;
import java.rmi.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.AuctionInterface;

public class AuctionClient {

    public static void main(String[] args) {
        try {
            
            AuctionGUI gui=new AuctionGUI();
            gui.setVisible(true);
    
            
            // Connecting to the RMI Registry created on the server
            Registry registry = LocateRegistry.getRegistry(1099);

            // Search for the stub "calc"
            AuctionguiController guicont=new AuctionguiController(gui,registry);

            
           
            
           
        } catch (Exception ex) {
            System.out.println("Exception occured"+ex);
        }
    }
}
