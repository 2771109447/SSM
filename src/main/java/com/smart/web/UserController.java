package com.smart.web;

import com.github.pagehelper.PageHelper;
import com.smart.domain.Class;
import com.smart.domain.User;
import com.smart.service.ClassService;
import com.smart.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;
    @Autowired
    @Qualifier("classService")
    private ClassService classService;
    //用户登录
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String  login(String loginname, String password,Model model){
        Subject subject = SecurityUtils.getSubject() ;
        UsernamePasswordToken  token = new UsernamePasswordToken(loginname,password);
        try{
            subject.login(token);
            return  "admin";
        }catch (AuthenticationException e){
            e.printStackTrace();
            model.addAttribute("error","用户名或密码错误") ;
            return "loginForm";
        }
    }
    /*//用户登录
    @RequestMapping(value = "/login",method = RequestMethod.GET )
    public String login(String loginname, String password, HttpSession session){
     User user =userService.login(loginname,password);
        session.setAttribute("user",user);
        return  "redirect:/books/";

    }*/

    //查询所有用户信息
    @RequestMapping(value="/",method = RequestMethod.GET )
    public String  selectAllUser(Model model){
        PageHelper.startPage(1, 2);
        List<User> userList=userService.selectAllUser();
        model.addAttribute("userList",userList);
        return "user/user";
    }
    //新增一名用户
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public  String toRegister(Model model,User user){
        model.addAttribute("user",user);
        List<Class> classList=classService.getAllClass();
        model.addAttribute("classList", classList);
        return "user/register";
    }
    @RequestMapping(value="/",method = RequestMethod.POST )
    public  String  insertUser(User user){
              userService.insertUser(user);
              return   "redirect:/users/"  ;

    }
    //删除一名用户
    @RequestMapping(value="/{id}",method =RequestMethod.DELETE )
    public void deleteUser(@PathVariable int id, HttpServletResponse response) throws IOException {
            userService.deleteUser(id);
            response.getWriter().print("ifh");
    }
    //更新一名用户
    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public String toUpdate(Model model,User user,@PathVariable int id){
        user=userService.selectUserById(id);
        model.addAttribute("user",user);
        List<Class> classList=classService.getAllClass();
        model.addAttribute("classList", classList);
            return "user/register";

    }
    @RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public  String Update(User user ,@PathVariable int id){
        user.setUserId(id);
        userService.updateUser(user);
        return "redirect:/users/";
    }

}
