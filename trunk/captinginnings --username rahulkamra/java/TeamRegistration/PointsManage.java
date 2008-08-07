/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TeamRegistration;

import EditTeam.EditTeamForm;
import Team.TeamInterface;
import java.util.Map;

/**
 *
 * @author Owner
 */
public class PointsManage {

    public boolean doPointDeduct(TeamRegistrationForm temp_form) throws NullPointerException{
        String player_name=temp_form.getCurrentplayername();
        Map player_details=temp_form.getPlayer_information_form().getPlayerdetails();
        int i_current_player_points;
        String points_left=temp_form.getPlayer_information_form().getPointsleft();
        TeamInterface temp_team=(TeamInterface) player_details.get(player_name);
        i_current_player_points=temp_team.getTotal();
        if(Integer.parseInt(points_left)>=i_current_player_points){
           points_left=Integer.toString(Integer.parseInt(points_left)-i_current_player_points);
           temp_form.getPlayer_information_form().setPointsleft(points_left);
           return true;
        }
        return false;
    }
    
    public boolean doPointsadd(TeamRegistrationForm temp_form) throws NullPointerException{
        String player_name=temp_form.getMyplayername();
        Map player_details=temp_form.getPlayer_information_form().getPlayerdetails();
        String points_left=temp_form.getPlayer_information_form().getPointsleft();
        TeamInterface temp_team=(TeamInterface) player_details.get(player_name);
        int i_current_player_points=temp_team.getTotal();
        points_left=Integer.toString(Integer.parseInt(points_left)+i_current_player_points);
        temp_form.getPlayer_information_form().setPointsleft(points_left);
        return false;
    }


public boolean doPointDeduct(EditTeamForm temp_form) throws NullPointerException{
        String player_name=temp_form.getCurrentplayername();
        if(temp_form.getMyteamlist().contains(player_name)){
            return false;
        }
        Map player_details=temp_form.getPlayerdetails();
        int i_current_player_points;
        String points_left=temp_form.getPointsleft();
        TeamInterface temp_team=(TeamInterface) player_details.get(player_name);
        i_current_player_points=temp_team.getTotal();
        if(Integer.parseInt(points_left)>=i_current_player_points){
           points_left=Integer.toString(Integer.parseInt(points_left)-i_current_player_points);
           temp_form.setPointsleft(points_left);
           return true;
        }
        return false;
    }
 public boolean doPointsadd(EditTeamForm temp_form) throws NullPointerException{
        String player_name=temp_form.getMyplayername();
        if(!temp_form.getMyteamlist().contains(player_name)){
            return false;
        }
        Map player_details=temp_form.getPlayerdetails();
        String points_left=temp_form.getPointsleft();
        TeamInterface temp_team=(TeamInterface) player_details.get(player_name);
        int i_current_player_points=temp_team.getTotal();
        points_left=Integer.toString(Integer.parseInt(points_left)+i_current_player_points);
        temp_form.setPointsleft(points_left);
        return true;
    }

}