/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvaluationFunction;

import id3u.ManagerDataSetU;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

/**
 *
 * @author SARA
 */
public class ManagerParametersPCR {
    
    
     
    
    public static double evaluationWindow(String [][] dataSet, int A, int windowSize){
        
        double evaluation;
        double entropy;
        double lef;
        
        evaluation = 0;// por corregir 
        entropy=0;
        lef = 0;
        Lefever lefever = new Lefever();  
        //lefever.initLefeverR(windowSize);
        int j=0;
        int tope = A+windowSize;
        for(int i=A; i<=tope; i++){
            A=i; 
            evaluation += calc_entropyAttribute(dataSet,A)*lefever.getWR(j);
            j++;
            System.out.println("evaluacion: "+ evaluation);   
        }     
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
