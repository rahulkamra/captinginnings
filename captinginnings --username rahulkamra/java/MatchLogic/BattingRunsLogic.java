/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MatchLogic;

import Pavallion.AllDetailsBean;
import Team.TeamInterface;
import TeamRegistration.TeamRegistrationForm;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Owner
 */
public class BattingRunsLogic {

    /**Opponent team bowling differ when different team is playing 
     *  
     * Slogger         Strong Against Offspinner  || Weak Against Fast
     * Strike Rotator  Strong Against Fast Medium || Weak Against Chinaman
     * Driver          Strong Against LegSpinner  || Weak Against OffSpinner
     * Puller          Strong Against Fast        || Weak Against LegSpinner
     * Cutter          Strong Against Chinaman    || Weak Against Fast Medium
     * 
     * Strong are Strong by a factor of 100+x\6 where x is the bowling factor 
     * in which they r strong
     * 
     * 
     * 
     * Minimum weakness factor 10
     * 
     * 
     */
 

    public Map battingRuns(AllDetailsBean alldetails, Map opponent_team_bowling, AllDetailsBean opponent_details,TeamRegistrationForm complete_details) {
        Set my_team = alldetails.getTeamlist();
        Iterator it_my_team = my_team.iterator();
        Map totalRuns = new HashMap();
        TeamInterface teamInterface;
        //
        int offspinner = Integer.parseInt(opponent_team_bowling.get("offspinner").toString());
        int chinaman = Integer.parseInt(opponent_team_bowling.get("chinaman").toString());
        int fast = Integer.parseInt(opponent_team_bowling.get("fast").toString());
        int legspinner = Integer.parseInt(opponent_team_bowling.get("legspinner").toString());
        int medium = Integer.parseInt(opponent_team_bowling.get("medium").toString());
        int total_bowling = offspinner + chinaman + fast + legspinner + medium;

        //If a Player is weak against a particular attack then reduction factor will taken
        //into account
        int offspinner_reductionFactor = CalculateReductionFactor(offspinner);
        int chinaman_reductionFactor = CalculateReductionFactor(chinaman);
        int fast_reductionFactor = CalculateReductionFactor(fast);
        int legspinner_reductionFactor = CalculateReductionFactor(legspinner);
        int medium_reductionFactor = CalculateReductionFactor(medium);

        //If a player is strong then this factor is taken
        int offspinner_elevationFactor = CalculateElevationFactor(offspinner, total_bowling);
        int chinaman_elevationFactor = CalculateElevationFactor(chinaman, total_bowling);
        int fast_elevationFactor = CalculateElevationFactor(fast, total_bowling);
        int legspinner_elevationFactor = CalculateElevationFactor(legspinner, total_bowling);
        int medium_elevationFactor = CalculateElevationFactor(medium, total_bowling);
        //
          
        //
        int sloggerFactor = (offspinner_elevationFactor - fast_reductionFactor + 100)+endFactorBatsmanBoost(fast);
        int strikeRotatorFactor = (medium_elevationFactor - chinaman_reductionFactor + 100)+endFactorBatsmanBoost(chinaman);
        int driverFactor = (legspinner_elevationFactor - offspinner_reductionFactor + 100)+endFactorBatsmanBoost(offspinner);
        int pulleFactor = (fast_elevationFactor - legspinner_reductionFactor) + 100 +endFactorBatsmanBoost(legspinner);
        int cutterFactor = (chinaman_elevationFactor - medium_reductionFactor + 100)+endFactorBatsmanBoost(medium);
        //

        //
        System.out.println(offspinner_reductionFactor + "one" + chinaman_reductionFactor + "two" + fast_reductionFactor + "three");
        System.out.println(legspinner_reductionFactor + "four" + medium_reductionFactor);
        System.out.println("Eone" + offspinner_elevationFactor + "ETwo" + chinaman_elevationFactor + "three" + fast_elevationFactor);
        System.out.println(legspinner_elevationFactor + "Efour" + medium_elevationFactor);
        //

        float temp_totalruns = 0;
        while (it_my_team.hasNext()) {

            Map complete_details_map = complete_details.getPlayerdetails();
            teamInterface = (TeamInterface) complete_details_map.get(it_my_team.next());
            int slogger = teamInterface.getSlogger();
            int strikerotator = teamInterface.getStrike_rotator();
            int driver = teamInterface.getDriver();
            int puller = teamInterface.getPuller();
            int cutter = teamInterface.getCutter();
            float sloggerRuns = slogger * sloggerFactor ;
            float strikeRotatorRuns = strikerotator * strikeRotatorFactor;
            float driverRuns = driver * driverFactor;
            float pullerRuns = puller * pulleFactor;
            float cutterRuns = cutter * cutterFactor;
            float f_currentTotalPlayerRuns = ((sloggerRuns + strikeRotatorRuns + driverRuns + pullerRuns + cutterRuns)*2)/1000;
            //Rounding off
            int currentTotalPlayerRuns=Math.round(f_currentTotalPlayerRuns);
            //
            totalRuns.put(teamInterface.getPlayername(),currentTotalPlayerRuns);
            temp_totalruns = currentTotalPlayerRuns + temp_totalruns;
            System.out.println(currentTotalPlayerRuns + "" + teamInterface.getPlayername());
        }
       float f_extraRuns=(temp_totalruns*alldetails.getCoach_level()*2)/100+(temp_totalruns*alldetails.getExtra_batting_points()*2)/100;
       int extraRuns=Math.round(f_extraRuns);
        totalRuns.put("extra",extraRuns);
        System.out.println(extraRuns);
                
        System.out.println(temp_totalruns+extraRuns + "I m total" +alldetails.getCoach_level());
        //  
        return totalRuns;
    }

    public int CalculateReductionFactor(int temp) {
        /*int temp_reductionFactor = 100 - temp / 3;
        if (temp_reductionFactor > 80) {
        return 100;
        }
        if (temp_reductionFactor < 10) {
        return 30;
        }
        return temp_reductionFactor;*/
        switch (temp / 20) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 3;
            case 3:
                return 7;
            case 4:
                return 10;
            case 5:
                return 15;
            case 6:
                return 23;
            case 7:
                return 28;
            case 8:
                return 35;
            case 9:
                return 40;
            case 10:
                return 45;
            case 11:
                return 51;
            case 12:
                return 58;
            case 13:
                return 65;
            case 14:
                return 72;
            case 15:
                return 80;
            default:
                return 80;
        }

    }

    public int CalculateElevationFactor(int temp, int total) {
        switch (temp / 20) {
            case 0:
                return 0;
            case 1:
                return 0;
            case 2:
                return 0;
            case 3:
                return 3;
            case 4:
                return 8;
            case 5:
                return 11;
            case 6:
                return 14;
            case 7:
                return 17;
            case 8:
                return 22;
            case 9:
                return 27;
            case 10:
                return 32;
            case 11:
                return 35;
            case 12:
                return 38;
            case 13:
                return 41;
            case 14:
                return 44;
            case 15:
                return 47;
            default:
                return 50;
        }
    }

    public int endFactorBatsmanBoost(int bowlingPoints) {
        switch(bowlingPoints/20){
            case 0:return 100;
            case 1:return 90;
            case 2:return 75;
            case 3:return 60;
            case 4:return 40;
            case 5:return 30;
            case 6:return 20;
            case 7:return 5;
            default:return 0;
        }
        
    }
}