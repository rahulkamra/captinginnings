/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MatchLogic;

import Pavallion.AllDetailsBean;
import Team.TeamInterface;
import TeamRegistration.TeamRegistrationForm;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Owner
 */
public class CalculateRuns {

    public Map calculateRuns(AllDetailsBean alldetails, AllDetailsBean opponent_details, TeamRegistrationForm complete_details) {
        Set my_team = alldetails.getTeamlist();
        Set opponent_team = opponent_details.getTeamlist();
        Map my_opponent_bowling = calculateBowlingPoints(opponent_details, opponent_team, complete_details);
        BattingRunsLogic battingRuns = new BattingRunsLogic();
        Map totalRuns=battingRuns.battingRuns(alldetails, my_opponent_bowling, opponent_details, complete_details);
        LuckOneDay luckOneDay=new LuckOneDay();
        totalRuns=luckOneDay.giveLuckOneDay(totalRuns);
        return totalRuns;
    }

    
  
    
    //For Calculating bowling points for a team
    
    
    public Map calculateBowlingPoints(AllDetailsBean opponent_details, Set temp_team, TeamRegistrationForm complete_details) {
        int temp_total_offspinner_points = 0;
        int temp_total_legspinner_points = 0;
        int temp_total_fast_points = 0;
        int temp_total_medium_points = 0;
        int temp_total_chinaman_points = 0;
        //
        Map returnMap = new HashMap();
        TeamInterface teamInterface;
        //
        Map completeDetails = complete_details.getPlayerdetails();
        Iterator it_temp_team = temp_team.iterator();
        while (it_temp_team.hasNext()) {
            teamInterface = (TeamInterface) completeDetails.get(it_temp_team.next());
            temp_total_offspinner_points = temp_total_offspinner_points + teamInterface.getOff_spinner();
            temp_total_chinaman_points = temp_total_chinaman_points + teamInterface.getChinaman();
            temp_total_fast_points = temp_total_fast_points + teamInterface.getFast();
            temp_total_legspinner_points = temp_total_legspinner_points + teamInterface.getLeg_spinner();
            temp_total_medium_points = temp_total_medium_points + teamInterface.getMedium();
        }
        
        // Giving Extra Points :Not for free :)
        
        int extraBowlingPoints = opponent_details.getExtra_bowling_points();
        System.out.println(extraBowlingPoints);
        while (extraBowlingPoints > 0) {
            Random random = new Random();
            int flag = random.nextInt(5);
            switch (flag) {
                case 0:
                    temp_total_offspinner_points = temp_total_offspinner_points + 20;
                    break;
                case 1:
                    temp_total_chinaman_points = temp_total_chinaman_points + 20;
                    break;
                case 2:
                    temp_total_fast_points = temp_total_fast_points + 20;
                    break;
                case 3:
                    temp_total_legspinner_points = temp_total_legspinner_points + 20;
                    break;
                case 4:
                    temp_total_medium_points = temp_total_medium_points + 20;
                    break;
            }
            extraBowlingPoints--;
        }

        //
        returnMap.put("offspinner", temp_total_offspinner_points);
        returnMap.put("chinaman", temp_total_chinaman_points);
        returnMap.put("fast", temp_total_fast_points);
        returnMap.put("legspinner", temp_total_legspinner_points);
        returnMap.put("medium", temp_total_medium_points);
       
        //
        return returnMap;
    }
}
