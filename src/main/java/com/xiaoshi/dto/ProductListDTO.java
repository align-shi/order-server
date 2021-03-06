package com.xiaoshi.dto;

import com.xiaoshi.config.BaseSearchDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductListDTO extends BaseSearchDTO {

    private String productName;

    private String type;
}
