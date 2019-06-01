import com.smart.dao.ClassDao;
import com.smart.dao.UserDao;
import com.smart.domain.*;
import com.smart.domain.Class;
import com.smart.service.BookService;
import com.smart.service.ClassService;
import com.smart.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class userTest {
    @Test
    public  void finduserlogin(){
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("applicationContext.xml");
        /*UserService userService= (UserService) applicationContext.getBean("userService");
        User user= userService.login("201626701122","123456");
        System.out.println(user);
        User user1=userService.selectUserById(2);
        System.out.println(user1);*/
        UserDao userDao= (UserDao) applicationContext.getBean("userDao");
        User user2= userDao.findUserByloginname("201626701122");
        System.out.println(user2);
        /*Role role= userDao.findRoleByloginname("201626701108");
        System.out.println(role);
        System.out.println(permission);*/
    }
    @Test
    public  void findAllbook(){
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService= (BookService) applicationContext.getBean("bookService");
        List<Book> list =bookService.getAllBook();
        list.forEach(book -> System.out.println(book));
        ClassService classService= (ClassService) applicationContext.getBean("classService");
        List<Class> classList=classService.getAllClass();
        classList.forEach(aClass -> System.out.print(aClass));

    }
    /**ShirO之身份验证测试**/
    @Test
    public void testHelloworld() {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）f
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");

        try {
            //4、登录，即身份验证
            subject.login(token);
            System.out.println("登录成功");
        } catch (AuthenticationException e) {
            //5、身份验证失败
            e.printStackTrace();
            System.out.println("登录失败");


        }

        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录

        //6、退出
        subject.logout();
    }
}
