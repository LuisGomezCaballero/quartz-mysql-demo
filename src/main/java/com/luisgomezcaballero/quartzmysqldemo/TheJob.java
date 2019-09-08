package com.luisgomezcaballero.quartzmysqldemo;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TheJob implements Job {
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Hello world.");
	}
	
}