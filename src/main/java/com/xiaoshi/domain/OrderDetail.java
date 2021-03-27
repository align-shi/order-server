package com.xiaoshi.domain;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class OrderDetail {

    private int id;
    @NonNull
    private int orderId;        //订单号(流水号)
    @NonNull
    private int productId;      //商品id
    @NonNull
    private String productName; //商品名称
    @NonNull
    private BigDecimal productPrice;    //商品价格
    @NonNull
    private int productNumber;          //商品个数
    @NonNull
    private BigDecimal subtotal;        //小计价格

    private Integer status;

    private String imageUrl;

}