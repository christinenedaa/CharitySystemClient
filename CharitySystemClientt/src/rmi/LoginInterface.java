/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 *
 * @author Shrouk
 */
public interface LoginInterface extends Remote {
    public int getProfileID()throws RemoteException;
    public String getUsername() throws RemoteException ;
       public String getPassword(String p) throws RemoteException;
      public void setProfileID(int ProfileID)throws RemoteException;
     public String getUsername(String e) throws RemoteException;
    public int isValid(int v) throws RemoteException ;
public void setPassword(String Password)throws RemoteException;

public boolean Login(String Username, String Password )  throws RemoteException;
    void Sign(String Username, String Password )  throws RemoteException;
}