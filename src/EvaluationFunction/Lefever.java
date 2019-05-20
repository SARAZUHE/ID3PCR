/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvaluationFunction;

import java.util.ArrayList;

/**
 *
 * @author SARA
 */
public class Lefever {
    
    private ArrayList<Double> lefeverR = new ArrayList<>();
    private ArrayList<Double> lefeverL = new ArrayList<>();
    private int mWindowSize, mA, mDataSetLength;
    private double lefValueZero     = 0.687;  
    private double lefValueOne      = 0.057;
    private double lefValueTwo      = 0.031;
    private double lefValueThree    = 0.016;
    private double lefValueFour     = 0.012;
    private double lefValueInfinite = 0.014;
    
    public Lefever(int windowSize, int A, int dataSetLength){
        this.mWindowSize = windowSize;
        this.mA = A;
        this.mDataSetLength = dataSetLength;
    }
    
    //Mi vida: Cambiar dataSetLength al objeto, no se te olvide ;)
    public ArrayList initLefeverR(int windowSize, int A, int dataSetLength){
      
        //Izquierda
        int pivot = A-1;
        int index = 0;
        while (pivot >= 0 && index < windowSize) {
            switch (index) {
                case 0:
                    lefeverL.add(lefValueOne);
                    break;
                case 1:
                    lefeverL.add(lefValueTwo);
                    break;
                case 2:
                    lefeverL.add(lefValueThree);
                    break;
                case 3:            
                    lefeverL.add(lefValueFour);
                    break;
                default:
                    lefeverL.add(lefValueInfinite);
                    break;
            }
                        
            index++;
            pivot--;
        }
  
        //Derecha
        pivot = A;
        index = 0;
        while (pivot <= dataSetLength && index <= windowSize) {
            switch (index) {
                case 0:
                    lefeverR.add(lefValueZero);
                    break;
                case 1:
                    lefeverR.add(lefValueOne);
                    break;
                case 2:
                    lefeverR.add(lefValueTwo);
                    break;
                case 3:
                    lefeverR.add(lefValueThree);
                    break;            
                case 4:
                    lefeverR.add(lefValueFour);
                    break;
                default:
                    lefeverR.add(lefValueInfinite);
                    break;
            }
                        
            index++;
            pivot++;
        }
        
        int i = 0;               
        
        for (Double ob: lefeverL) {
                        
            System.out.println("Index -" + (i + 1) + ": " + ob);
            i++;
            
        }
        
        i = 0;
        System.out.println("===================================");        
        
        for (Double ob: lefeverR) {
                        
            System.out.println("Index " + i + ": " + ob);
            i++;
            
        }
            
        return lefeverR;
    }
    
    
    
    public double getWR(int i){
        double w;
        w=lefeverR.get(i);
    
        return w;
    }
    
    
    
}
