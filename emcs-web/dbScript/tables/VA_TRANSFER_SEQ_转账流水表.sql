DROP TABLE IF EXISTS VA_TRANSFER_SEQ;
CREATE TABLE VA_TRANSFER_SEQ(
	TRANSFER_SEQ_NO VARCHAR(32) NOT NULL COMMENT '内部转账流水号',
	PUB_SEQ_NO VARCHAR(32) NOT NULL COMMENT '公共流水号',
	ORDER_NO VARCHAR(32) NOT NULL COMMENT '业务流水号',
	PLAT_ID VARCHAR(32) NOT NULL COMMENT '平台编号',
	PAYER_ID  VARCHAR(32) NOT NULL COMMENT '付款方编号',
	PAYER_VIRID  VARCHAR(32) NOT NULL COMMENT '付款方虚拟账户编号',
	PAYEE_ID VARCHAR(32) NOT NULL COMMENT '收款方编号',
	PAYEE_VIRID  VARCHAR(32) NOT NULL COMMENT '收款方虚拟账户编号',
	PAY_TYPE VARCHAR(4) NOT NULL COMMENT '支付方式',
	TRAN_AMT DECIMAL(10,2) COMMENT '交易金额=使用的可用金额+使用的充值金额',
	TRAN_TYPE VARCHAR(4) NOT NULL COMMENT '交易类型',
	CREATE_DATE DATE  NOT NULL COMMENT '订单创建时间',
	PRIMARY KEY(TRANSFER_SEQ_NO)
)COMMENT '转账流水表';