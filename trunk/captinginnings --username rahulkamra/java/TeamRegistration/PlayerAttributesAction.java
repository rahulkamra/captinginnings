/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TeamRegistration;

import Team.TeamInterface;
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
public class PlayerAttributesAction extends org.apache.struts.action.Action {

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

        TeamRegistrationForm temp_form = (TeamRegistrationForm) form;
        String player_name = temp_form.getCurrentplayername();
        player_name = URLEncoder.encode(player_name, "utf-8");
        Encoder temp_encoder = new Encoder();
        String encoded_playername = temp_encoder.convertUtf8toString(player_name);
        System.out.println(encoded_playername);
        Map player_details = temp_form.getPlayer_information_form().getPlayerdetails();
        Map all_player_list = temp_form.getPlayer_information_form().getAllplayerlist();
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

        /*temp_form.setTotal(Integer.toString(temp_team.getTotal()));
        temp_form.setChinaman(Integer.toString(temp_team.getChinaman()));
        temp_form.setCutter(Integer.toString(temp_team.getCutter()));
        temp_form.setDriver(Integer.toString(temp_team.getDriver()));
        temp_form.setFast(Integer.toString(temp_team.getFast()));
        temp_form.setStrike_rotator(Integer.toString(temp_team.getStrike_rotator()));
        temp_form.setSlogger(Integer.toString(temp_team.getSlogger()));
        temp_form.setPuller(Integer.toString(temp_team.getPuller()));
        temp_form.setOff_spinner(Integer.toString(temp_team.getOff_spinner()));
        temp_form.setMedium(Integer.toString(temp_team.getMedium()));
        temp_form.setLeg_spinner(Integer.toString(temp_team.getLeg_spinner()));
         */

        response.getWriter().println(player_info);
        return null;//new ActionForward("/teamregistration.jsp");

    }
}