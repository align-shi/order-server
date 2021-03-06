package com.xiaoshi.domain;

import lombok.*;
import org.springframework.stereotype.Component;

import java.sql.Blob;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@Component
public class ProductImage {

    private int id;
    @NonNull
    private String name;
    @NonNull
    private int productId;
    @NonNull
    private byte[] image;
    private String imageUrl;
    private String remark;

}