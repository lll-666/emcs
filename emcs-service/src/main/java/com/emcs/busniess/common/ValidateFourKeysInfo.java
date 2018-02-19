package com.emcs.busniess.common;

import com.emcs.supers.PubService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Administrator on 2018/2/19.
 */
@Service
public class ValidateFourKeysInfo extends PubService{
    @Override
    public void process(Map<String, Object> data) {
        log.info("校验四要素成功");
    }
}
