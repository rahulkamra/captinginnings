/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Pavallion;

import Connection.CreateConnection;
import TeamRegistration.TeamRegistrationPojo;
import UserRegistration.RegistrationPojo;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Owner
 */
public class Update {

    public boolean updateDatabase(AllDetailsBean details){
        CreateConnection temp=new CreateConnection();
        Session session=temp.makeSession();
        session.beginTransaction();
       session.saveOrUpdate(details);
       session.getTransaction().commit();
       
        return true;
    }
    
    public boolean updateDatabase(AllDetailsBean details,AllDetailsBean opponent_details){
        CreateConnection temp=new CreateConnection();
        Session session=temp.makeSession();
        session.beginTransaction();
       session.saveOrUpdate(details);
       session.saveOrUpdate(opponent_details);
       session.getTransaction().commit();
       
        return true;
    }
}
