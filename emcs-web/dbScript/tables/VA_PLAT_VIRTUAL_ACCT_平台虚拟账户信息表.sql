DROP TABLE IF EXISTS `VA_PLAT_VIRTUAL_ACCT`;
CREATE TABLE `VA_PLAT_VIRTUAL_ACCT` (
  `PLAT_VIRID` VARCHAR(32) NOT NULL COMMENT '平台虚拟账户编号',
  `PLAT_ID` VARCHAR(32) NOT NULL COMMENT '平台编号',
  `VIR_ACCT_TYPE` VARCHAR(16) NOT NULL COMMENT '账户类型',
  `VIR_ACCT_SORT` VARCHAR(16) NOT NULL COMMENT '账户归属类别 1：会员 2：平台 3：交易平台',
  `VIR_ACCT_NAME` VARCHAR(100) NOT NULL COMMENT '虚拟账户名称',
  `CURRENCY` VARCHAR(4) NOT NULL COMMENT '币种',
  `ACCT_STATUS` VARCHAR(4) NOT NULL COMMENT '账户状态 N：正常 F：冻结C：注销',
  `acct_no` VARCHAR(32) NOT NULL COMMENT '关联银行账户',
  `IS_IN` VARCHAR(4) NOT NULL COMMENT '是否允许转入Y：是 N:否',
  `IS_OUT` VARCHAR(4) NOT NULL COMMENT '是否允许转出Y：是 N:否',
  `IS_TOTAL_LIMIT` VARCHAR(4) DEFAULT NULL COMMENT '是否有总额限制Y：是 N:否',
  `TOTAL_LIMIT` DECIMAL(17,2) DEFAULT NULL COMMENT '总额限制',
  `IS_BALANCE_LIMIT` VARCHAR(4) DEFAULT NULL COMMENT '是否留备付金Y：是 N:否',
  `BALANCE_TYPE` VARCHAR(4) DEFAULT NULL COMMENT '备付金限额方式',
  `BALANCE_VALUE` DECIMAL(17,2) DEFAULT NULL COMMENT '备付金限额数值',
  `OPEN_DATE` DATETIME DEFAULT NULL COMMENT '开户日期',
  `OPEN_USER` VARCHAR(32) DEFAULT NULL COMMENT '开户操作员',
  `CANCEL_DATE` DATETIME DEFAULT NULL COMMENT '销户日期',
  `CANCEL_USER` VARCHAR(32) DEFAULT NULL COMMENT '销户操作员',
  `UPDATE_DATE` DATETIME DEFAULT NULL COMMENT '状态更新日期',
  `SOURCE_USER` VARCHAR(32) DEFAULT NULL COMMENT '状态更新操作员',
  `EFFECT_DATE` DATETIME DEFAULT NULL COMMENT '有效期',
  `PLAT_NAME` VARCHAR(32) DEFAULT NULL COMMENT '平台名称',
  PRIMARY KEY (`PLAT_VIRID`)
) ;