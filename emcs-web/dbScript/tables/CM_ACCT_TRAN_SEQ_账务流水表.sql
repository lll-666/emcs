drop table if exists  `cm_acct_tran_seq`;
create table `cm_acct_tran_seq` (
  `tran_seq_no`           varchar(32)       not null comment '银行账务流水号',
   `pub_seq_no` varchar(32) not null comment '公共流水号',
  `tran_date`             date comment '交易日期',
  `tran_time`             varchar(10) comment '交易时间',
  `curreny`               varchar(4) comment '币种',
  `tran_amt`              decimal(17,2) comment '交易金额',
  `tran_type`             varchar(16) comment '交易类型',
 `business_code`         varchar(16) comment '业务编码',
  `business_name`         varchar(100) comment '业务编码名称',
  `order_no`              varchar(32) comment '业务流水号',
  `order_no_old`             varchar(32) comment '原业务流水号',
  `ref_no`        varchar(32) comment '金融参考号',
  `merch_id`         varchar(32) comment '商户编号',
  `merch_name`       varchar(100) comment '商户名称',
  `cust_id` varchar(32) comment '会员编号',
  `cust_name`       varchar(100) comment '会员名称',
  `payer_name`            varchar(100) comment '付款方名称',
  `payer_vir_acct_no`     varchar(32) comment '付款人虚拟账户',
  `payee_name`            varchar(100) comment '收款方名称',
  `payee_vir_acct_no`     varchar(32) comment '收款方虚拟账户',
  `plat_id`              varchar(32) comment '平台编号',
  `plat_name`          varchar(100) comment '平台名称',
  `payer_acct_no`         varchar(32) comment '付款方账户',
  `payer_acct_name`       varchar(100) comment '付款方账户名称',
  `payer_acct_sort`       varchar(4) comment '付款方账户类别：0会员；1商户；2交易平台',
  `payer_is_this_bank`    varchar(4) comment '付款方账户是否我行',
  `payer_acct_bank_no`    varchar(32) comment '付款方账户行号',
  `payer_acct_bank_name`  varchar(100) comment '付款方账户行名称',
  `payee_acct_no`         varchar(32) comment '收款方账户账户',
  `payee_acct_name`       varchar(100) comment '收款方账户名称',
  `payee_acct_sort`       varchar(4) comment '收款方账户类别：0会员；1商户；2交易平台',
  `payee_is_this_bank`    varchar(4) comment '收款方账户是否我行',
  `payee_acct_bank_no`   varchar(32) comment '收款方账户行号',
  `payee_acct_bank_name`  varchar(100) comment '收款方账户行名称',
  `tran_status`           varchar(4) comment '交易状态:00-未发起,01-成功,02-失败,03-已冲正',
  `ret_code`              varchar(16) comment '响应码',
  `ret_msg`               varchar(200) comment '响应信息',
  `host_seq_no`          varchar(32) comment '关联系统流水号',
  `host_tran_status`      varchar(2) comment '关联系统交易状态',
  `is_check`              varchar(4) comment '是否参与对账',
  `is_recover`            varchar(4) comment '是否冲正',
  `reversed`              varchar(4) comment '是否已被冲正',
  `oper_time`             varchar(20) comment '操作时间',
  `user_id`               varchar(32) comment '柜员id',
  `contrast`              varchar(4) comment '对账状态:0-未对账,1-平账,2-差错,3-状态不一致,4-单边',
  `refund_status`         varchar(4) comment '退款状态',
  primary key (`tran_seq_no`)
)comment '账务流水表';