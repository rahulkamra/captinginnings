/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Pavallion;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.json.JSONObject;

/**
 *
 * @author Owner
 */
public class UpdateGUIAjaxAction extends org.apache.struts.action.Action {
    
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
        AllDetailsBean alldetails=(AllDetailsBean) httpsession.getAttribute("alldetails");
        alldetails.setTime_left(60-new Date().getMinutes());
        JSONObject send_data=new JSONObject();
        send_data.accumulate("points_left",alldetails.getPoints_left());
        send_data.accumulate("time_left",alldetails.getTime_left());
        send_data.accumulate("money",alldetails.getMoney());
        send_data.accumulate("banked_money",alldetails.getBanked_money());
        response.getWriter().println(send_data);
        return null;
        
    }
}