package com.yunshucloud.travel.controller.backstage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunshucloud.travel.pojo.Role;
import com.yunshucloud.travel.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/backstage/role")
public class RoleController {
    @Autowired
    private RoleService roleService;


    // 分页查询显示
    @RequestMapping("/all")
    public ModelAndView all(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        Page<Role> rolePage = roleService.findPage(page, size);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("rolePage", rolePage);
        modelAndView.setViewName("/backstage/role_all");
        return modelAndView;
    }

    @RequestMapping("/add")
    public String add(Role role){
        roleService.add(role);
        return "redirect:/backstage/role/all";
    }
}

