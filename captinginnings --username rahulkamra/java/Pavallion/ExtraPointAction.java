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
public class ExtraPointAction extends org.apache.struts.action.Action {

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

        HttpSession session = request.getSession(false);
        CommonForm temp_form = (CommonForm) form;
        AllDetailsBean details = (AllDetailsBean) session.getAttribute("alldetails");
        String teamname=(String)session.getAttribute("teamname");
        String type = temp_form.getRequest_extrapoints();
        JSONObject send_data = new JSONObject();
        if(details.getPoints_left()<=0){
            send_data.accumulate("status", -2);
            response.getWriter().println(send_data);
            return null;
        }
        if (details.getExtra_batting_points() + details.getExtra_bowling_points() >= 5) {
            send_data.accumulate("status", -1);
            response.getWriter().println(send_data);
            return null;
        }
        details.setPoints_left(details.getPoints_left()-1);
        Update update=new Update();
        update.updateDatabase(details);
        GiveExtraPoints give_points = new GiveExtraPoints();
        boolean flag = give_points.getxtraPoints();
        send_data.accumulate("points_left",details.getPoints_left());
        if (flag) {

            if (type.equals("Batting")) {
                details.setExtra_batting_points(details.getExtra_batting_points() + 1);
                send_data.accumulate("status", 1);
                send_data.accumulate("batting", details.getExtra_batting_points());
            }
            if (type.equals("Bowling")) {
                details.setExtra_bowling_points(details.getExtra_bowling_points() + 1);
                send_data.accumulate("status", 1);
                send_data.accumulate("bowling", details.getExtra_bowling_points());
            }
            response.getWriter().println(send_data);
            return null;
        }
        send_data.accumulate("status", 0);
        response.getWriter().println(send_data);
        temp_form.setRequest_extrapoints(null);
        return null;
    }
}