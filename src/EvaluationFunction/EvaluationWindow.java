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
public class EvaluationWindow {
    private static ArrayList<Double> lefeverR = new ArrayList<>();
    private static ArrayList<Double> lefeverL = new ArrayList<>();

    private static  double lefValueZero     = 0.687;  
    private static double lefValueOne      = 0.057;
    private static double lefValueTwo      = 0.031;
    private static double lefValueThree    = 0.016;
    private static double lefValueFour     = 0.012;
    private static double lefValueInfinite = 0.014;
    private static double sum;


     
    

    

    public static double evaluationA(String [][] dataSet, int A, int windowSize){
        
        
      
        //Izquierda
        int pivotL = A-1;
        int index = 0;
        double evaluation =0;
        while (pivotL > 0 && index < windowSize) {
            switch (index) {
                case 0:                    
                    evaluation = calc_entropyAttribute(dataSet, pivotL)*lefValueOne;
                    lefeverL.add(evaluation);
                    break;
                case 1:
                    evaluation = calc_entropyAttribute(dataSet, pivotL)*lefValueTwo;
                    lefeverL.add(evaluation);
                    break;
                case 2:
                    evaluation = calc_entropyAttribute(dataSet, pivotL)*lefValueThree;
                    lefeverL.add(evaluation);
                    break;
                case 3:            
                    evaluation = calc_entropyAttribute(dataSet, pivotL)*lefValueFour;
                    lefeverL.add(evaluation);
                    break;
                default:
                    evaluation = calc_entropyAttribute(dataSet, pivotL)*lefValueInfinite;
                    lefeverL.add(evaluation);
                    break;
            }                        
            index++;
            pivotL--;
        }
  
        //Derecha
        int pivotR = A;
        index = 0;
        evaluation =0;
        while (pivotR < dataSet[0].length && index <= windowSize) {
            switch (index) {
                case 0:
                    evaluation = calc_entropyAttribute(dataSet, pivotR)*lefValueZero;
                    lefeverR.add(evaluation);                   
                    break;
                case 1:
                    evaluation = calc_entropyAttribute(dataSet, pivotR)*lefValueOne;
                    lefeverR.add(evaluation); 
                    break;
                case 2:
                    evaluation = calc_entropyAttribute(dataSet, pivotR)*lefValueTwo;
                    lefeverR.add(evaluation); 
                    break;
                case 3:
                    evaluation = calc_entropyAttribute(dataSet, pivotR)*lefValueThree;
                    lefeverR.add(evaluation); 
                    break;            
                case 4:
                    evaluation = calc_entropyAttribute(dataSet, pivotR)*lefValueFour;
                    lefeverR.add(evaluation); 
                    break;
                default:
                    evaluation = calc_entropyAttribute(dataSet, pivotR)*lefValueInfinite;
                    lefeverR.add(evaluation); 
                    break;
            }                        
            index++;
            pivotR++;
        }      
        
        lefeverL.addAll(lefeverR);
        

        sum =0;
        for (Double ob: lefeverL) {    
            
            sum += ob;      
            
        }       

        //System.out.println("evaluacion de la ventana:" + sum);
        
        lefeverL.clear();
        lefeverR.clear();
        
            
        return sum;
    }
       
    
    private static double calc_entropyAttribute(String dataSet [][], int A){
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
