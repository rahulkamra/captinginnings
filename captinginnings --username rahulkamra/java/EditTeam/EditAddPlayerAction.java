/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EditTeam;

import Team.TeamEnum;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import TeamRegistration.*;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Owner
 */
public class EditAddPlayerAction extends org.apache.struts.action.Action {

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

        EditTeamForm temp_bean = (EditTeamForm) form;
        try {
            TeamEnum team_name = null;
            Encoder temp_encode = new Encoder();
            temp_bean.setCurrentplayername(temp_encode.convertUtf8toString(temp_bean.getCurrentplayername()));
            //
            Set myteamlist = temp_bean.getMyteamlist();
            if (myteamlist == null) {
                Set temp_myteamlist = new HashSet();
                temp_bean.setMyteamlist(temp_myteamlist);
            }
            if (temp_bean.getMyteamlist().size() > 10) {
                response.getWriter().println("1");
                return null;
            }
            //
            PointsManage points_manage = new PointsManage();

            boolean chk = points_manage.doPointDeduct(temp_bean);
            //
            if (!chk) {
                response.getWriter().println("0");
                return null;
            }
        
        myteamlist = temp_bean.getMyteamlist();

        team_name = TeamEnum.valueOf((String) temp_bean.getAllplayerlist().get(temp_bean.getCurrentplayername().toString().trim()));

        String current_player_name = temp_bean.getCurrentplayername();
        switch (team_name) {
            case Australia:
                //temp_bean.getCurrentteamlist().remove(current_player_name);
                temp_bean.getAustralia().remove(current_player_name);
                break;
            case England:
                //temp_bean.getCurrentteamlist().remove(current_player_name);
                temp_bean.getEngland().remove(current_player_name);
                break;
            case India:
                //temp_bean.getCurrentteamlist().remove(current_player_name);
                temp_bean.getIndia().remove(current_player_name);
                break;
            case NewZealand:
                //temp_bean.getCurrentteamlist().remove(current_player_name);
                temp_bean.getNewzealand().remove(current_player_name);
                break;
            case Pakistan:
                //temp_bean.getCurrentteamlist().remove(current_player_name);
                temp_bean.getPakistan().remove(current_player_name);
                break;
            case SouthAfrica:
                //temp_bean.getCurrentteamlist().remove(current_player_name);
                temp_bean.getSouthafrica().remove(current_player_name);
                break;
            case Srilanka:
                //temp_bean.getCurrentteamlist().remove(current_player_name);
                temp_bean.getSrilanka().remove(current_player_name);
                break;
            case WestIndies:
                //temp_bean.getCurrentteamlist().remove(current_player_name);
                temp_bean.getWestindies().remove(current_player_name);
                break;
        }

        myteamlist.add(current_player_name);
        JSONObject send = new JSONObject();
        JSONArray array_currentteam = new JSONArray();
        array_currentteam.put(myteamlist);
        send.append("myteamlist", array_currentteam);
        send.append("points_left", temp_bean.getPointsleft());
        send.append("size", temp_bean.getMyteamlist().size());
        send.append("playername", temp_bean.getCurrentplayername());
        response.getWriter().println(send);
    }
    catch(Exception e) {
            response.getWriter().println("Null Pointer");
    }

    temp_bean.setCurrentplayername (null);
    return


null;
    }
}