package com.emcs.serviceImpl.busniess.common;

import com.emcs.Super.ServiceTransactionalN;
import com.emcs.util.CommonResult;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Administrator on 2018/2/4.
 */
@Service
public class SendCorePay extends ServiceTransactionalN{
    @Override
    public CommonResult process(Map<String, Object> param) {
        return null;
    }
}