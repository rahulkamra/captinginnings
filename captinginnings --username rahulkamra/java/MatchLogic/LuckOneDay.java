/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MatchLogic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Owner
 */
public class LuckOneDay {

    public Map giveLuckOneDay(Map totalRuns) {
        System.out.println(totalRuns.size());
        Set keySet = totalRuns.keySet();
        System.out.println(keySet.size() + "I m key Set");
        Iterator it_keySet = keySet.iterator();
        int sum=0;
        Map returnMap=new HashMap();
        while (it_keySet.hasNext()) {
            String name = (String) it_keySet.next();
            Integer runs = (Integer) totalRuns.get(name);
           int final_runs=logicLuckOneDay(runs);
           returnMap.put(name,final_runs);
          
           /*totalRuns.put(name,final_runs);*/
           sum=sum+final_runs;
            
        }
        System.out.println(sum);
        return returnMap;

    }

    /** Luck runs are positive if number is less than 1000
     *  
     *
     * 
     */
    public int logicLuckOneDay(Integer runs) {

        Random random = new Random();

        int iRandom = random.nextInt(2000) + 1;

        int luck_runs = 0;

        luck_runs = 0;
        if (iRandom > 0 && iRandom <= 50) {     //Random number is  between 1 nad 50
            luck_runs = luck_runs + 1;
        } else if (iRandom > 50 && iRandom <= 100) {
            luck_runs = luck_runs + 2;
        } else if (iRandom > 100 && iRandom <= 200) {
            luck_runs = luck_runs + 3;
        } else if (iRandom > 200 && iRandom <= 500) {
            luck_runs = luck_runs + 4;
        } else if (iRandom > 500 && iRandom <= 900) {
            luck_runs = luck_runs + 5;
        } else if (iRandom > 900 && iRandom <= 989) {
            luck_runs = luck_runs + 6;
        } else if (iRandom > 989 && iRandom <= 999) {
            luck_runs = luck_runs + 10;
        } else if (iRandom == 1000) {
            luck_runs = luck_runs + 50;
        } else if (iRandom > 1000 && iRandom <= 1050) {
            luck_runs = luck_runs - 1;
        } else if (iRandom > 1050 && iRandom <= 1100) {
            luck_runs = luck_runs - 2;
        } else if (iRandom > 1100 && iRandom <= 1200) {
            luck_runs = luck_runs - 3;
        } else if (iRandom > 1200 && iRandom <= 1500) {
            luck_runs = luck_runs - 4;
        } else if (iRandom > 1500 && iRandom <= 1900) {
            luck_runs = luck_runs - 5;
        } else if (iRandom > 1900 && iRandom <= 1989) {
            luck_runs = luck_runs - 6;
        } else if (iRandom > 1989 && iRandom <= 1999) {
            luck_runs = luck_runs - 10;
        } else if (iRandom == 2000) {
            luck_runs = luck_runs - 50;
        }

        runs = runs + luck_runs;
        if (runs < 0) {
            runs = 0;
        }
        return runs;
    }

    public static void main(String[] args) {
        LuckOneDay temp = new LuckOneDay();
        int i=10;
        while(i>0){
        System.out.println(temp.logicLuckOneDay(10));
        i--;
        }
    }
}
