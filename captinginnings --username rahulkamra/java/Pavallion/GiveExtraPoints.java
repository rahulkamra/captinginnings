/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Pavallion;

import java.math.RoundingMode;
import java.util.Random;

/**
 *
 * @author Owner
 */
public class GiveExtraPoints {

    public boolean getxtraPoints(){
        Random temp_random = new Random();
        int random_flag = temp_random.nextInt(3);
        if(random_flag==0){
            return true;
        }else{
            return false;
        }
        
    }
    
    /*public static void main(String[] args) {
        GiveExtraPoints temp=new GiveExtraPoints();
        int count=0;
        for(int i=100;i<110;i++){
            System.out.println(temp.getxtraPoints());
            if(temp.getxtraPoints()){
                count++;
            }
        }
        System.out.println(count);
    }*/
}
