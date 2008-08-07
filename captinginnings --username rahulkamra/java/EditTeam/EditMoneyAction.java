/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package EditTeam;

import java.util.Iterator;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import Pavallion.*;
import org.json.JSONObject;

/**
 *
 * @author Owner
 */
public class EditMoneyAction extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    private static final int moneyForOneUpgrade=700;
    
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
        
        EditTeamForm tempForm=(EditTeamForm)form;
        HttpSession httpsession=request.getSession(false);
        AllDetailsBean alldetails=(AllDetailsBean) httpsession.getAttribute("alldetails");
        Set originalTeam =alldetails.getTeamlist();
        Set currentTeam=tempForm.getMyteamlist();
        Iterator itCurrentTeam=currentTeam.iterator();
        int diffetentPlayers=0;
        while(itCurrentTeam.hasNext()){
            String playerName=(String) itCurrentTeam.next();
            boolean flag=originalTeam.contains(playerName);
            if(!flag){
                diffetentPlayers++;
            }
        }
        int moneytoSend=diffetentPlayers*moneyForOneUpgrade;
        JSONObject send_data=new JSONObject();
        send_data.append("money",moneytoSend);
        response.getWriter().println(moneytoSend);
        return null;
        
    }
}