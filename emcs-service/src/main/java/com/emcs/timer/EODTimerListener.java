package com.emcs.timer;

import com.emcs.Constant.BusiConstant;
import com.emcs.cache.CacheData;
import com.emcs.exception.BusiException;
import com.emcs.mapper.OneTableDMLMapper;
import com.emcs.mapper.OneTableSelectMapper;
import com.emcs.pub.runtime.core.Logger;
import com.emcs.pub.runtime.core.LoggerFactory;
import com.emcs.supers.SuperTask;
import com.emcs.util.CheckEmpty;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/2/19.
 */
//@Component
public class EODTimerListener {
    private Logger log = LoggerFactory.getLogger(EODTimerListener.class);
    @Resource
    OneTableSelectMapper oneSlect;
    @Resource
    OneTableDMLMapper oneDML;

//    @Scheduled(cron="0 0/1 8-20 * * ?")
    public void process() {
        Map<String,Object> sysMap = CacheData.getCacheObj(oneSlect, BusiConstant.Cache.CM_SYSTEM.val());
        sysMap.put("tran_date",sysMap.get("run_date"));
        sysMap.put("prd_no","9999");//日切
        List<Map<String,Object>> procLogList = oneSlect.selectEodProcLog(sysMap);
        if(!CheckEmpty.isEmpty(procLogList)){
//           if("000000".equals(procLogList.get(0).get("status")))
        }
        log.info("日终处理.......");
        List<Map<String,Object>> taskList = oneSlect.selectEodProcRule(null);
        if(CheckEmpty.isEmpty(taskList))return;
        try{
            log.info("开始执行任务...");
            for (Map<String,Object> taskMap:taskList){
                try{
                    String classBean = taskMap.get("class_bean")+"";
                    log.info("当前执行任务号为:"+taskMap.get("step_no"));

                    ((SuperTask)Class.forName(classBean).newInstance()).process( new HashMap<>(),oneSlect,oneDML);

                    log.info("任务号为["+taskMap.get("step_no")+"]执行成功");
                }catch (Exception e){
                    log.info("任务号为["+taskMap.get("step_no")+"]执行失败");
                    throw new BusiException("执行任务过程异常",e);
                }
            }
            log.info("任务执行完毕...");
        }catch (Exception e){
            log.info("执行任务过程异常",e);
        }
    }
}