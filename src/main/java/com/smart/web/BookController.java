package com.smart.web;

import com.smart.domain.Book;
import com.smart.service.BookService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController{

    private static final Log logger= LogFactory.getLog(BookController.class);

    @Autowired
    @Qualifier("bookService")
    private BookService bookService;
   /**数据格式化
    @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder ) {
        SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
        dateFormat.setLenient( false );
        binder.registerCustomEditor( Date.class, new CustomDateEditor( dateFormat, false ) );
    }
    --**/
    //获取所有图书信息
    @RequestMapping(value ="/",method =RequestMethod.GET)
    public String main(Model model, @CookieValue(value = "JSESSIONID", required=false) String sessionID){
        List<Book> bookList=bookService.getAllBook();
        model.addAttribute("bookList", bookList);
        return "book/main";
    }
   //添加图书
    @RequestMapping(value ="/insert",method =RequestMethod.GET )
    public  String toBook(Book book,Model model){
        model.addAttribute("book",book);
        return "addBook";
    }
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String addBook(Book book){
                  bookService.addBook(book);
                   return "redirect:/books/";
    }


}
