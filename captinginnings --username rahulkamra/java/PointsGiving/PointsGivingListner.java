package PointsGiving;


import TeamRegistration.RetrievePlayerInformation;
import TeamRegistration.TeamRegistrationForm;
import UpgradeTeam.UpgradeConstants;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Web application lifecycle listener.
 * @author Owner
 */

public class PointsGivingListner implements ServletContextListener {

    public void contextInitialized(ServletContextEvent arg0) {
        
        
        try{
        PointsGivingEvent.task();
        }catch(Exception e){
            System.out.println("Error in alloting points");
        }
        TeamRegistrationForm  player_information_form=new TeamRegistrationForm();
        RetrievePlayerInformation retrieve_player_information=new RetrievePlayerInformation();
        retrieve_player_information.setPlayerInformation(player_information_form);
        arg0.getServletContext().setAttribute("player_information_form",player_information_form);
    }

    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("Destroyed");
    }
}