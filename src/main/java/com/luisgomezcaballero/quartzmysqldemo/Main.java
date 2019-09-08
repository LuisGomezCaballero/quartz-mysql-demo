package com.luisgomezcaballero.quartzmysqldemo;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class Main {

	public static void main(String[] args) {
		try {
			JobDetail myJob = JobBuilder.newJob(TheJob.class).withIdentity("myjob", "mygroup").build();
			Trigger myTrigger = TriggerBuilder.newTrigger().withIdentity("mytrigger", "mygroup").startNow()
					.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();
			Scheduler myScheduler = new StdSchedulerFactory().getScheduler();
			myScheduler.start();
			myScheduler.scheduleJob(myJob, myTrigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
}