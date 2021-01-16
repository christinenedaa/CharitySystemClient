/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 *
 * @author Shrouk
 */
public interface LoginInterface extends Remote {
    public int getProfileID()throws RemoteException;
    public String getUsername() throws RemoteException ;
     public String getPassword()throws RemoteException;
      public void setProfileID(int ProfileID)throws RemoteException;
      public void setUsername(String Username)throws RemoteException ;
    
public void setPassword(String Password)throws RemoteException;

  void Login(String Username, String Password )  throws RemoteException;
    void Sign(String Username, String Password )  throws RemoteException;
}