/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id3u;

/**
 *
 * @author SARA
 */
public class Attribute {
    private int v_Index;
    private String attrDBO;  
    
    
    public Attribute(){
    
    }
            
    
    public void setIndex(int v_Index){
        this.v_Index=v_Index;
         
    }
    public void setAttributeBDO(String attrBDO){
        this.attrDBO=attrBDO;  
    }
    
    
    public int getIndex(){
    
        return v_Index;
    }
    
    public String getAttributeDBO(){
        return attrDBO;
    }
    
}
