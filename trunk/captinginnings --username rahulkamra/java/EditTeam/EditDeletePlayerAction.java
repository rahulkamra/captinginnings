/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package EditTeam;

import Team.TeamEnum;
import TeamRegistration.Encoder;
import TeamRegistration.PointsManage;
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
public class EditDeletePlayerAction extends org.apache.struts.action.Action {
    
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
        
        EditTeamForm temp_bean=(EditTeamForm)form;
        try{
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
        boolean chk=points_manage.doPointsadd(temp_bean);
        if(!chk){
            return null;
        }
        TeamEnum teamname = TeamEnum.valueOf((String) temp_bean.getAllplayerlist().get(player_to_be_deleted.toString()));
        switch (teamname) {
        case Australia:
       
        temp_bean.getAustralia().add(player_to_be_deleted);
        break;
        case England:
       
        temp_bean.getEngland().add(player_to_be_deleted);
        break;
        case India:
        
        temp_bean.getIndia().add(player_to_be_deleted);
        break;
        case NewZealand:
       
        temp_bean.getNewzealand().add(player_to_be_deleted);
        break;
        case Pakistan:
        
        temp_bean.getPakistan().add(player_to_be_deleted);
        break;
        case SouthAfrica:
        
        temp_bean.getSouthafrica().add(player_to_be_deleted);
        break;
        case Srilanka:
       
        temp_bean.getSrilanka().add(player_to_be_deleted);
        break;
        case WestIndies:
        
        temp_bean.getWestindies().add(player_to_be_deleted);
        break;
        }
        temp_bean.getMyteamlist().remove(player_to_be_deleted);
        
        
        JSONObject temp_json=new JSONObject();
        temp_json.append("playername",temp_bean.getMyplayername());
        temp_json.append("teamname",teamname);
        temp_json.append("points_left",temp_bean.getPointsleft());
        temp_json.append("size",temp_bean.getMyteamlist().size());
        response.getWriter().println(temp_json);
        temp_bean.setCurrentplayername(null);
        }catch(Exception e){
            response.getWriter().println("Null Pointer");
        }
        return null;

    
        
        
    }
}