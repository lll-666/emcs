INSERT INTO CM_BUSINESS_PARA VALUES('1','recharge_cnt','3','商户日最大充值次数','1',(select CURDATE() from dual),'admin');
INSERT INTO CM_BUSINESS_PARA VALUES('1','recharge_amt','20000','商户单笔最大充值金额','1',(select CURDATE() from dual),'admin');
INSERT INTO CM_BUSINESS_PARA VALUES('2','recharge_cnt','3','会员日最大充值次数','1',(select CURDATE() from dual),'admin');
INSERT INTO CM_BUSINESS_PARA VALUES('2','recharge_amt','5000','会员单笔最大充值金额','1',(select CURDATE() from dual),'admin');

INSERT INTO CM_BUSINESS_PARA VALUES('3','withdraw_cnt','3','商户日最大提现次数','1',(select CURDATE() from dual),'admin');
INSERT INTO CM_BUSINESS_PARA VALUES('3','withdraw_amt','20000','商户单笔最大提现金额','1',(select CURDATE() from dual),'admin');
INSERT INTO CM_BUSINESS_PARA VALUES('4','withdraw_cnt','3','会员日最大提现次数','1',(select CURDATE() from dual),'admin');
INSERT INTO CM_BUSINESS_PARA VALUES('4','withdraw_amt','5000','会员单笔最大提现金额','1',(select CURDATE() from dual),'admin');

INSERT INTO CM_BUSINESS_PARA VALUES('56','transfer_cnt','3','商户日最大转账次数','1',(select CURDATE() from dual),'admin');
INSERT INTO CM_BUSINESS_PARA VALUES('56','transfer_amt','20000','商户单笔最大转账金额','1',(select CURDATE() from dual),'admin');
INSERT INTO CM_BUSINESS_PARA VALUES('78','transfer_cnt','3','会员日最大转账次数','1',(select CURDATE() from dual),'admin');
INSERT INTO CM_BUSINESS_PARA VALUES('78','transfer_amt','5000','会员单笔最大转账金额','1',(select CURDATE() from dual),'admin');

INSERT INTO CM_BUSINESS_PARA VALUES('9','purchase_cnt','10','商户日最大采购次数','1',(select CURDATE() from dual),'admin');
INSERT INTO CM_BUSINESS_PARA VALUES('9','purchase_amt','20000','商户单笔最大采购金额','1',(select CURDATE() from dual),'admin');
INSERT INTO CM_BUSINESS_PARA VALUES('10','purchase_cnt','10','会员日最大采购次数','1',(select CURDATE() from dual),'admin');
INSERT INTO CM_BUSINESS_PARA VALUES('10','purchase_amt','5000','会员单笔最大采购金额','1',(select CURDATE() from dual),'admin');