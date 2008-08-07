/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package UpgradeTeam;

import Pavallion.AllDetailsBean;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author Owner
 */
public class PreUpgradeAction extends org.apache.struts.action.Action {
    
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
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession httpsession=request.getSession(false);
    /*    Authenticate temp=new Authenticate();
        temp.afterAuthentication(httpsession);*/
        AllDetailsBean alldetails=(AllDetailsBean) httpsession.getAttribute("alldetails");
        UpgradeConstants upgradecons=new UpgradeConstants();
        UpgradeSupportBean upgradesupportbean=new UpgradeSupportBean();
        //
        upgradesupportbean.setNextStrategyLevel(alldetails.getStrategy_level()+1);
        int moneyrequiredstrategy=upgradecons.getMoney("strategy",alldetails.getStrategy_level()+1);
        upgradesupportbean.setMoneyRequiredStrategy(moneyrequiredstrategy);
        
       //
        upgradesupportbean.setNextCoachLevel(alldetails.getCoach_level()+1);
        int moneyrequiredcoach=upgradecons.getMoney("coach",alldetails.getCoach_level()+1);
        upgradesupportbean.setMoneyRequiredCoach(moneyrequiredcoach);
        
        //
        upgradesupportbean.setNextBattingLevel(alldetails.getBatsman_level()+1);
        int moneyrequiredbatting=upgradecons.getMoney("batting", alldetails.getBatsman_level()+1);
        upgradesupportbean.setMoneyRequiredBatting(moneyrequiredbatting);
        
        //
        upgradesupportbean.setNextBowlingLevel(alldetails.getBowler_level()+1);
        int moneyrequiredbowling=upgradecons.getMoney("bowling", alldetails.getBowler_level()+1);
        upgradesupportbean.setMoneyRequiredBowling(moneyrequiredbowling);
        
        //
        httpsession.setAttribute("upgradesupportbean",upgradesupportbean);
        return new ActionForward("/Upgrade.jsp");
        //return mapping.findForward(SUCCESS);
        
    }
}