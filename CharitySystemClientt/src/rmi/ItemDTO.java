/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class ItemDTO implements Serializable {
    private int itemid;
    private int ownerid;
    
    public ItemDTO(int itemid,int ownerid){
    this.itemid=itemid;
    this.ownerid=ownerid;
    
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
    }
    
    
}
