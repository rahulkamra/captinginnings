/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TeamRegistration;

import Team.TeamEnum;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.json.JSONObject;

/**
 *
 * @author Owner
 */
public class DeletePlayerAction extends org.apache.struts.action.Action {

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
        TeamRegistrationForm temp_bean = (TeamRegistrationForm) form;
        Encoder temp_encode = new Encoder();
        temp_bean.setMyplayername(temp_encode.convertUtf8toString(temp_bean.getMyplayername()));
        String player_to_be_deleted = temp_bean.getMyplayername();
        /*  if (temp_bean.getMyplayername() == null) {
        return new ActionForward("/teamregistration.jsp");
        }
        if (temp_bean.getCurrentteamlist().contains(player_to_be_deleted)) {
        return new ActionForward("/teamregistration.jsp");
        }*/
        PointsManage points_manage=new PointsManage();
        points_manage.doPointsadd(temp_bean);
        TeamEnum teamname = TeamEnum.valueOf((String) temp_bean.getPlayer_information_form().getAllplayerlist().get(player_to_be_deleted.toString()));
        switch (teamname) {
        case Australia:
       // temp_bean.getMyteamlist().remove(player_to_be_deleted);
        temp_bean.getPlayer_information_form().getAustralia().add(player_to_be_deleted);
        break;
        case England:
       // temp_bean.getMyteamlist().remove(player_to_be_deleted);
        temp_bean.getPlayer_information_form().getEngland().add(player_to_be_deleted);
        break;
        case India:
        //temp_bean.getMyteamlist().remove(player_to_be_deleted);
        temp_bean.getPlayer_information_form().getIndia().add(player_to_be_deleted);
        break;
        case NewZealand:
        //temp_bean.getMyteamlist().remove(player_to_be_deleted);
        temp_bean.getPlayer_information_form().getNewzealand().add(player_to_be_deleted);
        break;
        case Pakistan:
        //temp_bean.getMyteamlist().remove(player_to_be_deleted);
        temp_bean.getPlayer_information_form().getPakistan().add(player_to_be_deleted);
        break;
        case SouthAfrica:
        //temp_bean.getMyteamlist().remove(player_to_be_deleted);
        temp_bean.getPlayer_information_form().getSouthafrica().add(player_to_be_deleted);
        break;
        case Srilanka:
        //temp_bean.getMyteamlist().remove(player_to_be_deleted);
        temp_bean.getPlayer_information_form().getSrilanka().add(player_to_be_deleted);
        break;
        case WestIndies:
        //temp_bean.getMyteamlist().remove(player_to_be_deleted);
        temp_bean.getPlayer_information_form().getWestindies().add(player_to_be_deleted);
        break;
        }
        temp_bean.getPlayer_information_form().getMyteamlist().remove(player_to_be_deleted);
        /*TeamEnum current_open_team = TeamEnum.valueOf(temp_bean.getCurrentteamname());
        switch (current_open_team) {
        case Australia:
        if (teamname.equals("Australia")) {
        temp_bean.getCurrentteamlist().add(player_to_be_deleted);
        }
        break;
        case England:
        if (teamname.equals("England")) {
        temp_bean.getCurrentteamlist().add(player_to_be_deleted);
        }
        break;
        case India:
        if (teamname.equals("India")) {
        temp_bean.getCurrentteamlist().add(player_to_be_deleted);
        }
        break;
        case NewZealand:
        if (teamname.equals("NewZealand")) {
        temp_bean.getCurrentteamlist().add(player_to_be_deleted);
        }
        break;
        case Pakistan:
        if (teamname.equals("Pakistan")) {
        temp_bean.getCurrentteamlist().add(player_to_be_deleted);
        }
        break;
        case SouthAfrica:
        if (teamname.equals("SouthAfrica")) {
        temp_bean.getCurrentteamlist().add(player_to_be_deleted);
        }
        break;
        case Srilanka:
        if (teamname.equals("Srilanka")) {
        temp_bean.getCurrentteamlist().add(player_to_be_deleted);
        }
        break;
        case WestIndies:
        if (teamname.equals("WestIndies")) {
        temp_bean.getCurrentteamlist().add(player_to_be_deleted);
        }
        break;
        }*/
        
        JSONObject temp_json=new JSONObject();
        temp_json.append("playername",temp_bean.getMyplayername());
        temp_json.append("teamname",teamname);
        temp_json.append("points_left",temp_bean.getPlayer_information_form().getPointsleft());
        temp_json.append("size",temp_bean.getPlayer_information_form().getMyteamlist().size());
        response.getWriter().println(temp_json);
        temp_bean.setCurrentplayername(null);
        return null;

    }
}