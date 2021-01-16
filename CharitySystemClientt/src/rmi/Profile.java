/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.rmi.RemoteException;
import rmi.LoginGUI;
import Interface.LoginInterface;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author a_h_s
 */
class Profile implements LoginInterface {
    private int ProfileID;
    private String Username;
    private String Password;
      LoginGUI gui;
      MongoClient client = new MongoClient();
   MongoDatabase charity=client.getDatabase("CharityDB");
              MongoCollection profile=charity.getCollection("Profile");
    
    

    public Profile() throws RemoteException {
         this.ProfileID = ProfileID;
        this.Username = Username;
        this.Password = Password;
        
       // Document doc=new Document("Username",Username).append("Password", Password);
    //profile.insertOne(doc);
        
        
        
    }

    public int getProfileID()throws RemoteException  {
        Document d=(Document) profile.find(Filters.all("ProfileID",this.ProfileID)).first();
       
        return ProfileID;
    }

    public String getUsername() throws RemoteException {
          Document d=(Document) profile.find(Filters.all("Username",this.Username)).first();
        return Username;
    }

    public String getPassword()throws RemoteException  {
          Document d=(Document) profile.find(Filters.all("Password",this.Password)).first();
        return Password;
    }

    public void setProfileID(int ProfileID)throws RemoteException  {
        this.ProfileID = ProfileID;
        Document doc=new Document("ProfileID",ProfileID);
        profile.insertOne(doc);
    }

    public void setUsername(String Username)throws RemoteException  {
        this.Username = Username;
        Document doc=new Document("ProfileID",Username);
        profile.insertOne(doc);
    }

    public void setPassword(String Password)throws RemoteException  {
        this.Password = Password;
        Document doc=new Document("ProfileID",Password);
        profile.insertOne(doc);
    }
    
    
    
    
    public void Login(String Username, String Password )  throws RemoteException{
        /*db database = mongoClient.getDB("CharityDB");
        DBCollection collection = database.getCollection("TheCollectionName");
        Document d=(Document) profile.find(Filters.all("Username",this.Username)).first();
        Profile result = db.gson.fromJson(d.toJson(), Profile.class);*/
        DBObject result = new mongoClient().getDb("CharityDB").getCollection("Profile").findOne(new BasicDBObject("Username",this.Username), new BasicDBObject("Password",this.Password));
        if(result.Password.equals(Password))
        {
             System.out.println("you can enter now");
              ProfileGui pg = new  ProfileGui();
            pg.setVisible(true);
           // this.setVisible(true);
            // this.setVisible(false);
                pg.pack();
                pg.setLocationRelativeTo(null);
                
                //this.dispose();
        }
        else
             System.out.println("try again");
    
    
    }
   
   public void Sign(String Username, String Password)throws RemoteException{
    this.Username = Username;
    this.Password = Password;
    
   Document doc= new Document("Username",this.Username).append("Password", this.Password);;
   profile.insertOne(doc);
   System.out.println("Successful Registration, you can login now");
        
        
   
    }
                
                
                
            
        
    

    @Override
    public String getUsername(String e) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPassword(String p) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int isValid(int v) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*private static class LoginBtnAction implements ActionListener {

        public LoginBtnAction() {
        }
    }*/

    @Override
    public String Login(String Username, String Password) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    }
    

    
    
    
    
    
    
    

    
    
    
    
    
    
    
    
    
   

    