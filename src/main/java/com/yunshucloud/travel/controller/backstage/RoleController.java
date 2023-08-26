package com.yunshucloud.travel.controller.backstage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunshucloud.travel.pojo.PermissionWithStatus;
import com.yunshucloud.travel.pojo.Role;
import com.yunshucloud.travel.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    // 添加角色
    @RequestMapping("/add")
    public String add(Role role){
        roleService.add(role);
        return "redirect:/backstage/role/all";
    }


    // 修改角色的预查询 将要修改的角色信息显示在页面上
    @RequestMapping("/edit")
    public ModelAndView edit(Integer rid) {
        Role role = roleService.findById(rid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("role", role);
        modelAndView.setViewName("/backstage/role_edit");
        return modelAndView;
    }


    // 修改角色操作
    @RequestMapping("/update")
    public String update(Role role) {
        roleService.update(role);
        return "redirect:/backstage/role/all";
    }

    @RequestMapping("/delete")
    public String delete(Integer rid){
        roleService.delete(rid);
        return "redirect:/backstage/role/all";
    }


    @RequestMapping("/findPermission")
    public ModelAndView findPermission(Integer rid) {
        List<PermissionWithStatus> permissions = roleService.findPermission(rid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("permissions", permissions);
        modelAndView.addObject("rid", rid);
        modelAndView.setViewName("/backstage/role_permission");
        return modelAndView;
    }


}

