/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package UserRegistration;

import java.util.ArrayList;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Administrator
 */
public class UserRegistrationForm extends org.apache.struts.action.ActionForm {
    
   private String username;
   private String password;
   private String firstname;
   private String lastname;
   private String security_question;
   private String security_answer;
   private String location;
   private String teamname;
   private Set all_user_list;
   private Set all_teamname_list;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSecurity_question() {
        return security_question;
    }

    public void setSecurity_question(String security_question) {
        this.security_question = security_question;
    }

    public String getSecurity_answer() {
        return security_answer;
    }

    public void setSecurity_answer(String security_answer) {
        this.security_answer = security_answer;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public Set getAll_user_list() {
        return all_user_list;
    }

    public void setAll_user_list(Set all_user_list) {
        this.all_user_list = all_user_list;
    }

    public Set getAll_teamname_list() {
        return all_teamname_list;
    }

    public void setAll_teamname_list(Set all_teamname_list) {
        this.all_teamname_list = all_teamname_list;
    }
}
