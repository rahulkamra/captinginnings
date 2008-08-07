/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Pavallion;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Owner
 */
public class CommonForm extends org.apache.struts.action.ActionForm {

    private String request_extrapoints;
    private String request_money_to_gamble;
    private String request_money_to_deposit;
    private String money_to_upgrade_basic_strategy;
    private String money_to_upgrade_bank_strategy;
    private String money_to_upgrade_basic_coach;
    private String money_to_upgrade_bank_coach;
    private String money_to_upgrade_basic_batting;
    private String money_to_upgrade_bank_batting;
    private String money_to_upgrade_basic_bowling;
    private String money_to_upgrade_bank_bowling;
    
    
    

    public String getRequest_extrapoints() {
        return request_extrapoints;
    }

    public void setRequest_extrapoints(String request_extrapoints) {
        this.request_extrapoints = request_extrapoints;
    }

    public String getRequest_money_to_gamble() {
        return request_money_to_gamble;
    }

    public void setRequest_money_to_gamble(String request_money_to_gamble) {
        this.request_money_to_gamble = request_money_to_gamble;
    }

    public String getRequest_money_to_deposit() {
        return request_money_to_deposit;
    }

    public void setRequest_money_to_deposit(String request_money_to_deposit) {
        this.request_money_to_deposit = request_money_to_deposit;
    }

    public String getMoney_to_upgrade_basic_strategy() {
        return money_to_upgrade_basic_strategy;
    }

    public void setMoney_to_upgrade_basic_strategy(String money_to_upgrade_basic_strategy) {
        this.money_to_upgrade_basic_strategy = money_to_upgrade_basic_strategy;
    }

    public String getMoney_to_upgrade_bank_strategy() {
        return money_to_upgrade_bank_strategy;
    }

    public void setMoney_to_upgrade_bank_strategy(String money_to_upgrade_bank_strategy) {
        this.money_to_upgrade_bank_strategy = money_to_upgrade_bank_strategy;
    }

    public String getMoney_to_upgrade_basic_coach() {
        return money_to_upgrade_basic_coach;
    }

    public void setMoney_to_upgrade_basic_coach(String money_to_upgrade_basic_coach) {
        this.money_to_upgrade_basic_coach = money_to_upgrade_basic_coach;
    }

    public String getMoney_to_upgrade_bank_coach() {
        return money_to_upgrade_bank_coach;
    }

    public void setMoney_to_upgrade_bank_coach(String money_to_upgrade_bank_coach) {
        this.money_to_upgrade_bank_coach = money_to_upgrade_bank_coach;
    }

    public String getMoney_to_upgrade_basic_batting() {
        return money_to_upgrade_basic_batting;
    }

    public void setMoney_to_upgrade_basic_batting(String money_to_upgrade_basic_batting) {
        this.money_to_upgrade_basic_batting = money_to_upgrade_basic_batting;
    }

    public String getMoney_to_upgrade_bank_batting() {
        return money_to_upgrade_bank_batting;
    }

    public void setMoney_to_upgrade_bank_batting(String money_to_upgrade_bank_batting) {
        this.money_to_upgrade_bank_batting = money_to_upgrade_bank_batting;
    }

    public String getMoney_to_upgrade_basic_bowling() {
        return money_to_upgrade_basic_bowling;
    }

    public void setMoney_to_upgrade_basic_bowling(String money_to_upgrade_basic_bowling) {
        this.money_to_upgrade_basic_bowling = money_to_upgrade_basic_bowling;
    }

    public String getMoney_to_upgrade_bank_bowling() {
        return money_to_upgrade_bank_bowling;
    }

    public void setMoney_to_upgrade_bank_bowling(String money_to_upgrade_bank_bowling) {
        this.money_to_upgrade_bank_bowling = money_to_upgrade_bank_bowling;
    }

   
   }

