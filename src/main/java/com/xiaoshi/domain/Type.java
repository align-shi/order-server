package com.xiaoshi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type {
    private Integer id;
    private String typeName;
    private String remark;
    private int sort;

}