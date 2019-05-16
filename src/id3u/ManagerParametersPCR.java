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
public class ManagerParametersPCR {
    
    
    private ArrayList<Double> reference;
    
    
    
    
    public static double evaluationWindow(String [][] dataSet, int A, int windowSize){
        
        double evaluation;
        evaluation = A;// por corregir 
        
        
        
        
        
        
        return evaluation;
    }
    
    public static double calc_entropyAttribute(String dataSet [][], int A){
        ArrayList<String> enumValues;        
        double entropy = 0;   
        
        enumValues = ManagerDataSetU.enumerateValues(dataSet, A);
        Enumeration en = Collections.enumeration(enumValues);
        while(en.hasMoreElements()){
            String v = (String)en.nextElement();
            double occ = ManagerDataSetU.ocurrence(dataSet, v, A);
            if(occ!=0){
                entropy+= (occ/(dataSet.length-1))*(Math.log1p((dataSet.length-1)/occ)/Math.log1p(2));
            }
        }
        return entropy;
    }
    
    
    
    
    
    
    
}
