/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PointsGiving;

import java.util.Date;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author Owner
 */
public class PointsGivingEvent {

    public static void task() throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        // Retrieve a scheduler from schedule factory
        Scheduler scheduler = schedulerFactory.getScheduler();
        // Initiate JobDetail with job name, job group, and executable job class
        JobDetail jobDetail = new JobDetail("jobDetail-s1", "jobDetailGroup-s1", PointsGivingjob.class);
        // Initiate SimpleTrigger with its name and group name
        SimpleTrigger simpleTrigger = new SimpleTrigger("simpleTrigger", "triggerGroup-s1");
        // set its start up time
        Date date=new Date();
        date.setMinutes(0);
        date.setHours(date.getHours()+1);
        simpleTrigger.setStartTime(date);
        System.out.println("date is.............................." + date);
        // set the interval, how often the job should run (10 seconds here) 
        simpleTrigger.setRepeatInterval(60*60*1000);
        //simpleTrigger.setRepeatInterval(10*1000);
        simpleTrigger.setRepeatCount(1000000000);
        scheduler.scheduleJob(jobDetail, simpleTrigger);
          
        // start the scheduler
        scheduler.start();
    }
}
