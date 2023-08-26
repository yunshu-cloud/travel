package com.yunshucloud.travel.controller.backstage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunshucloud.travel.pojo.Permission;
import com.yunshucloud.travel.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/backstage/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/all")
    public ModelAndView all(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        Page<Permission> permissionPage = permissionService.findPage(page, size);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("permissionPage", permissionPage);
        modelAndView.setViewName("/backstage/permission_all");
        return modelAndView;
    }

    @RequestMapping("/add")
    public String add(Permission permission){
        permissionService.add(permission);
        return "redirect:/backstage/permission/all";
    }
}
