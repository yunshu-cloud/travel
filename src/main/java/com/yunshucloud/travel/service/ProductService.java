package com.yunshucloud.travel.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunshucloud.travel.mapper.ProductMapper;
import com.yunshucloud.travel.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional
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

    public Product findOne(int pid){
        Product product = productMapper.findOne(pid);
        return product;
    }


    public void update(Product product){
        productMapper.updateById(product);
    }

    public void updateStatus(Integer pid){
        Product product = productMapper.selectById(pid);
        product.setStatus(!product.getStatus());
        productMapper.updateById(product);
    }


    public Page<Product> findProduct(Integer cid,String productName,int page, int size){
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        if (cid != null){
            queryWrapper.eq("cid",cid);
        }
        if (StringUtils.hasText(productName)){
            queryWrapper.like("productName",productName);
        }
        // 还在启用的旅游产品
        queryWrapper.eq("status",1);
        // 倒序排列
        queryWrapper.orderByDesc("pid");


        Page selectPage = productMapper.selectPage(new Page(page,size),queryWrapper);
        return selectPage;
    }



}

