DROP TABLE IF EXISTS VA_ORDER_INFO;
CREATE TABLE VA_ORDER_INFO(
	ODER_SEQ_NO VARCHAR(32) COMMENT '内部订单流水号',
	ORDER_NO  VARCHAR(32) NOT NULL COMMENT '订单号',
	ORDER_NO_OLD  VARCHAR(32) NOT NULL COMMENT '订单号',
	CM_SEQ_NO VARCHAR(32) NOT NULL COMMENT '内部系统流水号',
	PLAT_ID VARCHAR(32) NOT NULL COMMENT '平台编号',
	PLAT_VIRID VARCHAR(6) NOT NULL COMMENT '平台虚拟账户编号',
	BUYER_ID  VARCHAR(32) NOT NULL COMMENT '买方编号',
	BUYER_VIRID  VARCHAR(32) NOT NULL COMMENT '买方虚拟账户编号',
	SELLER_ID VARCHAR(32) NOT NULL COMMENT '卖方编号',
	SELLER_VIRID  VARCHAR(32) NOT NULL COMMENT '卖方虚拟账户编号',
	PAY_TYPE VARCHAR(4) NOT NULL COMMENT '支付方式',
	TRAN_AMT DECIMAL(10,2) COMMENT '交易金额=使用的可用金额+使用的充值金额',
	USABLE_BAL DECIMAL(10,2) COMMENT '使用的可用金额',
	RECHARGE_BAL DECIMAL(10,2) COMMENT '使用的充值金额',
	TRAN_TYPE VARCHAR(4) NOT NULL COMMENT '交易类型',
	ORDER_STATUS  VARCHAR(4) NOT NULL COMMENT '订单状态',
	CREATE_DATE DATE  NOT NULL COMMENT '订单创建时间',
	UPDATE_DATE DATE COMMENT '订单更新时间',
	PRIMARY KEY(ODER_SEQ_NO)
)COMMENT '订单信息表';