package com.sld.scheduler.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by diwu.sld on 2017/5/10.
 */
public class DefaultJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        this.start("aaaa");
    }

    private  String start(String value){
        return  "aaaa" + value;
    }

    private void finished(String value){
        System.out.println(value);
    }
}
