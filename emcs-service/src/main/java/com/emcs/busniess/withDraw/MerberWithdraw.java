package com.emcs.busniess.withDraw;
import com.emcs.Constant.BusiConstant;
import com.emcs.Constant.ErrorCodeConstant;
import com.emcs.busniess.common.LimitValidate;
import com.emcs.supers.ServiceTransactionalY;
import com.emcs.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Administrator on 2018/2/5.
 */
@Service
public class MerberWithdraw extends ServiceTransactionalY{
    @Autowired
    LimitValidate validate;
    @Autowired
    CustWithdraw custWithdraw;
    @Autowired
    MerchWithdraw merchWithdraw;
    @Override
    protected void process(Map<String, Object> data) {
        //初始化会员和会员账户状态
        data.put("status","N");
        data.put("acct_status","N");

        //校验平台
        if(oneSelect.selectIsExistVaPlatInfo(data)==0)
            throw new BusiException(ErrorCodeConstant.PlatErrorCode.VAP001.code(), ErrorCodeConstant.PlatErrorCode.VAP001.val());

        if(BusiConstant.ROLE_CUST.equals(data.get("role_type"))){
            data.put("tran_type", BusiConstant.TranType.CUST_WITHDRAW.val());
            data.put("payer_type",BusiConstant.ROLE_CUST);
            data.put("cust_id",data.get("payer_id"));

            validate.validatePayer(data);

            validate.businessValidate(data);

            custWithdraw.process(data);
        }else if(BusiConstant.ROLE_MERCH.equals(data.get("role_type"))){
            data.put("tran_type", BusiConstant.TranType.MERCH_WITHDRAW.val());
            data.put("payer_type",BusiConstant.ROLE_MERCH);
            data.put("merch_id",data.get("payer_id"));

            validate.validatePayer(data);

            validate.businessValidate(data);

            merchWithdraw.process(data);
        }else{
            throw new BusiException(ErrorCodeConstant.PubErrorCode.VAZ007.code(), ErrorCodeConstant.PubErrorCode.VAZ007.val());
        }
    }
}