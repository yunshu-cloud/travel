package com.yunshucloud.travel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunshucloud.travel.mapper.ProductMapper;
import com.yunshucloud.travel.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;


    public Page<Product> findPage(int page, int size){
        Page selectPage = productMapper.findProductPage(new Page(page, size));
        return selectPage;
    }


    public void add(Product product){
        productMapper.insert(product);
    }


}

