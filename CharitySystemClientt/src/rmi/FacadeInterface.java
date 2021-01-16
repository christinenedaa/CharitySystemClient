/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;

/**
 *
 * @author DELL
 */
public interface FacadeInterface {
   
   public void setItemData(int ItemID, int OwnerID, boolean Authorized, double Price, int StockID, String Category)throws RemoteException;
   public String getItemData() throws RemoteException;
   public ItemDTO getItem() throws RemoteException;
}
