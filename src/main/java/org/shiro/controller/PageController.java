package org.shiro.controller;

import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 视图控制器,返回jsp视图给前端
 * 
 * @author StarZou
 * @since 2014年5月28日 下午4:00:49
 **/
@Controller
@RequestMapping("/page")
public class PageController {

    /**
     * 登录页
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * dashboard页
     */
    @RequestMapping("/dashboard")
    public String dashboard() { 
        return "dashboard";
    }

    /**
     * 404页
     */
    @RequestMapping("/404")
    public String error404() {
        return "404";
    }

    /**
     * 401页
     */
    @RequestMapping("/401")
    public String error401() {
        return "401";
    }

    /**
     * 500页
     */
    @RequestMapping("/500")
    public String error500() {
        return "500";
    }

    @RequestMapping("/returnView")
    public ModelAndView returnView(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        SavedRequest savedRequest = WebUtils.getSavedRequest(request);
        String requestURI = "/";
        if(null != savedRequest) {
            requestURI = savedRequest.getRequestURI();
        }
        if(requestURI.contains("rest")){
            modelAndView.setViewName("redirect:/rest/index");
        }else if(requestURI.contains("course")){
            modelAndView.setViewName("redirect:/course/admin/page/index");
        }
        return modelAndView;
    }

}