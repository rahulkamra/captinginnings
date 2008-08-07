/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TeamRegistration;

import UserRegistration.UserRegistrationForm;
import javax.servlet.ServletContext;
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
public class PreTeamRegisterAction extends org.apache.struts.action.Action {
    
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
        
        TeamRegistrationForm player_information_form=new TeamRegistrationForm();
        UserRegistrationForm user_information=(UserRegistrationForm)form;
        RetrievePlayerInformation retrieve_player_information=new RetrievePlayerInformation();
        retrieve_player_information.setPlayerInformation(player_information_form);
        HttpSession session=request.getSession();
        session.setAttribute("player_information_bean",player_information_form);
        session.setAttribute("user_information",user_information);
        return new ActionForward("/teamregistration.jsp");
        
    }
}