/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;
import rmi.*;


public class AuctionguiController {
    AuctionGUI gui;
    Donorgu DG;
    Eventgu ev;
    Registry r;
    
    public AuctionguiController(AuctionGUI gui, Registry r){
    this.gui=gui;
    this.r=r;
    
    gui.getuploaditembutton().addActionListener(new Uploaditembutton());
    gui.getjButton3().addActionListener(new createauction());
    gui.getViewbutton().addActionListener(new viewitems());
    gui.getjButton4().addActionListener(new retrieve());

    }
    
    public AuctionguiController(Donorgu DG,Registry r ){
        this.DG = DG;
        this.r = r;
        
        DG.getjButton2().addActionListener(new Donatemoneybtn());
    }
    
    
    
    public AuctionguiController(Eventgu ev, Registry r) {
        this.ev = ev;
        this.r = r;
//        ev.getjButton4().addActionListener(new ReserveBtn());
//        ev.getjButton6().addActionListener(new HostBtn());
//        ev.getjButton5().addActionListener(new PurchaseBtn());
//        ev.getjButton1().addActionListener(new ReserveBtn());
        ev.getjButton2().addActionListener(new HostBtn());
//        ev.getjButton3().addActionListener(new PurchaseBtn());
    }

    
    
    class Uploaditembutton implements ActionListener{
    @Override 
    public void actionPerformed(ActionEvent ae){
    
    try{
        gui.getUploaditempanel().setVisible(true);
    AuctionInterface AI=(AuctionInterface) r.lookup("Auction");
   
    gui.getSubmitupload().addActionListener(new submitupload());
    
    }catch(RemoteException ex){
         Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    catch(NotBoundException ex){
             Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    
    
    
    }
    
    }
    
      class submitupload implements ActionListener{
     @Override 
    public void actionPerformed(ActionEvent ae){
  try{   
      
      
    AuctionInterface AI=(AuctionInterface) r.lookup("Auction");
    int id=Integer.parseInt(gui.getItemid().getText());
    String mail=gui.getOweremail().getText();
    double startingprice=Double.parseDouble(gui.getjTextField1().getText());
    String state=gui.getAuthenticationstate().getText();
    
    AI.UploadItem(id, mail, startingprice, state);
    
     
    
    }catch(RemoteException ex){
         Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    catch(NotBoundException ex){
             Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    
    }
    
    }
    class createauction implements ActionListener{
     @Override 
    public void actionPerformed(ActionEvent ae){
      try{
        gui.getCreateauctionpanel().setVisible(true);
        
    AuctionInterface AI=(AuctionInterface) r.lookup("Auction");
    
      gui.getjButton2().addActionListener(new submitauction());
      
      
    
    }catch(RemoteException ex){
         Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    catch(NotBoundException ex){
             Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    }
    
    
    }
    
    
    
class submitauction implements ActionListener{
     @Override 
    public void actionPerformed(ActionEvent ae){
  try{   
       Date date=null;
      
    AuctionInterface AI=(AuctionInterface) r.lookup("Auction");
    int id=Integer.parseInt(gui.getItemid1().getText());
    String duration=gui.getDuration().getSelectedItem().toString();
    double startingprice=Double.parseDouble(gui.getjTextField2().getText());
      try {
         date=new SimpleDateFormat("yyyy/MM/dd").parse(gui.getDate().getText());
      } catch (ParseException ex) {
          Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);
      }
      AI.setAuctionID(id);
      AI.setDuration(duration);
      AI.setStartingPrice(startingprice);
      AI.setDate(date);
     
    
    }catch(RemoteException ex){
         Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    catch(NotBoundException ex){
             Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    
    }
}

    class viewitems implements ActionListener{
     @Override 
    public void actionPerformed(ActionEvent ae){
      try{
        gui.getItempanel().setVisible(true);
        
    AuctionInterface AI=(AuctionInterface) r.lookup("Auction");
    
      gui.getSubmitbid().addActionListener(new submitbid());
      
      
    
    }catch(RemoteException ex){
         Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    catch(NotBoundException ex){
             Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    }
    
    
    }
    
 class submitbid implements ActionListener{
  @Override 
    public void actionPerformed(ActionEvent ae){
    try{
    
     AuctionInterface AI=(AuctionInterface) r.lookup("Auction");
    String buyermail=gui.getBuyerid().getText();
    int itemid=Integer.parseInt(gui.getItemid2().getText());
    double bid=Double.parseDouble(gui.getBid().getText());
     AI.BidPrice(buyermail, bid, itemid);
    
    }catch(RemoteException ex){
         Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    catch(NotBoundException ex){
             Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    }
 
 
 }
      class retrieve implements ActionListener{
    @Override 
    public void actionPerformed(ActionEvent ae){
    
    try{
        
     AuctionInterface AI=(AuctionInterface) r.lookup("Auction");
     
     
        MongoClient client = new MongoClient();
    MongoDatabase charity=client.getDatabase("CharityDB");
    MongoCollection collection=charity.getCollection("Auction");
   
        FindIterable<Document> it=collection.find();
        Iterator iter= it.iterator();
        while(iter.hasNext()){
            String n=String.valueOf(iter.next());
            DefaultTableModel model=(DefaultTableModel) gui.getjTable1().getModel();
           
            model.setColumnCount(1);
            model.addRow(new Object[]{n});
        }
        
    }catch(RemoteException ex){
         Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    catch(NotBoundException ex){
             Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }}}
      
    ////////////////////////////////////////////////////////Donor GUI///////////////////////////////////
    class DonationType implements ActionListener{
     @Override 
    public void actionPerformed(ActionEvent ae){
  try{   
      
      DonorInterface DI=(DonorInterface) r.lookup("Donor");
      DG.getjButton1().addActionListener(new DonateItembtn());
      DG.getjButton2().addActionListener(new Donatemoneybtn());
    
    }catch(RemoteException ex){
         Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    catch(NotBoundException ex){
             Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    
    }
    
    }
    

    class DonateItembtn implements ActionListener{
     @Override 
    public void actionPerformed(ActionEvent ae){
  try{   
      DG.getjPanel1().setVisible(true);
      DG.getChooseDonationType().setVisible(false);
      DonorInterface DI=(DonorInterface) r.lookup("Donor");
      
    
    }catch(RemoteException ex){
         Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    catch(NotBoundException ex){
             Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    
    }
    
    }
    
    
    
     
    class Donatemoneybtn implements ActionListener{
    @Override 
    public void actionPerformed(ActionEvent ae){
    
    try{
        DG.getPymentMethodPanel().setVisible(true);
    DonorInterface AI=(DonorInterface) r.lookup("Donor");
   
    //gui.getSubmitupload().addActionListener(new submitupload());
    
    }catch(RemoteException ex){
         Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    catch(NotBoundException ex){
             Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    
    
    
    }
    
    }
    
    
    
    class PayCash implements ActionListener{
     @Override 
    public void actionPerformed(ActionEvent ae){
  try{   
      DG.getPayCash().setVisible(true);
      DonorInterface DI=(DonorInterface) r.lookup("Donor");
      String donorname = DG.getjTextField1().getText();
      String donoremail = DG.getjTextField2().getText();
    
    }catch(RemoteException ex){
         Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    catch(NotBoundException ex){
             Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    
    }
    
    }
    
    
    
    class PayCard implements ActionListener{
     @Override 
    public void actionPerformed(ActionEvent ae){
  try{   
      DG.getjPanel2().setVisible(true);
      DonorInterface DI=(DonorInterface) r.lookup("Donor");
      String donorname = DG.getjTextField5().getText();
      String cardnumber = DG.getjTextField6().getText();
      String cvv = DG.getjTextField7().getText();
      String amount = DG.getjTextField8().getText();
      
    
    }catch(RemoteException ex){
         Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    catch(NotBoundException ex){
             Logger.getLogger(AuctionguiController.class.getName()).log(Level.SEVERE, null, ex);

    }
    
    }
    
    }
    
    
  ///////////////////////////////////////////Event GUI /////////////////////////////////////////////////
    /***************panel 1 **************/
    
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
    
    System.out.println("in");
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
    
        
              
              
        /********************panel 1 nav3*********/
}
    
    
