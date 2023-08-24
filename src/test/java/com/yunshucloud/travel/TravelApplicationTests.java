package com.yunshucloud.travel;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    @Test
    void contextLoads()
    {

        Page<Admin> page = adminService.findPage(1, 5);
        System.out.println(page);
    }

}
