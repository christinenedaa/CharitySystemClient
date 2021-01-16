/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author DELL
 */
public interface AuctionInterface extends Remote{
     public String UploadItem(int itemid, String ownermail, double startingprice,String auctionstate)throws RemoteException;
    public double BidPrice(String buyermail, double price, int itemid) throws RemoteException;
    public double getFinalPrice()throws RemoteException;
    public void setVAT(double VAT)throws RemoteException ;
    public int getAuctionID() throws RemoteException;
    public Date getDate() throws RemoteException;
     public String getDuration() throws RemoteException ;
     public String getSeller() throws RemoteException;
     public String getBidder() throws RemoteException;
         public String getFinalBuyer() throws RemoteException;
         public double getStartingPrice() throws RemoteException;
         public boolean isAuthoriezedItem()throws RemoteException;
         public double getCurrentBidPrice()throws RemoteException;
         public String getAuctionState()throws RemoteException;
         public double getVAT()throws RemoteException;
         public void setAuctionID(int AuctionID)throws RemoteException;
         public void setDate(Date Date)throws RemoteException;
         public void setDuration(String Duration) throws RemoteException;
         public void setSeller(String Sellermail) throws RemoteException;
         
         public void setFinalBuyer(String FinalBuyer) throws RemoteException;
         public void setStartingPrice(double StartingPrice)throws RemoteException;
         public void setFinalPrice(double FinalPrice)throws RemoteException;
         public void setAuthoriezedItem(boolean AuthoriezedItem)throws RemoteException ;
         public void setCurrentBidPrice(double CurrentBidPrice) throws RemoteException;
         public void setAuctionState(String AuctionState)throws RemoteException;
        
         public void creatdoc(int id,String d,String a) throws RemoteException;
          public int getHostedItem() throws RemoteException;
}
