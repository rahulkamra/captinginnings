/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TeamRegistration;

import UserRegistration.Register;
import UserRegistration.UserRegistrationForm;
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

/**
 *
 * @author Owner
 */
public class RegisterAction extends org.apache.struts.action.Action {
    
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
        HttpSession session=request.getSession(false);
        UserRegistrationForm user_information=(UserRegistrationForm) session.getAttribute("user_information");
        TeamRegistrationForm team_information=(TeamRegistrationForm)form;
        ActionErrors err=new ActionErrors();
        Set my_team=team_information.getPlayer_information_form().getMyteamlist();
        FinalCheck temp_check=new FinalCheck();
        boolean chk=temp_check.checkTotalPoints(user_information,team_information);
        if(!chk){
            return new ActionForward("/error.jsp");
        }
        if(my_team.size()!=11){
            return new ActionForward("/error.jsp");
        }
        Register temp_regsiter=new Register();
        boolean temp_check_register=temp_regsiter.doRegsiteration(user_information, team_information);
        return new ActionForward("/success.jsp");
        
    }
}