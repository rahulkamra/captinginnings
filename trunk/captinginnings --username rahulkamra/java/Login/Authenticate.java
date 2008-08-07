/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Connection.CreateConnection;
import Pavallion.AllDetailsBean;
import Ranking.RankingCalc;
import TeamRegistration.TeamRegistrationPojo;
import UserRegistration.RegistrationPojo;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;

/**
 *
 * @author Owner
 */
public class Authenticate {

    public String chkLogin(LoginForm temp_form,HttpSession httpsession) {
        CreateConnection new_connection = new CreateConnection();
        Session session = new_connection.makeSession();
        org.hibernate.Query temp_query = session.createQuery(" from RegistrationPojo temp_registration_pojo where username= ?");
        temp_query.setParameter(0, temp_form.getUsername_chk());
        Set teamlist=new HashSet();
        AllDetailsBean temp_details=new AllDetailsBean();
        try {
            RegistrationPojo temp_pojo = (RegistrationPojo) temp_query.list().get(0);
            temp_pojo.getUsername();
            if (temp_pojo.getPassword().equals(temp_form.getPassword_chk())) {
                httpsession.setAttribute("teamname",temp_pojo.getTeamname());
                httpsession.setAttribute("teamlist",teamlist);
                httpsession.setAttribute("alldetails",temp_details);
                return temp_pojo.getTeamname();
            } else {
                return null;
            }
        } catch (java.lang.IndexOutOfBoundsException e) {
            return null;
        }
    }
    
    public boolean getInformation(AllDetailsBean temp_details,String teamname){
        CreateConnection new_connection = new CreateConnection();
        Session session = new_connection.makeSession();
        org.hibernate.Query temp_query = session.createQuery(" from RegistrationPojo temp_registration_pojo where teamname= ?");
        Set teamlist=new HashSet();
        TeamRegistrationPojo temp_team=(TeamRegistrationPojo) session.load(TeamRegistrationPojo.class,teamname);
        teamlist.add(temp_team.getPlayer1());
                teamlist.add(temp_team.getPlayer2());
                teamlist.add(temp_team.getPlayer3());
                teamlist.add(temp_team.getPlayer4());
                teamlist.add(temp_team.getPlayer5());
                teamlist.add(temp_team.getPlayer6());
                teamlist.add(temp_team.getPlayer7());
                teamlist.add(temp_team.getPlayer8());
                teamlist.add(temp_team.getPlayer9());
                teamlist.add(temp_team.getPlayer10());
                teamlist.add(temp_team.getPlayer11());
                temp_details.setBanked_money(temp_team.getBanked_money());
                temp_details.setBatsman_level(temp_team.getBatsman_level());
                temp_details.setBowler_level(temp_team.getBowler_level());
                temp_details.setStrategy_level(temp_team.getStrategy_level());
                temp_details.setCoach_level(temp_team.getCoach_level());
                temp_details.setLoose(temp_team.getLoose_matches());
                temp_details.setMoney(temp_team.getMoney());
                temp_details.setPoints_left(temp_team.getPoints_left());
                temp_details.setTotal_matches(temp_team.getTotal_matches());
                temp_details.setWin(temp_team.getWin_matches());
                temp_details.setDraw(temp_team.getTotal_matches()-temp_team.getWin_matches()-temp_team.getLoose_matches());
                temp_details.setTime_left(60-new Date().getMinutes());
                temp_details.setTeamname(teamname);
                temp_details.setTeamlist(teamlist);
                RankingCalc rank=new RankingCalc();
                temp_details.setRank(rank.getTeamRank(teamname));
        return false;
    }

    
}
