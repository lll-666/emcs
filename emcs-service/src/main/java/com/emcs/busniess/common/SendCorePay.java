package com.emcs.busniess.common;

import com.emcs.supers.PubService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Administrator on 2018/2/4.
 */
@Service
public class SendCorePay extends PubService {
    @Override
    public void process(Map<String, Object> param) {
        log.info("调核心支付成功");
    //待补充
    }
}
