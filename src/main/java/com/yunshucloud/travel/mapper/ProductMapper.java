package com.yunshucloud.travel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunshucloud.travel.pojo.Product;

public interface ProductMapper extends BaseMapper<Product> {
    Page<Product> findProductPage(Page<Product> page);

    Product findOne(int pid);
}
