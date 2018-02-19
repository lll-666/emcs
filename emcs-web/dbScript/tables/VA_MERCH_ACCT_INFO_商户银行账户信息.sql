DROP TABLE IF EXISTS `VA_MERCH_ACCT_INFO`;
CREATE TABLE `VA_MERCH_ACCT_INFO` (
  `ACCT_ID` VARCHAR(32) NOT NULL COMMENT '账户编号',
  `MERCH_ID` VARCHAR(32) NOT NULL COMMENT '商户编号',
  `ACCT_TYPE` VARCHAR(32) NOT NULL COMMENT '账户类型 0-结算账户,1-交易平台存管专户,2-银行内部账户',
  `ACCT_CATEGORY` VARCHAR(32) NOT NULL COMMENT '账户类别:0-对公,1-对私',
  `ACCT_NO` VARCHAR(32) NOT NULL COMMENT '账户',
  `ACCT_STATUS` VARCHAR(4) NOT NULL COMMENT '账户状态N：正常F：冻结C：注销',
  `TEL_NO` VARCHAR(12) NOT NULL COMMENT '手机号码',
  `ACCT_NAME` VARCHAR(100) DEFAULT NULL COMMENT '账户名称',
  `IS_THIS_BANK` VARCHAR(4) DEFAULT NULL COMMENT '是否本行账户',
  `BANK_NO` VARCHAR(32) DEFAULT NULL COMMENT '开户行号',
  `BANK_NAME` VARCHAR(100) DEFAULT NULL COMMENT '开户行名称',
  `CURRENCY` VARCHAR(4) NOT NULL COMMENT '币种',
  `UPDATE_DATE` DATETIME DEFAULT NULL COMMENT '更新日期',
  `UPDATE_USER` VARCHAR(32) DEFAULT NULL COMMENT '更新操作员',
  PRIMARY KEY (`ACCT_ID`)
) COMMENT='商户银行账户信息表' ;