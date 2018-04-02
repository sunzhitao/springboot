package com.szt.springbootscheduling.Scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.SortedMap;

/**
 * Created by sunzhitao on 2018/4/1.
 */
@Component
public class SchedulerTask1 {

    @Scheduled(cron="*/6 * * * * ?")
    private  void  task2(){
        System.out.println("定时任务2");
    }
}
