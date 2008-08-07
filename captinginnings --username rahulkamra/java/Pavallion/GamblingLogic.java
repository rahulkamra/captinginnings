/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Pavallion;

import java.util.Random;

/**
 *
 * @author Owner
 */
public class GamblingLogic {

    public boolean doGambling(){
        Random temp_random = new Random();
        int random_flag = temp_random.nextInt(5);
        if(random_flag==0 ||random_flag==1){
            return true;
        }else{
            return false;
        }
    }
    /*public static void main(String[] args) {
        GamblingLogic temp=new GamblingLogic();
        int count=0;
        for(int i=0;i<100;i++){
            System.out.println(temp.doGambling());
            if(temp.doGambling()){
                count++;
            }
        }
        System.out.println(count);
    }*/
}
