package com.yunshucloud.travel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunshucloud.travel.mapper.CategoryMapper;
import com.yunshucloud.travel.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public Page<Category> findPage(int page, int size){
        return categoryMapper.selectPage(new Page(page,size),null);
    }

    public void add(Category category){
        categoryMapper.insert(category);
    }

    public Category findById(Integer cid){
        return categoryMapper.selectById(cid);
    }

    public void update(Category category){
        categoryMapper.updateById(category);
    }

    public void delete(Integer cid){
        categoryMapper.deleteById(cid);
    }
}
