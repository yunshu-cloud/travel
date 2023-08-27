package com.yunshucloud.travel;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunshucloud.travel.mapper.AdminMapper;
import com.yunshucloud.travel.pojo.Admin;
import com.yunshucloud.travel.service.AdminService;
import com.yunshucloud.travel.util.MailUtils;
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

    @Autowired
    private MailUtils mailUtils;

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


    /**
     * 测试邮件发送
     */
    @Test
    void sendMail() {
        mailUtils.sendMail("2099266050@qq.com","这是一封测试邮件","测试");
        System.out.println("Send Successfully!");
    }


}
