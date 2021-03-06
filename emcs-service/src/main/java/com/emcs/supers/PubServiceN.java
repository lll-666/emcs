package com.emcs.supers;

import com.emcs.mapper.ManyTableDMLMapper;
import com.emcs.mapper.ManyTableSelectMapper;
import com.emcs.mapper.OneTableDMLMapper;
import com.emcs.mapper.OneTableSelectMapper;
import com.emcs.pub.runtime.core.Logger;
import com.emcs.pub.runtime.core.LoggerFactory;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 公共service,非事务执行
 * Created by Administrator on 2018/2/21.
 */
public abstract class PubServiceN {
    protected Logger log = LoggerFactory.getLogger(PubServiceY.class);
    @Resource
    protected ManyTableDMLMapper manyDML;
    @Resource
    protected OneTableDMLMapper oneDML;
    @Resource
    protected OneTableSelectMapper oneSelect;
    @Resource
    protected ManyTableSelectMapper manySelect;
    public abstract void process(Map<String, Object> data);
}
