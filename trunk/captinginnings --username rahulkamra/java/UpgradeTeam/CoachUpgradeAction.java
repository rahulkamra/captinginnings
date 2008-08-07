/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UpgradeTeam;

import Pavallion.AllDetailsBean;
import Pavallion.CommonForm;
import Pavallion.Update;
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
public class CoachUpgradeAction extends org.apache.struts.action.Action {

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
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        CommonForm temp_form = (CommonForm) form;
        HttpSession httpsession = request.getSession(false);
        AllDetailsBean alldetails = (AllDetailsBean) httpsession.getAttribute("alldetails");
        int level_to_upgrade = alldetails.getCoach_level() + 1;
        UpgradeConstants upgradeconstants = new UpgradeConstants();
        int money_to_upgrade = upgradeconstants.getMoney("coach", level_to_upgrade);

        //trying for null values
        try {
            if (money_to_upgrade != Integer.parseInt(temp_form.getMoney_to_upgrade_bank_coach()) + Integer.parseInt(temp_form.getMoney_to_upgrade_basic_coach())) {
                return null;
            }
        } catch (java.lang.NumberFormatException e) {
            return null;
        }


        //Basic Requirement
        if (money_to_upgrade > alldetails.getMoney() + alldetails.getBanked_money()) {
            return null;
        }

        //Exteme Case
        if (alldetails.getMoney() < Integer.parseInt(temp_form.getMoney_to_upgrade_basic_coach()) || alldetails.getBanked_money() < Integer.parseInt(temp_form.getMoney_to_upgrade_bank_coach())) {

            return null;
        }

        //Calculations
        int banked_temp_money = money_to_upgrade - Integer.parseInt(temp_form.getMoney_to_upgrade_basic_coach());
        System.out.println(money_to_upgrade + "moeny to up" + banked_temp_money);
        if (alldetails.getBanked_money() < banked_temp_money) {
            return null;
        }
        alldetails.setBanked_money(alldetails.getBanked_money() - banked_temp_money);
        alldetails.setCoach_level(level_to_upgrade);
        alldetails.setMoney(alldetails.getMoney() - Integer.parseInt(temp_form.getMoney_to_upgrade_basic_coach()));


        //Updating database
        Update update = new Update();
        update.updateDatabase(alldetails);


        //Preparing for the next upgrade
        //
        //changing session parameters to meet the database requirement
        int nextupgrade = upgradeconstants.getMoney("coach", level_to_upgrade + 1);
        UpgradeSupportBean support = (UpgradeSupportBean) httpsession.getAttribute("upgradesupportbean");
        support.setNextCoachLevel(level_to_upgrade);
        support.setMoneyRequiredCoach(nextupgrade);


        //sending data
        JSONObject send_data = new JSONObject();
        send_data.accumulate("coach_level", alldetails.getCoach_level()+ 1);
        send_data.accumulate("bank_money", alldetails.getBanked_money());
        send_data.accumulate("money", alldetails.getMoney());
        send_data.accumulate("money_required", nextupgrade);

        response.getWriter().println(send_data);

        return null;

    }
}
