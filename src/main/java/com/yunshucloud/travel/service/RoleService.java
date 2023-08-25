package com.yunshucloud.travel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunshucloud.travel.mapper.RoleMapper;
import com.yunshucloud.travel.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;

    // 分页查询显示
    public Page<Role> findPage(int page,int size){
        Page selectPage = roleMapper.selectPage(new Page(page,size),null);
        return selectPage;
    }

    // 添加角色
    public void add(Role role){
        roleMapper.insert(role);
    }

    public Role findById(Integer rid){
        return roleMapper.selectById(rid);
    }

    public void update(Role role){
        roleMapper.updateById(role);
    }

}
