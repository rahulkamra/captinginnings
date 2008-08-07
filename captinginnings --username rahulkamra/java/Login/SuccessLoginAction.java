/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Login;

import Connection.CreateConnection;
import Pavallion.AllDetailsBean;
import Ranking.RankingCalc;
import TeamRegistration.TeamRegistrationPojo;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.hibernate.Session;

/**
 *
 * @author Owner
 */
public class SuccessLoginAction extends org.apache.struts.action.Action {
    
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
       
        HttpSession httpsession=request.getSession(false);
        Authenticate temp=new Authenticate();
        AllDetailsBean alldetails=(AllDetailsBean) httpsession.getAttribute("alldetails");
        String teamname=(String) httpsession.getAttribute("teamname");
        temp.getInformation(alldetails,teamname);
        return new ActionForward("/pavallion.jsp");
        
    }
}