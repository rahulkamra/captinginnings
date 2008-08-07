/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayMatch;

import Pavallion.AllDetailsBean;
import Pavallion.CommonForm;
import Ranking.RankingCalc;
import java.util.SortedMap;
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
public class PreRankDispAction extends org.apache.struts.action.Action {

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
        AllDetailsBean alldetails = (AllDetailsBean) httpsession.getAttribute("alldetails");
        RankDispHelpBean rank_page = new RankDispHelpBean();
        RankingCalc rankcalc = new RankingCalc();
        CalculateTotalUsers totalusers_calc = new CalculateTotalUsers();
        //
        httpsession.setAttribute("next_flag",true);
        httpsession.setAttribute("previous_flag",true);
        //
        int rank = alldetails.getRank();
        int slot = ((rank - 1) / 10) * 10;
        rank_page.setSlot(slot);
        //
        
        int total_users = totalusers_calc.getTotalUsers();
        rank_page.setToatalusers(total_users);
        int max_slot = ((total_users - 1) / 10) * 10;
        //
        if(slot==0){
            httpsession.setAttribute("next_flag",null);
        }
        if(slot==max_slot){
          httpsession.setAttribute("previous_flag", null);  
        }
        //
       
        //
        rank_page.setMin_current_page_user(slot + 1);
        rank_page.setMax_current_page_user(slot + 10);
        //
       
        SortedMap rankmap = rankcalc.getRankingbetween(slot + 1, slot + 10);
        rank_page.setCurrentmap(rankmap);
         httpsession.setAttribute("rank_page",rank_page); 
        return new ActionForward("/RankDisplay.jsp");

    }
}