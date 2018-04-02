package com.szt.springbootscheduling.Scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * Created by sunzhitao on 2018/4/1.
 */
@Component
public class SchedulerTask {

    private  int count =0;

    @Scheduled(cron="*/6 * * * * ?")
    private  void  task(){
        System.out.println("执行任务1:"+count++);
    }
}
