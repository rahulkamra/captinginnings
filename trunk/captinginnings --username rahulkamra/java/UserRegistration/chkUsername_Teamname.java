/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package UserRegistration;
import Connection.CreateConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import org.hibernate.Session;

public class chkUsername_Teamname {
    
    public boolean chkUsername(String username){
        CreateConnection create_connection = new CreateConnection();
        Session session = create_connection.makeSession();
        org.hibernate.Query temp_query = session.createQuery(" from RegistrationPojo temp_registration_pojo where username=?");
        temp_query.setString(0,username);
        List temp_result=temp_query.list();
        if(temp_result.size()==0){
            return true;
        }
        return false;
    }
    public boolean chkTeamname(String teamname){
        CreateConnection create_connection = new CreateConnection();
        Session session = create_connection.makeSession();
        org.hibernate.Query temp_query = session.createQuery(" from RegistrationPojo temp_registration_pojo where teamname=?");
        temp_query.setString(0, teamname);
        List temp_result=temp_query.list();
        if(temp_result.size()==0){
            return true;
        }
        return false;
    }
   /*public static void main(String[] args) {
        chkUsername_Teamname temp=new chkUsername_Teamname();
        UserRegistrationForm temp11=new UserRegistrationForm();
        System.out.println(temp.chkUsername("712461"));
        //System.out.println(temp.chkTeamname("sarang111"));
    }*/


}
