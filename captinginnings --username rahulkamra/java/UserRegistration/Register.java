/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package UserRegistration;

import Connection.CreateConnection;
import TeamRegistration.TeamRegistrationForm;
import TeamRegistration.TeamRegistrationPojo;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Owner
 */
public class Register {

    public boolean doRegsiteration(UserRegistrationForm user_form,TeamRegistrationForm team_form){
        RegistrationPojo db_userregistration=new RegistrationPojo();
        TeamRegistrationPojo db_teamregistration=new TeamRegistrationPojo();
        db_userregistration.setFirstname(user_form.getFirstname());
        db_userregistration.setLastname(user_form.getLastname());
        db_userregistration.setLocation(user_form.getLocation());
        db_userregistration.setPassword(user_form.getPassword());
        db_userregistration.setSecurity_answer(user_form.getSecurity_answer());
        db_userregistration.setSecurity_question(user_form.getSecurity_question());
        db_userregistration.setTeamname(user_form.getTeamname());
        db_userregistration.setUsername(user_form.getUsername());
        
        /*Team
         * Registeration ater this
         */
        Object[] teamlist=team_form.getPlayer_information_form().getMyteamlist().toArray();
       db_teamregistration.setTeamname(user_form.getTeamname());
        db_teamregistration.setPlayer1(teamlist[0].toString());
        db_teamregistration.setPlayer2(teamlist[1].toString());
        db_teamregistration.setPlayer3(teamlist[2].toString());
        db_teamregistration.setPlayer4(teamlist[3].toString());
        db_teamregistration.setPlayer5(teamlist[4].toString());
        db_teamregistration.setPlayer6(teamlist[5].toString());
        db_teamregistration.setPlayer7(teamlist[6].toString());
        db_teamregistration.setPlayer8(teamlist[7].toString());
        db_teamregistration.setPlayer9(teamlist[8].toString());
        db_teamregistration.setPlayer10(teamlist[9].toString());
        db_teamregistration.setPlayer11(teamlist[10].toString());
        db_teamregistration.setMoney(100);
        db_teamregistration.setPoints_left(24);
        
        /* 
         * Hibernate after this
         */
        CreateConnection create_connection=new CreateConnection();
        Session session=create_connection.makeSession();
        try{
        session.getTransaction().begin();
        session.save(db_userregistration);
        session.save(db_teamregistration);
        }catch(Exception e){
            session.getTransaction().rollback();
            return false;
        }
        session.getTransaction().commit();
        return true;
    }
    
    /*public static void main(String[] args) {
        Register temp=new Register();
        TeamRegistrationForm tempteam=new TeamRegistrationForm();
        Set myteamlist=new HashSet();
        myteamlist.add("haha");
        myteamlist.add("chaha");
        myteamlist.add("aa");
        tempteam.setMyteamlist(myteamlist);
        temp.doRegsiteration(null,tempteam);
    }*/

}
