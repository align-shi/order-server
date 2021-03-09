package com.xiaoshi.domain;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor(staticName="of")
public class Product {

    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private BigDecimal price;       //原价格
    @NonNull
    private BigDecimal realPrice;   //真实价格
    @NonNull
    private Integer productType;    //类型
    @NonNull
    private String trait;       //特色
    @NonNull
    private Integer salesVolume;    //销量
    @NonNull
    private Integer stauts;         //状态 0为正常，1为特惠，2为售完，3为下架
    @NonNull
    private String detail;      //详情

    private byte[] image;       //图片实体，备用（目前微信小程序不支持）
    private String imageUrl;    //图片路径
    private Integer good;           //好评度

    //以下属性适配前端操作
    private Integer num;            //某次具体购买的数量
    private BigDecimal subtotal;
    private Integer orderId;
    private boolean isSelected=true;  //是否选择

    public BigDecimal getRealPrice() {
        return realPrice;
    }
}