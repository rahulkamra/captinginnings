/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Pavallion;

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
public class BankAction extends org.apache.struts.action.Action {
    
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
        
        CommonForm temp_form = (CommonForm) form;
        HttpSession httpsession = request.getSession(false);
        AllDetailsBean details = (AllDetailsBean) httpsession.getAttribute("alldetails");

        String money_to_deposit = temp_form.getRequest_money_to_deposit();
         try {
            if (Integer.parseInt(money_to_deposit) > details.getMoney()) {
                return null;
            }
        } catch (NumberFormatException e) {
            return null;
        }
        JSONObject send_data=new JSONObject();
        details.setBanked_money(details.getBanked_money()+Integer.parseInt(money_to_deposit)*70/100);
        details.setMoney(details.getMoney()-Integer.parseInt(money_to_deposit));
        Update update=new Update();
        update.updateDatabase(details);
        send_data.accumulate("money",details.getMoney());
        send_data.accumulate("banked_money",details.getBanked_money());
        response.getWriter().println(send_data);
        return null;
        
    }
}