/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface DonorInterface extends Remote {
    public void setPreviousDonations(ArrayList<String> PreviousDonations) throws RemoteException;
    public void setDonatedAmount(double DonatedAmount) throws RemoteException;
    public void setType(String Type) throws RemoteException;
    public void setQuantity(int Quantity) throws RemoteException;
    public ArrayList<String> getPreviousDonations() throws RemoteException;
    public double getDonatedAmount() throws RemoteException;
    public String getType() throws RemoteException;
    public int getQuantity() throws RemoteException;
    public void PayDonation(PaymentBehaviour paymethod)throws RemoteException;
    public void DonateItem(int itemID, String category)throws RemoteException;
}
