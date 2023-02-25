package com.bizzan.bitrade.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.bizzan.bitrade.constant.BooleanEnum;
import com.bizzan.bitrade.constant.WithdrawStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 提币申请
 *
 * @author Hevin QQ:390330302 E-mail:bizzanex@gmail.com
 * @date 2020年01月29日
 */
@Entity
@Data
public class WithdrawRecord {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * 申请人id
     */
    private Long memberId;
    /**
     * 币种
     */
    @JoinColumn(name = "coin_id", nullable = false)
    @ManyToOne
    private Coin coin;
    /**
     * 申请总数量
     */
    @Column(columnDefinition = "decimal(18,8) comment '申请总数量'")
    private BigDecimal totalAmount;
    /**
     * 手续费
     */
    @Column(columnDefinition = "decimal(18,8) comment '手续费'")
    private BigDecimal fee;
    /**
     * 预计到账数量
     */
    @Column(columnDefinition = "decimal(18,8) comment '预计到账数量'")
    private BigDecimal arrivedAmount;
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dealTime;
    /**
     * 提现状态
     */
    @Enumerated(EnumType.ORDINAL)
    private WithdrawStatus status = WithdrawStatus.PROCESSING;
    /**
     * 是否是自动提现
     */
    @Enumerated(EnumType.ORDINAL)
    private BooleanEnum isAuto;
    /**
     * 审核人
     */
    @JoinColumn(name = "admin_id")
    @ManyToOne
    private Admin admin;
    @Enumerated(EnumType.ORDINAL)
    private BooleanEnum canAutoWithdraw;

    /**
     * 交易编号
     */
    private String transactionNumber;
    /**
     * 提现地址
     */
    private String address;

    private String remark;

    @Excel(name = "协议ID", orderNum = "1", width = 20)
    private Integer protocol;

    @Excel(name = "协议名称", orderNum = "1", width = 20)
    private String protocolname;
}
