/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id3u;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

/**
 *
 * @author SARA
 */
public class ManagerInfoGainU {
    
      public static double calc_entropy(String dataSet [][]){
        int classAttribute = 0;
        ArrayList<String> enumValues;        
        double entropy = 0;   
        
        enumValues = ManagerDataSetU.enumerateValues(dataSet, classAttribute);
        Enumeration en = Collections.enumeration(enumValues);
        while(en.hasMoreElements()){
            String v = (String)en.nextElement();
            double occ = ManagerDataSetU.ocurrence(dataSet, v, classAttribute);
            if(occ!=0){
                entropy+= (occ/(dataSet.length-1))*(Math.log1p((dataSet.length-1)/occ)/Math.log1p(2));
            }
        }
        return entropy;
    }
    
    public static double calc_infoGain(String dataSet [][], int A){
        double infoGain = calc_entropy(dataSet);
        ArrayList<String> enumValues;
        
        enumValues = ManagerDataSetU.enumerateValues(dataSet, A);
        Enumeration en = Collections.enumeration(enumValues);   
        
        while(en.hasMoreElements()){
            
            String v = (String) en.nextElement(); 
            //System.out.println("VALUE: "+v);
            //System.out.println("attributo: "+A);
            String v_dataSet [][] = new String[(int)ManagerDataSetU.ocurrence(dataSet, v, A)+1][dataSet[0].length]; //NOTA: corregi porque antes tenia: (int)ManagerDB.ocurrence(dataSet, v, A, numberInstances)
            int v_instance = 1;
            
            System.arraycopy(dataSet[0], 0, v_dataSet[0], 0, dataSet[1].length); 
            
            for(int i=1; i<dataSet.length;i++){
                if(dataSet[i][A].contains(v)){
                    System.arraycopy(dataSet[i], 0, v_dataSet[v_instance], 0, dataSet[i].length);
                    v_instance++;
                    //System.out.println(i);
                }
            }
            //System.out.println("");
            infoGain-=ManagerDataSetU.ocurrence(dataSet, v, A)/(dataSet.length-1)*calc_entropy(v_dataSet);  
        }    
        return infoGain;    
    }
    
}
