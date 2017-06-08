package com.sld.scheduler;

import com.sld.scheduler.jobs.DefaultJob;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

/**
 * Created by diwu.sld on 2017/5/10.
 */
public class SchedulerManager {

    private static SchedulerManager schedulerManager;

    private SchedulerFactory schedulerFactory = new StdSchedulerFactory();

    private SchedulerManager(){

    }

    public  static synchronized SchedulerManager getInstance(){
        if (null == schedulerManager){
            schedulerManager = new SchedulerManager();
        }

        return schedulerManager;
    }

    public  final Scheduler getScheduler(){
        try {
            Scheduler scheduler = this.schedulerFactory.getScheduler();
            scheduler.start();
            return scheduler;
        } catch (SchedulerException e) {
            e.printStackTrace();
            return  null;
        }
    }

    public void test(){
        Scheduler scheduler = SchedulerManager.getInstance().getScheduler();
        JobDetail jobDetail = JobBuilder.newJob(DefaultJob.class)
                .withIdentity("aaa", "bbb")
                .usingJobData("aaa", "bbb")
                .build();



        try {
            scheduler.scheduleJob(jobDetail,getImmediatelyTrigger());
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    private  Trigger getImmediatelyTrigger(){
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("immediately", "default")
                .startNow()
                .build();

        return  trigger;

    }
}
