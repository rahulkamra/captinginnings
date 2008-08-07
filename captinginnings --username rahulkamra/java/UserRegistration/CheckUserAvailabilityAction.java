/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserRegistration;

import java.util.ArrayList;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMessage;
import org.json.JSONObject;

/**
 *
 * @author Owner
 */
public class CheckUserAvailabilityAction extends org.apache.struts.action.Action {

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
        UserRegistrationForm user_registration_form = (UserRegistrationForm) form;
        System.out.println(user_registration_form.getUsername());
        JSONObject send_result=new JSONObject();
        if(user_registration_form.getUsername().equals("")){
            send_result.append("username",false);
        }   
        chkUsername_Teamname temp_chkusername=new chkUsername_Teamname();
        boolean bool_chk=temp_chkusername.chkUsername(user_registration_form.getUsername());
        if(bool_chk){
                send_result.append("username",true);
            }else{
                send_result.append("username",false);
            }
        user_registration_form.setUsername(null);
        user_registration_form.setTeamname(null);
        response.getWriter().println(send_result);
        return null;
    }
}
