/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TeamRegistration;

import Team.TeamInterface;
import UserRegistration.UserRegistrationForm;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Owner
 */
public class FinalCheck {

    public boolean checkTotalPoints(UserRegistrationForm user_information,TeamRegistrationForm team_information){
       Map player_information=team_information.getPlayer_information_form().getPlayerdetails();
       Set myteam=team_information.getPlayer_information_form().getMyteamlist();
       Iterator it_team=myteam.iterator();
       int total_points=0;
        while(it_team.hasNext()){
            TeamInterface temp=(TeamInterface) player_information.get(it_team.next());
            total_points=total_points+temp.getTotal();
        }
       if(total_points>105){
        return false;
       }
       return true;
    }
}
