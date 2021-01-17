package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Shrouk
 */
public interface Vinterface extends Remote {
    public void Updatedata( String name, String Email, String skills, String level,String interest, String experience )throws RemoteException;
    public void SendRequest() throws RemoteException;
    public void update(Object o, boolean status)throws RemoteException;
}
