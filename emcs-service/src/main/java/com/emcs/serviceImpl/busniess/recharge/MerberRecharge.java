package com.emcs.serviceImpl.busniess.recharge;
import com.emcs.Super.ServiceTransactionalY;
import com.emcs.Constant.BusiCommon;
import com.emcs.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * Created by Administrator on 2018/2/4.
 */
@Service
public class MerberRecharge extends ServiceTransactionalY{
    @Autowired
    CustRecharge custRecharge;
    @Autowired
    MerchRecharge merchRecharge;
    @Override
    protected void process(Map<String, Object> param) {
        //2.数据库级校验
        param.put("status","N");//正常
        param.put("acct_status","N");
        if(oneSelect.selectIsExistVaPlatInfo(param)==0)throw new BusiException("交易平台不存在或者处于异常状态","600003");

        if(BusiCommon.ROLE_CUST.equals(param.get("role_type"))){
            param.put("cust_id",param.get("merber_id"));
            custRecharge.process(param);
        }else if(BusiCommon.ROLE_MERCH.equals(param.get("role_type"))){
            param.put("merch_id",param.get("merber_id"));
            merchRecharge.process(param);
        }else{
            throw new BusiException("角色类型错误","600009");
        }
    }
}