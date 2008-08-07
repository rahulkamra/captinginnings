/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TeamRegistration;

import Connection.CreateConnection;
import Team.TeamInterface;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import Team.*;

/**
 *
 * @author Owner
 */
public class RetrievePlayerInformation {

    public void setPlayerInformation(TeamRegistrationForm player_information_form) {
        CreateConnection temp_connection = new CreateConnection();
        Session session = temp_connection.makeSession();
        Map player_team_mapping = new HashMap();
        Map complete_player_details = new HashMap();
        //
        Set india_set = generatePlayerInformation("India", session, player_team_mapping, complete_player_details);
        Set pakistan_set = generatePlayerInformation("Pakistan", session, player_team_mapping, complete_player_details);
        Set australia_set = generatePlayerInformation("Australia", session, player_team_mapping, complete_player_details);
        Set england_set = generatePlayerInformation("England", session, player_team_mapping, complete_player_details);
        Set newzealand_set = generatePlayerInformation("NewZealand", session, player_team_mapping, complete_player_details);
        Set southafrica_set = generatePlayerInformation("SouthAfrica", session, player_team_mapping, complete_player_details);
        Set srilanka = generatePlayerInformation("Srilanka", session, player_team_mapping, complete_player_details);
        Set westindies = generatePlayerInformation("WestIndies", session, player_team_mapping, complete_player_details);
        Set eliete = generatePlayerInformation("Eliete", session, player_team_mapping, complete_player_details);
        player_information_form.setIndia(india_set);
        player_information_form.setPakistan(pakistan_set);
        player_information_form.setAustralia(australia_set);
        player_information_form.setEngland(england_set);
        player_information_form.setNewzealand(newzealand_set);
        player_information_form.setSouthafrica(southafrica_set);
        player_information_form.setWestindies(westindies);
        player_information_form.setSrilanka(srilanka);
        player_information_form.setEliete(eliete);
        player_information_form.setAllplayerlist(player_team_mapping);
        player_information_form.setPlayerdetails(complete_player_details);
    }

    private Set generatePlayerInformation(String teamname, Session session, Map player_team_mapping, Map complete_player_details) {

        String Query = " from " + teamname + "Pojo" + " " + "e";
        org.hibernate.Query temp_query = session.createQuery(Query);
        List temp_list = temp_query.list();
        ListIterator temp_list_iterator = temp_list.listIterator();
        Set return_set = new HashSet();
        while (temp_list_iterator.hasNext()) {
            TeamInterface temp_interface = (TeamInterface) temp_list_iterator.next();
            return_set.add(temp_interface.getPlayername());   //contains all the playernames of a team
            player_team_mapping.put(temp_interface.getPlayername(), teamname);     //contain map which has a mapping of playername,teamname
            complete_player_details.put(temp_interface.getPlayername(), temp_interface);    //contain map which has a mapping of playername,playerdetails
        //System.out.println(temp_interface.getPlayername());
        }
        return return_set;
    }

    private Set generateElietePlayerInformation(String teamname, Session session, Map player_team_mapping, Map complete_player_details) {

        String Query = " from " + teamname + "Pojo" + " " + "e";
        org.hibernate.Query temp_query = session.createQuery(Query);
        List temp_list = temp_query.list();
        ListIterator temp_list_iterator = temp_list.listIterator();
        Set return_set = new HashSet();
        while (temp_list_iterator.hasNext()) {
            ElietePojo temp_pojo = (ElietePojo) temp_list_iterator.next();
            return_set.add(temp_pojo.getPlayername());   //contains all the playernames of a team
            player_team_mapping.put(temp_pojo.getPlayername(), "Eliete");     //contain map which has a mapping of playername,teamname
            complete_player_details.put(temp_pojo.getPlayername(), temp_pojo);    //contain map which has a mapping of playername,playerdetails
        }
        return return_set;
    }

    public static void main(String[] args) {
        CreateConnection temp_connection = new CreateConnection();
        Session session = temp_connection.makeSession();
        RetrievePlayerInformation temp = new RetrievePlayerInformation();
        temp.generateElietePlayerInformation("Eliete", session, null, null);
    }
}