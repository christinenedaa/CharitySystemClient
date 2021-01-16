/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;

/**
 *
 * @author DELL
 */
public interface PaymentBehaviour extends Remote{
    public void paymentMethod(double Amount); 
}
