/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Login;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Owner
 */
public class LoginForm extends org.apache.struts.action.ActionForm {
   private String username_chk;
    private String password_chk;

    public String getUsername_chk() {
        return username_chk;
    }

    public void setUsername_chk(String username_chk) {
        this.username_chk = username_chk;
    }

    public String getPassword_chk() {
        return password_chk;
    }

    public void setPassword_chk(String password_chk) {
        this.password_chk = password_chk;
    }

   

   
   }

