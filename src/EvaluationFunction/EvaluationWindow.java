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
    private ArrayList<Double> lefeverR = new ArrayList<>();
    private ArrayList<Double> lefeverL = new ArrayList<>();
    private int mWindowSize, mA;
    private double lefValueZero     = 0.687;  
    private double lefValueOne      = 0.057;
    private double lefValueTwo      = 0.031;
    private double lefValueThree    = 0.016;
    private double lefValueFour     = 0.012;
    private double lefValueInfinite = 0.014;
    private String mDataSet [][];

     
    
    public EvaluationWindow(String [][] dataSet, int A, int windowSize){
        this.mDataSet = dataSet;
        this.mWindowSize = windowSize;
        this.mA = A;
    }
    

    public double evaluationA(){
        
        double sum =0;
      
        //Izquierda
        int pivot = mA-1;
        int index = 0;
        double evaluation =0;
        while (pivot >= 0 && index < mWindowSize) {
            switch (index) {
                case 0:                    
                    evaluation = calc_entropyAttribute(mDataSet, pivot)*lefValueOne;
                    lefeverL.add(evaluation);
                    break;
                case 1:
                    evaluation = calc_entropyAttribute(mDataSet, pivot)*lefValueTwo;
                    lefeverL.add(evaluation);
                    break;
                case 2:
                    evaluation = calc_entropyAttribute(mDataSet, pivot)*lefValueThree;
                    lefeverL.add(evaluation);
                    break;
                case 3:            
                    evaluation = calc_entropyAttribute(mDataSet, pivot)*lefValueFour;
                    lefeverL.add(evaluation);
                    break;
                default:
                    evaluation = calc_entropyAttribute(mDataSet, pivot)*lefValueInfinite;
                    lefeverL.add(evaluation);
                    break;
            }                        
            index++;
            pivot--;
        }
  
        //Derecha
        pivot = mA;
        index = 0;
        evaluation =0;
        while (pivot <= mDataSet[0].length && index <= mWindowSize) {
            switch (index) {
                case 0:
                    evaluation = calc_entropyAttribute(mDataSet, pivot)*lefValueZero;
                    lefeverR.add(evaluation);                   
                    break;
                case 1:
                    evaluation = calc_entropyAttribute(mDataSet, pivot)*lefValueOne;
                    lefeverR.add(evaluation); 
                    break;
                case 2:
                    evaluation = calc_entropyAttribute(mDataSet, pivot)*lefValueTwo;
                    lefeverR.add(evaluation); 
                    break;
                case 3:
                    evaluation = calc_entropyAttribute(mDataSet, pivot)*lefValueThree;
                    lefeverR.add(evaluation); 
                    break;            
                case 4:
                    evaluation = calc_entropyAttribute(mDataSet, pivot)*lefValueFour;
                    lefeverR.add(evaluation); 
                    break;
                default:
                    evaluation = calc_entropyAttribute(mDataSet, pivot)*lefValueInfinite;
                    lefeverR.add(evaluation); 
                    break;
            }                        
            index++;
            pivot++;
        }      
        
        lefeverL.addAll(lefeverR);
        
        int i = 0;
       
        for (Double ob: lefeverL) {    
            
            sum += ob;      
            
        }       

        System.out.println("evaluacion de la ventana:" + sum);
        
            
        return sum;
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
