package com.yunshucloud.travel;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunshucloud.travel.mapper.AdminMapper;
import com.yunshucloud.travel.pojo.Admin;
import com.yunshucloud.travel.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TravelApplicationTests
{

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminMapper adminMapper;

    @Test
    void contextLoads()
    {
        Page<Admin> page = adminService.findPage(1, 5);
        System.out.println(page);
    }

    @Test
    void testFindAdminDesc(){
        Admin desc = adminMapper.findDesc(1);
        System.out.println(desc);

    }

}
