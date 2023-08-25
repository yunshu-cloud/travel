package com.yunshucloud.travel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunshucloud.travel.mapper.AdminMapper;
import com.yunshucloud.travel.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService
{
    @Autowired
    private AdminMapper adminMapper;

    // 分页查询管理员
     public Page<Admin> findPage(int page,int size){
         Page selectPage = adminMapper.selectPage(new Page(page, size), null);
         return selectPage;
     }

     // 新增管理员
     public void add(Admin admin){
         adminMapper.insert(admin);
     }


     // 查询管理员
     public Admin findById(Integer aid){
         return adminMapper.selectById(aid);
     }

     // 修改管理员
    public void update(Admin admin){
         adminMapper.updateById(admin);
    }
}
