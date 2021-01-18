/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.EventInterface;
import rmi.Eventgu;
import rmi.MerchInterface;

/**
 *
 * @author DELL
 */
public class EventController {
        Eventgu ev;
        Registry r;
  ///////////////////////////////////////////Event GUI /////////////////////////////////////////////////
    /***************panel 1 **************/
        public EventController(Eventgu ev, Registry r) {
        this.ev = ev;
        this.r = r;
        ev.getjButton4().addActionListener(new ReserveBtn());
        ev.getjButton6().addActionListener(new HostBtn());
        ev.getjButton5().addActionListener(new PurchaseBtn());
        ev.getjButton1().addActionListener(new ReserveBtn());
        ev.getjButton2().addActionListener(new HostBtn());
        ev.getjButton3().addActionListener(new PurchaseBtn());
    }
      class ReserveEvent implements ActionListener{//for panel
    @Override 
    public void actionPerformed(ActionEvent ae){
    
    try{
       
       ev.getjPanel1().setVisible(true);
    EventInterface EI = (EventInterface) r.lookup("Event");
    ev.getjButton4().addActionListener(new ReserveBtn());
    
    
    }catch(RemoteException ex){
         Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    catch(NotBoundException ex){
             Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    
    
    
    }
    
    }
    
      
         class ReserveBtn implements ActionListener{ //button
     @Override 
    public void actionPerformed(ActionEvent ae){
  try{   
      
      
   
    EventInterface EI = (EventInterface) r.lookup("Event");
    
    String spmail = ev.getjTextField1().getText();
    int id=Integer.parseInt(ev.getjTextField2().getText());
     String eventNam = ev.getjTextField3().getText();
     String eventloc = ev.getjTextField4().getText();
     String eventdat = ev.getjTextField5().getText();
     int reqq=Integer.parseInt(ev.getjTextField6().getText());
     boolean stat = Boolean.parseBoolean(ev.getjTextField7().getText());
     EI.ReserveEvent(spmail, id, eventNam, eventdat, eventloc, reqq, stat);
  
   
    
     
    
    }catch(RemoteException ex){
         Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    catch(NotBoundException ex){
             Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    
    }
    
    }
      
      
      /**************panel 2 **************/
      
      
        class HostMerch implements ActionListener{//for panel
    @Override 
    public void actionPerformed(ActionEvent ae){
    
    try{
       
       ev.getjPanel3().setVisible(true);
    //EventInterface EI = (EventInterface) r.lookup("Event");
      MerchInterface MI = (MerchInterface)  r.lookup("Merch");
    ev.getjButton6().addActionListener(new HostBtn());
    
    
    }catch(RemoteException ex){
         Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    catch(NotBoundException ex){
             Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    
    
    
    }
    
    }
      
      
        class HostBtn implements ActionListener{ //button
     @Override 
    public void actionPerformed(ActionEvent ae){
  try{   
      
      
   ev.getjPanel3().setVisible(true);
   // EventInterface EI = (EventInterface) r.lookup("Event");
    
    MerchInterface MI = (MerchInterface)  r.lookup("Merch");
    
    String smail = ev.getjTextField10().getText();
     String MerName = ev.getjTextField11().getText();
    int Mid=Integer.parseInt(ev.getjTextField12().getText());
     MI.HostMerch(smail, MerName, Mid);
     
    
   
    
     
    
    }catch(RemoteException ex){
         Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    catch(NotBoundException ex){
             Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    
    }
    
    }
      /******************panel 3*********/
      
       
        class PurchaseItm implements ActionListener{//for panel
    @Override 
    public void actionPerformed(ActionEvent ae){
    
    try{
       
       ev.getjPanel2().setVisible(true);
      MerchInterface MI = (MerchInterface)  r.lookup("Merch");
    ev.getjButton5().addActionListener(new PurchaseBtn());
    
    
    }catch(RemoteException ex){
         Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    catch(NotBoundException ex){
             Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    
    
    
    }
    
    }
      
      
        class PurchaseBtn implements ActionListener{ //button
     @Override 
    public void actionPerformed(ActionEvent ae){
  try{   
      
      
   
  
    
    MerchInterface MI = (MerchInterface)  r.lookup("Merch");
    
    
    String BuyerM = ev.getjTextField9().getText();
    int itmid=Integer.parseInt(ev.getjTextField8().getText());
     MI.PurchaseItem(itmid, BuyerM);
     
    
   
    
     
    
    }catch(RemoteException ex){
         Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    catch(NotBoundException ex){
             Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    
    }
    
    }
        
        
        
        
        
        
        
        
        
    /*****************end my stuff************/    
        
        
        
        class ReserveNvBar implements ActionListener{
     @Override 
    public void actionPerformed(ActionEvent ae){
      try{
        ev.getjPanel1().setVisible(true);
               
        
    EventInterface EI = (EventInterface) r.lookup("Event");
    
      ev.getjButton1().addActionListener(new ReserveBtn());
      
      
    
    }catch(RemoteException ex){
         Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    catch(NotBoundException ex){
             Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    }
    
    
    }
    
        
        /*****************panel  nav2*********/
        
        
              class HostNvBar implements ActionListener{
     @Override 
    public void actionPerformed(ActionEvent ae){
      try{
        ev.getjPanel3().setVisible(true);
               
        
    MerchInterface MI = (MerchInterface)  r.lookup("Merch");
    
      ev.getjButton2().addActionListener(new HostBtn());
      
      
    
    }catch(RemoteException ex){
         Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    catch(NotBoundException ex){
             Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    }
    
    
    }
    
        
        
        
        
        /**************************/
        
              
               
              class PurchaseNvBar implements ActionListener{
     @Override 
    public void actionPerformed(ActionEvent ae){
      try{
        ev.getjPanel2().setVisible(true);
               
        
    MerchInterface MI = (MerchInterface)  r.lookup("Merch");
    
      ev.getjButton3().addActionListener(new PurchaseBtn());
      
      
    
    }catch(RemoteException ex){
         Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    catch(NotBoundException ex){
             Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    }
    
    
    }
    
}
