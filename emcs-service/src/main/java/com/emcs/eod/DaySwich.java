package com.emcs.eod;

import com.emcs.Constant.BusiConstant;
import com.emcs.cache.CacheData;
import com.emcs.exception.BusiException;
import com.emcs.pub.runtime.core.Logger;
import com.emcs.pub.runtime.core.LoggerFactory;
import com.emcs.supers.PubServiceY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by Administrator on 2018/2/18.
 */
@Service
public class DaySwich extends PubServiceY {
    protected Logger log = LoggerFactory.getLogger(DaySwich.class);
    @Autowired
    BatchVirAccountBalance batchVirAccountBalance;
    @Autowired
    FromRecharBalToUsableBal fromRecharBalToUsableBal;

    public static DaySwich daySwich;
    @PostConstruct
    public void init() {
        daySwich = this;
    }

    public void process(Map<String, Object> data) {
        String server_date = new SimpleDateFormat(BusiConstant.FOR_STAN_08).format(new Date());
        Map<String, Object> cacheMap = CacheData.getCacheObj(daySwich.oneSelect, BusiConstant.Cache.CM_SYSTEM.val());
        String run_date = cacheMap.get("run_date") + "";
        try {
            log.info("服务器时间:" + server_date + "系统时间:" + run_date);
            if (run_date.compareTo(server_date) < 0) {
                log.info("开始执行日切操作");
                cacheMap.put("ser_status_flag", "N");
                CacheData.addCacheData(BusiConstant.CACHE_CM_SYSTEM, cacheMap);

                cacheMap.put("run_date", server_date);
                daySwich.batchVirAccountBalance.process(cacheMap);

                daySwich.fromRecharBalToUsableBal.process(null);

                cacheMap.put("ser_status_flag", "Y");
                CacheData.addCacheData(BusiConstant.CACHE_CM_SYSTEM, cacheMap);

                daySwich.oneDML.updateProduceDay(cacheMap);
                log.info("执行日切完毕");
            } else {
                log.info("已经日切");
            }
        } catch (Exception e) {
            CacheData.clear(BusiConstant.CACHE_CM_SYSTEM);
            throw new BusiException("日切过程异常", e);
        }
    }
}