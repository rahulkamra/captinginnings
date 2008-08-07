/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package UserRegistration;

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
public class ChkTeamAvailaiblity extends org.apache.struts.action.Action {
    
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
        UserRegistrationForm user_registration_form = (UserRegistrationForm) form;
        JSONObject send_result=new JSONObject();
        if(user_registration_form.getTeamname().equals("")){
            send_result.append("teamname",false);
        }   
        chkUsername_Teamname temp_chkteamname=new chkUsername_Teamname();
        boolean bool_chk=temp_chkteamname.chkTeamname(user_registration_form.getTeamname());
        if(bool_chk){
                send_result.append("teamname",true);
            }else{
                send_result.append("teamname",false);
            }
        user_registration_form.setUsername(null);
        user_registration_form.setTeamname(null);
        response.getWriter().println(send_result);
        return null;
    
        
    }
}