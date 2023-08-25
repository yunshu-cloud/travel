package com.yunshucloud.travel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yunshucloud.travel.pojo.Role;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {
    // 查询用户拥有的所有角色ID
    List<Integer> findRoleIdByAdmin(Integer aid);
}
