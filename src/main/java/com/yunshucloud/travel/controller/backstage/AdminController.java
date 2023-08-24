package com.yunshucloud.travel.controller.backstage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunshucloud.travel.pojo.Admin;
import com.yunshucloud.travel.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/backstage/admin")
@Controller
public class AdminController
{
    @Autowired
    private AdminService adminService;

    @RequestMapping("/all")
    public ModelAndView all(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "10") int size){
        ModelAndView modelAndView = new ModelAndView();
        Page<Admin> adminPage = adminService.findPage(page, size);
        modelAndView.addObject("adminPage",adminPage);
        modelAndView.setViewName("/backstage/admin_all");
        return modelAndView;
    }

    @RequestMapping("/add")
    public String add(Admin admin){
        adminService.add(admin);
        return "redirect:/backstage/admin/all";
    }


}
