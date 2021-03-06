package com.xiaoshi.domain;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor(staticName="of")
public class Product {

    private int id;
    @NonNull
    private String name;
    @NonNull
    private BigDecimal price;       //原价格
    @NonNull
    private BigDecimal realPrice;   //真实价格
    @NonNull
    private int productType;    //类型
    @NonNull
    private String trait;       //特色
    @NonNull
    private int salesVolume;    //销量
    @NonNull
    private int stauts;         //状态 0为正常，1为特惠，2为售完，3为下架
    @NonNull
    private String detail;      //详情

    private byte[] image;       //图片实体，备用（目前微信小程序不支持）
    private String imageUrl;    //图片路径
    private int good;           //好评度

    //以下属性适配前端操作
    private int num;            //某次具体购买的数量
    private BigDecimal subtotal;
    private int orderId;
    private boolean isSelected=true;  //是否选择
}