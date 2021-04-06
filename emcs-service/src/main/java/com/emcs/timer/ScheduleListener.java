package com.emcs.timer;

import com.emcs.exception.BusiException;
import com.emcs.mapper.OneTableSelectMapper;
import com.emcs.pub.runtime.core.Logger;
import com.emcs.pub.runtime.core.LoggerFactory;
import com.emcs.supers.PubServiceY;
import com.emcs.util.CheckEmpty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/2/20.
 */
@Component
public class ScheduleListener {

    private Logger log = LoggerFactory.getLogger(ScheduleListener.class);
    @Resource
    OneTableSelectMapper oneS;

    @Scheduled(cron = "0/30 * * * * ?")
    public void process() {
        log.info("定时任务监听:[ScheduleListener]......");
        List<Map<String, Object>> jobList = oneS.selectScheduleJob(null);
        if (CheckEmpty.isEmpty(jobList)) return;
        String classBean = null;

        for (Map<String, Object> jobMap : jobList) {
            classBean = jobMap.get("class_bean") + "";
            Class sl = null;
            try {
                log.info("当前执行的定时任务为:" + classBean);
                sl = Class.forName(classBean);
                ((PubServiceY) sl.newInstance()).process(jobMap);
                log.info("定时任务[" + classBean + "]执行成功\n");
            } catch (Exception e) {
                log.error("定时任务[" + classBean + "]执行失败",e);
                throw new BusiException("999999","产品["+classBean+"]处理失败");
            }
        }
    }
}