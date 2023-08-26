package com.yunshucloud.travel.security;

import com.yunshucloud.travel.pojo.Admin;
import com.yunshucloud.travel.pojo.Permission;
import com.yunshucloud.travel.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//自定义认证授权逻辑
@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private AdminService adminService;

    // 查询用户 封装成UserDetails对象返回给Spring Security
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1.认证
        Admin admin = adminService.findByAdminName(username);
        if(admin == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        if(!admin.isStatus()){
            throw new UsernameNotFoundException("用户不可用");
        }

        // 2.授权
        List<Permission> permissions = adminService.findAllPermission(username);
        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Permission permission : permissions){
            grantedAuthorities.add(new SimpleGrantedAuthority(permission.getPermissionDesc()));
        }

        // 封装为UserDetails对象
        UserDetails userDetails = User.withUsername(admin.getUsername())
                .password(admin.getPassword())
                .authorities(grantedAuthorities)
                .build();

        return userDetails;
    }
}
