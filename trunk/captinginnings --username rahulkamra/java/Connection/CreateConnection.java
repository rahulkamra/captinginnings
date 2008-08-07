/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Connection;

import org.hibernate.*;
import org.hibernate.cfg.*;

/**
 *
 * @author Administrator
 */
public class CreateConnection {
    
    SessionFactory session_factory;
    public  CreateConnection(){
        
        session_factory= new Configuration().configure().buildSessionFactory();
        
    }

    public Session makeSession()
    {
         Session session=session_factory.openSession();
         session.beginTransaction();
         return session;
    }
    

}
