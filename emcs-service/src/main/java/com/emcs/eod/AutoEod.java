package com.emcs.eod;

import com.emcs.Constant.BusiConstant;
import com.emcs.busniess.common.TaskExecute;
import com.emcs.busniess.common.TaskPretreatment;
import com.emcs.busniess.common.ValidateIsDaySwitch;
import com.emcs.busniess.common.ValidatePrdIsDoWell;
import com.emcs.cache.CacheData;
import com.emcs.mapper.OneTableSelectMapper;
import com.emcs.supers.PubServiceY;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Administrator on 2018/2/22.
 */
@Service
public class AutoEod extends PubServiceY{
    @Resource
    TaskPretreatment taskPre;
    @Resource
    ValidateIsDaySwitch validateIsDaySwitch;
    @Resource
    TaskExecute taskExecute;
    @Resource
    ValidatePrdIsDoWell validatePrdIsDoWell;
    @Resource
    UpdateEodProcLog updateEodProcLog;
    @Resource
    protected OneTableSelectMapper oneS;

    public static AutoEod autoEod;
    @PostConstruct
    public void init() {
        autoEod = this;
    }

    public void process(Map<String, Object> data) {
        data.putAll(CacheData.getCacheObj(autoEod.oneS, BusiConstant.Cache.CM_SYSTEM.val()));
        data.put("prd_no","9998");//代表日终
        data.put("tran_date",data.get("run_date"));

        //1.校验是否已经日切,没有日切则不能进行后续操作
        if(!autoEod.validateIsDaySwitch.process(data))return;

        //2.校验是否已经日终
        if(autoEod.validatePrdIsDoWell.process(data))return;

        try{
            //3.产品任务的预处理
            autoEod.taskPre.process(data);

            //4.总调度
            autoEod.taskExecute.process(data);

            //5.更新产品处理结果
            data.put("status","000000");
            autoEod.updateEodProcLog.process(data);
        }catch (Exception e){
            data.put("status","999999");
            autoEod.updateEodProcLog.process(data);
        }
    }
}