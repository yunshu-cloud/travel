package com.yunshucloud.travel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunshucloud.travel.mapper.AdminMapper;
import com.yunshucloud.travel.mapper.RoleMapper;
import com.yunshucloud.travel.pojo.Admin;
import com.yunshucloud.travel.pojo.Role;
import com.yunshucloud.travel.pojo.RoleWithStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService
{
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private RoleMapper roleMapper;

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

    // 查询用户详情
    public Admin findDesc(Integer aid){
         return adminMapper.findDesc(aid);
    }

    // 查询用户的角色情况
    public List<RoleWithStatus> findRole(Integer aid){
        // 查询所有角色
        List<Role> roles = roleMapper.selectList(null);
        // 查询用户拥有的所有角色id
        List<Integer> rids = roleMapper.findRoleIdByAdmin(aid);


        // 带有状态的角色集合
        List<RoleWithStatus> roleList = new ArrayList();
        // 遍历所有角色
        for (Role role:roles){
            // 创建带有状态的角色
            RoleWithStatus roleWithStatus = new RoleWithStatus();
            // 将角色属性复制给带有状态的角色
            BeanUtils.copyProperties(role,roleWithStatus);
            if(rids.contains(role.getRid())){ //用户拥有该角色，角色状态设置为true
                roleWithStatus.setAdminHas(true);
            }else { //用户不拥有该角色，角色状态设置为false
                roleWithStatus.setAdminHas(false);
            }
            roleList.add(roleWithStatus);
        }
        return roleList;
    }


}
