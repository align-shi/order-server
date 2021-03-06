package com.xiaoshi.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Order {

    private int id;
    @NonNull
    private String serialNumber;    //订单号（流水号）
    @NonNull
    private int deskId;
    @NonNull
    private int tradeStatus;
    @NonNull
    private int payStatus;
    @NonNull
    private BigDecimal orderAmount;
    @NonNull
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    private String remark;

    //适配前端
    private String[] ids;
    private List<Product> shoppingCart;
}