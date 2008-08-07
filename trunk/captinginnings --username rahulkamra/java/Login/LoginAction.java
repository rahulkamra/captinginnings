/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Login;

import Pavallion.AllDetailsBean;
import Ranking.RankingCalc;
import UserRegistration.chkUsername_Teamname;
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
public class LoginAction extends org.apache.struts.action.Action {
    
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
        
        LoginForm temp_form=(LoginForm)form;
       Authenticate temp_authenticate=new Authenticate();
        HttpSession httpsession=request.getSession(true);
        String teamname=temp_authenticate.chkLogin(temp_form,httpsession);
        if(teamname!=null){
            return new ActionForward("/RedirectLogin.jsp");
        }
        temp_form.setUsername_chk(null);
        temp_form.setPassword_chk(null);
        return mapping.findForward(SUCCESS);
        
    }
}