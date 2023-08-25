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

    //新增管理员
    @RequestMapping("/add")
    public String add(Admin admin){
        adminService.add(admin);
        return "redirect:/backstage/admin/all";
    }


    // 查询管理员 跳转到修改页面
    @RequestMapping("/edit")
    public ModelAndView edit(Integer aid){
        Admin admin = adminService.findById(aid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("admin",admin);
        modelAndView.setViewName("/backstage/admin_edit");
        return modelAndView;
    }


    @RequestMapping("/update")
    public String update(Admin admin){
        adminService.update(admin);
        return "redirect:/backstage/admin/all";
    }


    // 查询用户详情
    @RequestMapping("/desc")
    public ModelAndView desc(Integer aid){
        Admin admin = adminService.findDesc(aid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("admin",admin);
        modelAndView.setViewName("/backstage/admin_desc");
        return modelAndView;
    }



}
