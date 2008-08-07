/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PlayMatch;

import Login.Authenticate;
import Pavallion.AllDetailsBean;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author Owner
 */
public class GetOpponentInfoAction extends org.apache.struts.action.Action {
    
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
        String opponent_teamname=request.getParameter("teamname");
         HttpSession httpsession=request.getSession(false);
        AllDetailsBean alldetails=(AllDetailsBean) httpsession.getAttribute("alldetails");
        //
        if(opponent_teamname.equals(alldetails.getTeamname())){
            return mapping.findForward("cant play your self");
        }
        //
        Authenticate getinfo=new Authenticate();
        AllDetailsBean opponent_details=new AllDetailsBean();
        //
        boolean flag=getinfo.getInformation(opponent_details,opponent_teamname);
        httpsession.setAttribute("opponent_details",opponent_details);
        
        int my_strategy_level=alldetails.getStrategy_level();
        Set player_to_display=new HashSet();
        Set opponent_team_list=opponent_details.getTeamlist();
        for(int count=0;count<my_strategy_level;count++){
            player_to_display.add(opponent_team_list.toArray()[count]);
        }
        httpsession.setAttribute("player_to_display",player_to_display);
        
        return new ActionForward("/OpponentTeam.jsp");
        
    }
}