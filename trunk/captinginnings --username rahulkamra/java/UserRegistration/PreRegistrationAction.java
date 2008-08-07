/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package UserRegistration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author Owner
 */
public class PreRegistrationAction extends org.apache.struts.action.Action {
    
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
        UserRegistrationForm user_registration_form=(UserRegistrationForm)form;
        chkUsername_Teamname all_user_list=new chkUsername_Teamname();
//        //all_user_list.setUserList(user_registration_form);
        
         return new ActionForward("/userregistration.jsp");
       
        
    }
}