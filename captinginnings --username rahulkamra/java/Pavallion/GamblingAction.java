/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pavallion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.json.JSONObject;

/**
 *
 * @author Owner
 */
public class GamblingAction extends org.apache.struts.action.Action {

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

        CommonForm temp_form = (CommonForm) form;
        HttpSession httpsession = request.getSession(false);
        AllDetailsBean details = (AllDetailsBean) httpsession.getAttribute("alldetails");

        String money_to_gamble = temp_form.getRequest_money_to_gamble();
        try {
            if (Integer.parseInt(money_to_gamble) > details.getMoney()) {
                return null;
            }
        } catch (NumberFormatException e) {
            return null;
        }
        JSONObject send_data=new JSONObject();
        GamblingLogic dogambling=new GamblingLogic();
        boolean flag=dogambling.doGambling();
        if(flag){
            details.setMoney(details.getMoney()+Integer.parseInt(money_to_gamble));
            send_data.accumulate("status",1);
        }else{
            details.setMoney(details.getMoney()-Integer.parseInt(money_to_gamble));
            send_data.accumulate("status",0);
        }
        Update temp_update=new Update();
        temp_update.updateDatabase(details);
        send_data.append("money",details.getMoney());
        response.getWriter().println(send_data);
        return null;

    }
}