package com.yunshucloud.travel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunshucloud.travel.mapper.PermissionMapper;
import com.yunshucloud.travel.pojo.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    public Page<Permission> findPage(int page,int size){
        Page selectPage = permissionMapper.selectPage(new Page(page,size),null);
        return selectPage;
    }

    // 添加权限
    public void add(Permission permission){
        permissionMapper.insert(permission);
    }

    public Permission findById(Integer pid){
        return permissionMapper.selectById(pid);
    }

    public void update(Permission permission){
        permissionMapper.updateById(permission);
    }

    public void delete(Integer pid){
        permissionMapper.deleteById(pid);
    }
}
