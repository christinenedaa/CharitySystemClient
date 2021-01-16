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
 * @author DELL
 */
public interface EventInterface extends Remote {
    public void setEventID(int EventID) throws RemoteException ;
    public  void ReserveEvent(String sponsMail,int eventid,String eventName,String eventDate,String location,int req ,boolean state) throws RemoteException;
    
}
