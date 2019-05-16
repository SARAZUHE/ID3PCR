/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id3u;

import Tree.DecisionTree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

/**
 *
 * @author SARA
 */
public class Id3U {
    public static DecisionTree decisionTreeLearner(String [][] dataSet, String [][] p_dataSet, String assegnation) throws Exception {
        
        if(dataSet.length == 0){
            //System.out.println("Entro condicion 1");
            return new DecisionTree(ManagerDataSetU.majorityElement(p_dataSet, 0),assegnation);
        }
        if(ManagerDataSetU.sameClass(dataSet)){
            //System.out.println("entro condicion 2");
            return new DecisionTree(dataSet[1][0],assegnation);
        }
        if(dataSet[1].length==1){
            //System.out.println("entro a condicion 3");
            return new DecisionTree(ManagerDataSetU.majorityElement(dataSet, 0),assegnation);
        }       
        
        
        //System.out.println("Entro condicion 4");

        
        
        Attribute A = Id3U.selectAttribute(dataSet); 
        
        int attr = A.getIndex();
        
        DecisionTree tree = new DecisionTree(A,assegnation);
        
        Enumeration values = Collections.enumeration(ManagerDataSetU.enumerateValues(dataSet,attr));
        
               
       
              
        while(values.hasMoreElements()){

            String value = (String) values.nextElement();
            String v_dataSet [][] = new String[(int)ManagerDataSetU.ocurrence(dataSet, value, attr)+1][dataSet[0].length]; //NOTA: corregi porque antes tenia: (int)ManagerDB.ocurrence(dataSet, v, A, numberInstances)
            int v_instance = 1;
            
            System.arraycopy(dataSet[0], 0, v_dataSet[0], 0, dataSet[0].length);           
            for(int i=1; i<dataSet.length;i++){
                if(dataSet[i][attr].equals(value)){                     
                    System.arraycopy(dataSet[i], 0, v_dataSet[v_instance], 0, dataSet[i].length);
                    v_instance++;
                }
            } 
            //v_dataSet = ManagerDataSetU.remove(v_dataSet, attr);
     
            System.out.println("Attributo: "+A.getAttributeDBO()+" value: "+value+" size: "+(v_dataSet.length-1) );
            tree.setChild(decisionTreeLearner(v_dataSet,dataSet,value),tree);              
        }        
        return tree;       
    }
    

    public static Attribute selectAttribute(String dataSet [][]) throws Exception{
	
        Attribute selectedAttribute = new Attribute();
        int A, aux;        
        double gain, maxGain;        
        A = 1;
        aux =  1 ;
        
        gain = ManagerInfoGainU.calc_infoGain(dataSet,A);        
        maxGain= gain;  
        
        for(int j=1;j<dataSet[0].length;j++){   
            A=j;
            gain = ManagerInfoGainU.calc_infoGain(dataSet, A);
           
            //System.out.println("Attributo "+j+" Gain: "+gain);
            
            if(gain>maxGain){                
                maxGain = gain;  
                aux=j;               
            }           
        }
        selectedAttribute.setIndex(aux); 
        selectedAttribute.setAttributeBDO(dataSet[0][aux]);
               
        return selectedAttribute;    
	}
    
    
}
