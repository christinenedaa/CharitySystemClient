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
import rmi.AuctionInterface;
import rmi.AuctionGUI;
import rmi.DonorGUI;


public class AuctionguiController {
    AuctionGUI gui;
    DonorGUI DG;
    Registry r;
    
    public AuctionguiController(AuctionGUI gui, Registry r){
    this.gui=gui;
    this.r=r;
    
    gui.getuploaditembutton().addActionListener(new Uploaditembutton());
    gui.getjButton3().addActionListener(new createauction());
    gui.getViewbutton().addActionListener(new viewitems());
    gui.getjButton4().addActionListener(new retrieve());

    }
    
    public AuctionguiController(DonorGUI DG,Registry r ){
        this.DG = DG;
        this.r = r;
        
        
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

}
    
    
