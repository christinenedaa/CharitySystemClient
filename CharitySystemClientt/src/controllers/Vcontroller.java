/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
import rmi.Vform;

public class Vcontroller {
    Vform vgui;
    Registry rg;
        
        
      public  Vcontroller( Vform vgui,Registry rg ) {  
        this.vgui= vgui;
        this.rg= rg;
         vgui.getjButton1().addActionListener(new UpdateVolunteer());
}

 class UpdateVolunteer implements ActionListener{
    @Override 
    public void actionPerformed(ActionEvent ae){
    
    try{
          Vinterface VI=(Vinterface) rg.lookup("Volunteer");
        
        
        
        
        
    }catch(RemoteException ex){
         Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    catch(NotBoundException ex){
             Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    
    
    
    }
    
    }
}
        
        

        
        
        
        
        
        
        
        
        
        
        
  
