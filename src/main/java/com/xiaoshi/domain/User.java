package com.xiaoshi.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private String password;
}