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
import Team.*;
import java.util.ArrayList;
import org.json.JSONArray;

/**
 *
 * @author Owner
 */
public class DropDownEditTeamAction extends org.apache.struts.action.Action {

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
        EditTeamForm player_information_form = (EditTeamForm) form;
        HttpSession httpsession = request.getSession(false);
        TeamEnum teamname;
        //
        try {
            teamname = TeamEnum.valueOf(player_information_form.getCurrentteamname());
        } catch (java.lang.IllegalArgumentException e) {
            teamname = TeamEnum.Default;
        }
        //
        JSONArray playerlist = new JSONArray();
        switch (teamname) {
            case Australia:
                playerlist.put(player_information_form.getAustralia());
                break;
            case England:
                playerlist.put(player_information_form.getEngland());
                break;
            case India:
                playerlist.put(player_information_form.getIndia());
                break;
            case NewZealand:
                playerlist.put(player_information_form.getNewzealand());
                break;
            case Pakistan:
                playerlist.put(player_information_form.getPakistan());
                break;
            case SouthAfrica:
                playerlist.put(player_information_form.getSouthafrica());
                break;
            case Srilanka:
                playerlist.put(player_information_form.getSrilanka());
                break;
            case WestIndies:
                playerlist.put(player_information_form.getWestindies());
                break;
            case Eliete:
                playerlist.put(player_information_form.getEliete());
                break;
            case Default:
                ArrayList templist = null;
                playerlist.put(templist);
                break;

        }
        response.getWriter().println(playerlist);
        return null;

    }
}