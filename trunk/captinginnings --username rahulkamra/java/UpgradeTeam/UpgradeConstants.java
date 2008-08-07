/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UpgradeTeam;

/**
 *
 * @author Owner
 */
public class UpgradeConstants {

    private static final int _CoachLvl1 = 2000;
    private static final int _CoachLvl2 = 4000;
    private static final int _CoachLvl3 = 8000;
    private static final int _CoachLvl4 = 12000;
    private static final int _CoachLvl5 = 24000;
    private static final int _CoachLvl6 = 48000;
    private static final int _CoachLvl7 = 96000;
    private static final int _CoachLvl8 = 192000;
    private static final int _CoachLvl9 = 284000;
    private static final int _CoachLvl10 = 568000;   
    
    //
    private static final int _BatsmanLvl1 = 1000;
    private static final int _BatsmanLvl2 = 2000;
    private static final int _BatsmanLvl3 = 4000;
    private static final int _BatsmanLvl4 = 8000;
    private static final int _BatsmanLvl5 = 14000;
    private static final int _BatsmanLvl6 = 28000;
    private static final int _BatsmanLvl7 = 50000;
    private static final int _BatsmanLvl8 = 100000;
    private static final int _BatsmanLvl9 = 200000;
    private static final int _BatsmanLvl10 = 350000;  
    
    //
    private static final int _BowlerLvl1 = 1000;
    private static final int _BowlerLvl2 = 2000;
    private static final int _BowlerLvl3 = 4000;
    private static final int _BowlerLvl4 = 8000;
    private static final int _BowlerLvl5 = 14000;
    private static final int _BowlerLvl6 = 28000;
    private static final int _BowlerLvl7 = 50000;
    private static final int _BowlerLvl8 = 100000;
    private static final int _BowlerLvl9 = 200000;
    private static final int _BowlerLvl10 = 350000;    //
    
    //
    private static final int _StrategyLvl1 = 500;
    private static final int _StrategyLvl2 = 1000;
    private static final int _StrategyLvl3 = 2000;
    private static final int _StrategyLvl4 = 4000;
    private static final int _StrategyLvl5 = 8000;
    private static final int _StrategyLvl6 = 16000;
    private static final int _StrategyLvl7 = 32000;
    private static final int _StrategyLvl8 = 500000;
    private static final int _StrategyLvl9 = 100000;
    private static final int _StrategyLvl10 = 200000;

    public int getMoney(String variable, int level) {
        if (variable.equals("strategy")) {
            switch (level) {
                case 1:
                    return _StrategyLvl1;
                case 2:
                    return _StrategyLvl2;
                case 3:
                    return _StrategyLvl3;
                case 4:
                    return _StrategyLvl4;
                case 5:
                    return _StrategyLvl5;
                case 6:
                    return _StrategyLvl6;
                case 7:
                    return _StrategyLvl7;
                case 8:
                    return _StrategyLvl8;
                case 9:
                    return _StrategyLvl9;
                case 10:
                    return _StrategyLvl10;
            }
        }
        if (variable.equals("coach")) {
            switch (level) {
                case 1:
                    return _CoachLvl1;
                case 2:
                    return _CoachLvl2;
                case 3:
                    return _CoachLvl3;
                case 4:
                    return _CoachLvl4;
                case 5:
                    return _CoachLvl5;
                case 6:
                    return _CoachLvl6;
                case 7:
                    return _CoachLvl7;
                case 8:
                    return _CoachLvl8;
                case 9:
                    return _CoachLvl9;
                case 10:
                    return _CoachLvl10;
            }
        }
        if (variable.equals("batting")) {
            switch (level) {
                case 1:
                    return _BatsmanLvl1;
                case 2:
                    return _BatsmanLvl2;
                case 3:
                    return _BatsmanLvl3;
                case 4:
                    return _BatsmanLvl4;
                case 5:
                    return _BatsmanLvl5;
                case 6:
                    return _BatsmanLvl6;
                case 7:
                    return _BatsmanLvl7;
                case 8:
                    return _BatsmanLvl8;
                case 9:
                    return _BatsmanLvl9;
                case 10:
                    return _BatsmanLvl10;
            }
        }
        if (variable.equals("bowling")) {
            switch (level) {
                case 1:
                    return _BowlerLvl1;
                case 2:
                    return _BowlerLvl2;
                case 3:
                    return _BowlerLvl3;
                case 4:
                    return _BowlerLvl4;
                case 5:
                    return _BowlerLvl5;
                case 6:
                    return _BowlerLvl6;
                case 7:
                    return _BowlerLvl7;
                case 8:
                    return _BowlerLvl8;
                case 9:
                    return _BowlerLvl9;
                case 10:
                    return _BowlerLvl10;
            }
        }


        return 0;
    }
    /* public static void main(String[] args) {
    UpgradeConstants temp=new UpgradeConstants();
    int x=temp.getMoney("coach",1);
    System.out.println(x);
    }*/
}
