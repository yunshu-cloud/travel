package com.yunshucloud.travel.controller.frontdesk;

import com.yunshucloud.travel.bean.Result;
import com.yunshucloud.travel.pojo.Member;
import com.yunshucloud.travel.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/frontdesk/member")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @RequestMapping("/register")
    public ModelAndView register(Member member, String checkCode, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        // 判断验证码是否正确 sessionCheckCode是在CheckCodeServlet中放入session的
        String sessionCheckCode = (String) session.getAttribute("checkCode");
        if (!sessionCheckCode.equalsIgnoreCase(checkCode)){
            modelAndView.addObject("message","验证码错误");
            modelAndView.setViewName("/frontdesk/register");
            return modelAndView;
        }


        // 注册
        Result result = memberService.register(member);
        if (!result.isFlag()){ // 注册失败
            modelAndView.addObject("message",result.getMessage());
            modelAndView.setViewName("/frontdesk/register");
        }else { // 注册成功
            modelAndView.setViewName("/frontdesk/register_ok");
        }
        return modelAndView;
    }



    @RequestMapping("/active")
    public ModelAndView active(String activeCode) {
        ModelAndView modelAndView = new ModelAndView();
        String active = memberService.active(activeCode);
        modelAndView.addObject("message",active);
        modelAndView.setViewName("/frontdesk/active_result");
        return modelAndView;
    }


    @RequestMapping("/login")
    public ModelAndView register(String name,String password,HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        Result result = memberService.login(name,password);
        if(!result.isFlag()){ // 登录失败
            modelAndView.addObject("message",result.getMessage());
            modelAndView.setViewName("/frontdesk/login");
        }else{ // 登录成功
            session.setAttribute("member",result.getData()); // 将用户信息存入session
            modelAndView.setViewName("redirect:/frontdesk/index");
        }
        return modelAndView;
    }


}