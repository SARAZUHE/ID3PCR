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
    

    public ArrayList initLefever(){
      
        //Izquierda
        int pivot = mA-1;
        int index = 0;
        while (pivot > 0 && index < mWindowSize) {
            switch (index) {
                case 0:
                    lefeverL.add(lefValueOne);
                    System.out.println(pivot);
                    break;
                case 1:
                    lefeverL.add(lefValueTwo);
                    System.out.println(pivot);
                    break;
                case 2:
                    lefeverL.add(lefValueThree);
                    System.out.println(pivot);
                    break;
                case 3:            
                    lefeverL.add(lefValueFour);
                    System.out.println(pivot);
                    break;
                default:
                    lefeverL.add(lefValueInfinite);
                    System.out.println(pivot);
                    break;
            }
                        
            index++;
            pivot--;
        }
  
        //Derecha
        pivot = mA;
        index = 0;
        while (pivot < mDataSetLength && index <= mWindowSize) {
            switch (index) {
                case 0:
                    lefeverR.add(lefValueZero);
                    System.out.println(pivot);
                    break;
                case 1:
                    lefeverR.add(lefValueOne);
                    System.out.println(pivot);                    
                    break;
                case 2:
                    lefeverR.add(lefValueTwo);
                    System.out.println(pivot);
                    break;
                case 3:
                    lefeverR.add(lefValueThree);
                    System.out.println(pivot);
                    break;            
                case 4:
                    lefeverR.add(lefValueFour);
                    System.out.println(pivot);
                    break;
                default:
                    lefeverR.add(lefValueInfinite);
                    System.out.println(pivot);
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
    
    }
