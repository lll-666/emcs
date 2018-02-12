package com.emcs.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/2/2.
 */
public interface OneTableSelectMapper{

    List<Map<String,Object>> selectVaVirtualAcctType(Map<String, Object> param);
    int selectIsExistVaMerchInfo(Map<String, Object> param);
    int selectIsExistVaPlatInfo(Map<String, Object> param);
    int selectIsExistVaCustInfo(Map<String, Object> param);

    List<Map<String,Object>> selectPlatInfo(Map<String, Object> param);

    List<Map<String,Object>> selectMerchInfo(Map<String, Object> param);
    List<Map<String,Object>> selectVaMerchVirtualAcctInfo(Map<String, Object> param);
    List<Map<String,Object>> selectVaMerchRechargeSeqSum(Map<String, Object> param);
    List<Map<String,Object>> selectVaMerchVirtualAcctBalLock(Map<String, Object> param);
    List<Map<String,Object>> selectVaMerchAcctInfo(Map<String, Object> param);


    List<Map<String,Object>> selectVaCustVirtualAcctInfo(Map<String, Object> param);
    List<Map<String,Object>> selectVaCustRechargeDetail(Map<String, Object> param);
    List<Map<String,Object>> selectVaCustRechargeSeqSum(Map<String, Object> param);
    List<Map<String,Object>> selectVaCustVirtualAcctBalLock(Map<String, Object> param);
    List<Map<String,Object>> selectVaCustAcctInfo(Map<String, Object> param);


    List<Map<String,Object>> selectCmBusinessParaForCache(Map<String, Object> param);
    List<Map<String,Object>> selectCmSystemForCache(Map<String, Object> param);

    List<Map<String,Object>> selectVaVirAcctSeq(Map<String, Object> param);
    List<Map<String,Object>> selectDbTableColumns(Object param);
    List<Object> selectDbTables(Map<String,Object> param);
    String getNextVal(String param);


}
