package com.emcs.timer;

import com.emcs.pub.runtime.core.Logger;
import com.emcs.pub.runtime.core.LoggerFactory;

/**
 * Created by Administrator on 2018/2/19.
 */
//@Component
public class FileTimerTask {
    private Logger log = LoggerFactory.getLogger(FileTimerTask.class);

    // 每天早八点到晚八点，间隔2分钟执行任务
//    @Scheduled(cron="0 0/2 8-20 * * ?")
    public void executeFileDownLoadTask() {

        // 间隔2分钟,执行工单上传任务
        Thread current = Thread.currentThread();
        System.out.println("定时任务1:"+current.getId());
        log.info("ScheduledTest.executeFileDownLoadTask 定时任务1:"+current.getId()+ ",name:"+current.getName());
    }

    // 每天早八点到晚八点，间隔1分钟执行任务
//    @Scheduled(cron="0 0/1 8-20 * * ?")
    public void executeUploadTask() {

        // 间隔1分钟,执行工单上传任务
        Thread current = Thread.currentThread();
        System.out.println("定时任务2:"+current.getId());
        log.info("ScheduledTest.executeUploadTask 定时任务2:"+current.getId() + ",name:"+current.getName());
    }

//    @Scheduled(cron="0 0/3 5-23 * * ?")
    public void executeUploadBackTask() {

        // 间隔3分钟,执行工单上传任务                          
        Thread current = Thread.currentThread();
        System.out.println("定时任务3:"+current.getId());
        log.info("ScheduledTest.executeUploadBackTask 定时任务3:"+current.getId()+ ",name:"+current.getName());
    }
}