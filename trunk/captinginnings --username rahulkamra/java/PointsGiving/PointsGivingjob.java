/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PointsGiving;

import Connection.CreateConnection;
import org.hibernate.Query;
import org.hibernate.Session;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author Owner
 */
public class PointsGivingjob implements Job{

    public  void execute(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println("Trying to give points");
        CreateConnection temp=new CreateConnection();
        Session session=temp.makeSession();
        session.beginTransaction();
        Query temp_query=session.createQuery(" update TeamRegistrationPojo t set points_left =points_left+1,money=money+50 where 1=1");
        temp_query.executeUpdate();
        session.getTransaction().commit();
        
    }

}
