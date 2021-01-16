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
public interface MerchInterface extends Remote {
    public void HostMerch(String smail , String merchname , int Id) throws RemoteException;
    public void PurchaseItem(int itemid , String buyerMail) throws RemoteException;
}
