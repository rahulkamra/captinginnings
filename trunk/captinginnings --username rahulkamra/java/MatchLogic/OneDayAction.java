/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MatchLogic;

import Pavallion.AllDetailsBean;
import Pavallion.Update;
import TeamRegistration.TeamRegistrationForm;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author Owner
 */
public class OneDayAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        HttpSession httpsession = request.getSession(false);
        AllDetailsBean alldetails = (AllDetailsBean) httpsession.getAttribute("alldetails");
        AllDetailsBean opponent_details = (AllDetailsBean) httpsession.getAttribute("opponent_details");
        if (alldetails.getPoints_left() < 5) {
            return new ActionForward("/error.jsp");
        }

        ServletContext servletContext = httpsession.getServletContext();
        TeamRegistrationForm complete_details = (TeamRegistrationForm) servletContext.getAttribute("player_information_form");
        CalculateRuns calculateRuns = new CalculateRuns();
        Map myRuns = calculateRuns.calculateRuns(alldetails, opponent_details, complete_details);
        Map opponentRuns = calculateRuns.calculateRuns(opponent_details, alldetails, complete_details);
        //
        int myTotalRuns = 0;
        int myOpponentTotalRuns = 0;
        //
        myTotalRuns = calculateTotalRuns(myRuns);
        myOpponentTotalRuns = calculateTotalRuns(opponentRuns);

        //Money Giving
        Random random = new Random();
        int money_giving_percentage = random.nextInt(30) + 50;
        int myTeamMoney = (alldetails.getMoney() * money_giving_percentage) / 100;
        int opponentTeamMoney = (opponent_details.getMoney()*money_giving_percentage) / 100;

        //
        String status = "";
        alldetails.setTotal_matches(alldetails.getTotal_matches()+1);
        opponent_details.setTotal_matches(opponent_details.getTotal_matches()+1);
        
        // Game win-Loose Logic

        if (myTotalRuns > myOpponentTotalRuns) {
            alldetails.setWin(alldetails.getWin() + 1);
            opponent_details.setLoose(opponent_details.getLoose() + 1);
            //
            alldetails.setMoney(alldetails.getMoney() + opponentTeamMoney);
            opponent_details.setMoney(opponent_details.getMoney() - opponentTeamMoney);
            status = "Congratz You have defeated the opponent and win  " + opponentTeamMoney;
            httpsession.setAttribute("status", status);

        }
        if (myOpponentTotalRuns > myTotalRuns) {
            alldetails.setLoose(alldetails.getLoose() + 1);
            opponent_details.setWin(opponent_details.getWin() + 1);
            //
            opponent_details.setMoney(opponent_details.getMoney() + myTeamMoney);
            alldetails.setMoney(alldetails.getMoney() - myTeamMoney);
            status = "You have lost    " + myTeamMoney + "          Better Luck  Nxt Time";
            httpsession.setAttribute("status", status);

        }
        if (myTotalRuns == myOpponentTotalRuns) {

            alldetails.setDraw(alldetails.getDraw() + 1);
            opponent_details.setDraw(opponent_details.getDraw() + 1);
            status = "Omg..  A Draw What a Close Match !!!";
            httpsession.setAttribute("status", status);
        }

        int extras = (Integer) myRuns.remove("extra");
        httpsession.setAttribute("extra", extras);
        httpsession.setAttribute("myRuns", myRuns);
        httpsession.setAttribute("myTotalRuns", myTotalRuns);
        httpsession.setAttribute("myOpponentTotalRuns", myOpponentTotalRuns);
        //
        alldetails.setPoints_left(alldetails.getPoints_left() - 5);
        //
        Update update = new Update();
        update.updateDatabase(alldetails, opponent_details);

        //initializing Extra Points
        alldetails.setExtra_batting_points(0);
        alldetails.setExtra_bowling_points(0);

        return new ActionForward(("/RedirectFinalOneDay.jsp"));

    }
    
    
    /**
     * 
     * 
     * Total Runs Logic
     * 
     */
    public int calculateTotalRuns(Map currentTeam) {

        Collection tempSet = (Collection) currentTeam.values();          //make Set of values
        int totalRuns = 0;
        Iterator it_tempSet = tempSet.iterator();
        while (it_tempSet.hasNext()) {
            int runs = (Integer) it_tempSet.next();
            totalRuns = totalRuns + runs;
        }
        System.out.println(totalRuns);
        return totalRuns;
    }
}