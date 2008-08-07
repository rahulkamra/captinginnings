/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package EditTeam;

import Team.TeamInterface;
import TeamRegistration.Encoder;
import java.net.URLEncoder;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.json.JSONObject;

/**
 *
 * @author Owner
 */
public class EditPlayerAttributes extends org.apache.struts.action.Action {
    
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
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        EditTeamForm temp_form=(EditTeamForm)form;
        String player_name=temp_form.getCurrentplayername();
        player_name = URLEncoder.encode(player_name, "utf-8");
        Encoder temp_encoder = new Encoder();
        String encoded_playername = temp_encoder.convertUtf8toString(player_name);
        System.out.println(encoded_playername);
        Map player_details = temp_form.getPlayerdetails();
        Map all_player_list = temp_form.getAllplayerlist();
        TeamInterface temp_team = (TeamInterface) player_details.get(encoded_playername);
        JSONObject player_info = new JSONObject();
        player_info.append("name", encoded_playername);
        player_info.append("total", temp_team.getTotal());
        player_info.append("chinaman", temp_team.getChinaman());
        player_info.append("cutter", temp_team.getCutter());
        player_info.append("driver", temp_team.getDriver());
        player_info.append("fast", temp_team.getFast());
        player_info.append("strike_rotator", temp_team.getStrike_rotator());
        player_info.append("slogger", temp_team.getSlogger());
        player_info.append("puller", temp_team.getPuller());
        player_info.append("off_spinner", temp_team.getOff_spinner());
        player_info.append("medium", temp_team.getMedium());
        player_info.append("leg_spinner", temp_team.getLeg_spinner());

        response.getWriter().println(player_info);
        return null;
        
        
    }
}