package com.emcs.busniess.order;

import com.emcs.Constant.BusiConstant;
import com.emcs.Constant.ErrorCodeConstant.PlatErrorCode;
import com.emcs.Constant.ErrorCodeConstant.PubErrorCode;
import com.emcs.exception.BusiException;
import com.emcs.supers.InServiceY;
import com.emcs.util.CheckEmpty;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/2/6.
 */
@Service
public class PurchaseConfirm extends InServiceY {
    @Override
    protected void process(Map<String, Object> data) {
        //初始化会员和会员账户状态
        data.put("status","N");

        //校验平台
        if(oneSelect.selectIsExistVaPlatInfo(data)==0)
            throw new BusiException(PlatErrorCode.VAP001.code(), PlatErrorCode.VAP001.val());

        data.put("order_status","01");
        List<Map<String,Object>> oldOrderList = oneSelect.selectVaOrderInfoForOld(data);

        if(CheckEmpty.isEmpty(oldOrderList))throw new BusiException("原订单不存在或原订单已经确认");

        if(!"01".equals(oldOrderList.get(0).get("order_status")))throw new BusiException("原订单不能确认,请查看该订单状态");

        if(oneSelect.selectVaOrderSeqForRepeat(data)>0)throw new BusiException("重复提交");

        Map<String,Object> oldOrderMap = oldOrderList.get(0);

        BigDecimal tran_amt = (BigDecimal)oldOrderMap.get("tran_amt");
        if(tran_amt.compareTo(new BigDecimal(data.get("tran_amt")+""))!=0)throw new BusiException("123456","确认金额有误");

        if(!(data.get("payer_id")+"").equals(oldOrderMap.get("payer_id")))throw new BusiException("付款方信息有误");

        if(!(data.get("payee_id")+"").equals(oldOrderMap.get("payee_id")))throw new BusiException("收款方信息有误");

        String rundate = data.get("tran_date")+"";
        BigDecimal recharge_bal = (BigDecimal)oldOrderMap.get("recharge_bal");
        BigDecimal usable_bal = (BigDecimal)oldOrderMap.get("usable_bal");

        //隔日确认处理
        if(rundate.compareTo(oldOrderMap.get("create_date")+"")>0){
            oldOrderMap.put("usable_bal",usable_bal.add(recharge_bal));
            oldOrderMap.put("recharge_bal",0);
        }

        if(BusiConstant.Role.CUST.val().equals(data.get("role_type"))){
            oldOrderMap.put("tran_type",BusiConstant.TranType.CUST_PURCHASE_CONFIRM.val());
        }else if(BusiConstant.Role.MERCH.val().equals(data.get("role_type"))){
            oldOrderMap.put("tran_type",BusiConstant.TranType.MERCH_PURCHASE_CONFIRM.val());
        }

        oldOrderMap.put("merch_id",oldOrderMap.get("payee_id"));
        oldOrderMap.put("merch_virid",oldOrderMap.get("payee_virid"));

        //增加供应商余额
        if(oneDML.updateVaMerchVirtualAcctBalAdd(oldOrderMap)!=1)throw new BusiException(PubErrorCode.VAZ023.val(),PubErrorCode.VAZ023.code());

        //插入采购确认流水信息
        data.putAll(oldOrderMap);
        data.put("create_date",data.get("tran_date")+""+data.get("tran_time"));
        oneDML.insertVaOrderSeq(data);

        Map<String,Object> param = new HashMap<>();
        param.put("update_date",data.get("tran_date")+""+data.get("tran_time"));
        param.put("order_no",data.get("order_no"));
        param.put("plat_id",data.get("plat_id"));
        param.put("order_status","05");
        if(oneDML.updateVaOrderInfo(param)!=1)throw new BusiException(PubErrorCode.VAZ023.val(),PubErrorCode.VAZ023.code());
    }
}