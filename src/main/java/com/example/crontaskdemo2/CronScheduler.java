package com.example.crontaskdemo2;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CronScheduler {
    @Bean
    public JobDetail cronJobDetail(){
        return JobBuilder.newJob(CronJob.class)
                .withIdentity("cronJob")
                .usingJobData("name","weiz cronJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger cronJobTrigger(){
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/10 * * * * ?");
        return TriggerBuilder.newTrigger()
                .withIdentity("CronSchedule")
                .forJob(cronJobDetail())
                .withSchedule(scheduleBuilder)
                .build();
    }
}
