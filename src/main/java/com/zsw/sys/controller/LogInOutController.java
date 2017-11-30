package com.zsw.sys.controller;

import com.zsw.base.Constant;
import com.zsw.base.Result;
import com.zsw.sys.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * 登陆登出Controller
 *
 * @author baizhou
 * @create 2017-11-16 16:56
 */
@Controller
@RequestMapping
public class LogInOutController {

    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String loginForm(Model model){
        model.addAttribute("user", new User());
        return "/WEB-INF/login.jsp";
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    @ResponseBody
    public ModelAndView login(@Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        ModelAndView mav= new ModelAndView();
        Result result =new Result();
        try {
            if(bindingResult.hasErrors()){
                mav.addObject(Constant.CODE,Constant.RESULT_FAILURE);
                mav.addObject(Constant.MSG,"用户名或密码错误！");
                return mav;
            }

            //使用权限工具进行用户登录，登录成功后跳到shiro配置的successUrl中，与下面的return没什么关系！
            SecurityUtils.getSubject().login(new UsernamePasswordToken(user.getUsername(), user.getPassword()));
            return mav;
        } catch (AuthenticationException e) {
            mav.addObject(Constant.CODE,Constant.RESULT_FAILURE);
            mav.addObject(Constant.MSG,"用户名或密码错误！");
            return mav;
        }
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public String logout(RedirectAttributes redirectAttributes ){
        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息
        SecurityUtils.getSubject().logout();
        redirectAttributes.addFlashAttribute("message", "您已安全退出");
        return "redirect:login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        return "403";
    }
}
