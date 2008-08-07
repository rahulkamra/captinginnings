/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TeamRegistration;

import Team.TeamEnum;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMessage;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Owner
 */
public class AddPlayerAction extends org.apache.struts.action.Action {

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
     * all the things are there in Player information which is there in
     * team registeration form
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        TeamRegistrationForm temp_bean = (TeamRegistrationForm) form;
        Encoder temp_encode=new Encoder();
         temp_bean.setCurrentplayername(temp_encode.convertUtf8toString(temp_bean.getCurrentplayername()));
       /*if (temp_bean.getCurrentplayername()==null) {
            return new ActionForward("/teamregistration.jsp");
        }*/
        Set myteamlist=temp_bean.getPlayer_information_form().getMyteamlist();
        if(myteamlist==null){
            Set temp_myteamlist=new HashSet();
            temp_bean.getPlayer_information_form().setMyteamlist(temp_myteamlist);
        }
        
        if(temp_bean.getPlayer_information_form().getMyteamlist().size()>10){
           response.getWriter().println("1");
            return null;
        }
        PointsManage points_manage=new PointsManage();
        boolean chk=points_manage.doPointDeduct(temp_bean);
       
        if(!chk){
            response.getWriter().println("0");
            return null;
        }
        
        myteamlist=temp_bean.getPlayer_information_form().getMyteamlist();
        TeamEnum team_name=TeamEnum.valueOf((String) temp_bean.getPlayer_information_form().getAllplayerlist().get(temp_bean.getCurrentplayername().toString().trim()));
        String current_player_name=temp_bean.getCurrentplayername();
        switch(team_name){
            case Australia:
                //temp_bean.getCurrentteamlist().remove(current_player_name);
                temp_bean.getPlayer_information_form().getAustralia().remove(current_player_name);
                break;
            case England:
                //temp_bean.getCurrentteamlist().remove(current_player_name);
                temp_bean.getPlayer_information_form().getEngland().remove(current_player_name);
                break;
            case India:
                 //temp_bean.getCurrentteamlist().remove(current_player_name);
                temp_bean.getPlayer_information_form().getIndia().remove(current_player_name);
                break;
            case NewZealand:
                 //temp_bean.getCurrentteamlist().remove(current_player_name);
                temp_bean.getPlayer_information_form().getNewzealand().remove(current_player_name);
                break;
            case Pakistan:
                 //temp_bean.getCurrentteamlist().remove(current_player_name);
                temp_bean.getPlayer_information_form().getPakistan().remove(current_player_name);
                break;
            case SouthAfrica:
                 //temp_bean.getCurrentteamlist().remove(current_player_name);
                temp_bean.getPlayer_information_form().getSouthafrica().remove(current_player_name);
                break;
            case Srilanka:
                 //temp_bean.getCurrentteamlist().remove(current_player_name);
                temp_bean.getPlayer_information_form().getSrilanka().remove(current_player_name);
                break;
            case WestIndies:
                 //temp_bean.getCurrentteamlist().remove(current_player_name);
                temp_bean.getPlayer_information_form().getWestindies().remove(current_player_name);
                break;
        }
        myteamlist.add(current_player_name);
        JSONObject send=new JSONObject();
        JSONArray array_currentteam=new JSONArray();
        array_currentteam.put(myteamlist);
        send.append("myteamlist",array_currentteam);
        send.append("points_left", temp_bean.getPlayer_information_form().getPointsleft());
        send.append("size", temp_bean.getPlayer_information_form().getMyteamlist().size());
        send.append("playername",temp_bean.getCurrentplayername());
        response.getWriter().println(send);
        temp_bean.setCurrentplayername(null);
        return null;

    }
}