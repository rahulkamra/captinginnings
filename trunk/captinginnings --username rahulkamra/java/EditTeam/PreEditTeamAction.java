/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EditTeam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import Pavallion.*;
import TeamRegistration.TeamRegistrationForm;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.servlet.ServletContext;
import Team.*;
import java.util.Map;

/**
 *
 * @author Owner
 */
public class PreEditTeamAction extends org.apache.struts.action.Action {

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
        EditTeamForm temp_form = (EditTeamForm) form;
        HttpSession httpsesison = request.getSession();
        //
        ServletContext servletContext = httpsesison.getServletContext();
        TeamRegistrationForm player_information_form = (TeamRegistrationForm) servletContext.getAttribute("player_information_form");
        
        //Initialinzing the page to -1
        temp_form.setCurrentteamname("-1");
        
        //Setting team players
        temp_form.setIndia(new HashSet(player_information_form.getIndia()));
        temp_form.setAustralia(new HashSet(player_information_form.getAustralia()));
        temp_form.setEngland(new HashSet(player_information_form.getEngland()));
        temp_form.setNewzealand(new HashSet(player_information_form.getNewzealand()));
        temp_form.setPakistan(new HashSet(player_information_form.getPakistan()));
        temp_form.setSouthafrica(new HashSet(player_information_form.getSouthafrica()));
        temp_form.setSrilanka(new HashSet(player_information_form.getSrilanka()));
        temp_form.setWestindies(new HashSet(player_information_form.getWestindies()));
        //

        temp_form.setAllplayerlist(player_information_form.getAllplayerlist());
        temp_form.setPlayerdetails(player_information_form.getPlayerdetails());
        //

        AllDetailsBean alldetails = (AllDetailsBean) httpsesison.getAttribute("alldetails");
        temp_form.setMyteamlist(new HashSet(alldetails.getTeamlist()));
        
        
        //Setting Eliete Players Name
          ElietePlayerSetCreation makeSet=new ElietePlayerSetCreation();
         Set elitePlayer=makeSet.makeElieteSet(temp_form, alldetails,player_information_form.getEliete());
         temp_form.setEliete(elitePlayer);   //Setting only those eliete player who are eligible
        //
        

        Map allPlayerList = (Map) temp_form.getAllplayerlist();
        Map playerDetails=temp_form.getPlayerdetails();
        Set myteam = alldetails.getTeamlist();
        Iterator itMyTeam = myteam.iterator();
        int total=0;
        while (itMyTeam.hasNext()) {
            String playername = (String) itMyTeam.next();
            TeamEnum teamname = TeamEnum.valueOf((String) allPlayerList.get(playername));
            TeamInterface teamInt=(TeamInterface) playerDetails.get(playername);
            total=total+teamInt.getTotal();
            switch(teamname){
                case Australia:temp_form.getAustralia().remove(playername);break;
                case England:temp_form.getEngland().remove(playername);break;
                case India:temp_form.getIndia().remove(playername);break;
                case NewZealand:temp_form.getNewzealand().remove(playername);break;
                case Pakistan:temp_form.getPakistan().remove(playername);break;
                case SouthAfrica:temp_form.getSouthafrica().remove(playername);break;
                case Srilanka:temp_form.getSrilanka().remove(playername);break;
                case WestIndies:temp_form.getWestindies().remove(playername);break;
                case Eliete:temp_form.getEliete().remove(playername);break;
                default:System.out.println("Player of unknown Team");break;
            }
        }
        //Preserving the current team
        //
        temp_form.setPointsleft(Integer.toString(105-total));
        
        //Initializing The Page to -1
        
        
        return new ActionForward("/RedirectEditPage.jsp");

    }
}