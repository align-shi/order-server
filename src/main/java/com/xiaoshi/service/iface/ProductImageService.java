package com.xiaoshi.service.iface;

import com.xiaoshi.domain.ProductImage;

public interface ProductImageService {

    public boolean addImage(ProductImage productImage);
    public ProductImage getImageById(int id);
}
