package com.xiaoshi.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Desk {
    private Integer id;
    @NonNull
    private String deskNumber;
    @NonNull
    private String remark;
}