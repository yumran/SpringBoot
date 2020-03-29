package SpringBoot.controller;

import SpringBoot.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("book",new Book());
        return "BookForm";
    }

    @GetMapping("/bookForm")
    public String addBookForm(Model model){
        Book b = new Book();
        b.setId(1);
        b.setName("红楼梦");
        b.setAuthor("曹雪芹");
        model.addAttribute("book",b);
        return "BookForm";
    }

    @PostMapping("/addBook")
    public String addBook(Model model,@ModelAttribute Book book){
        List<Book> books = new ArrayList<>();
        books.add(book);
        model.addAttribute("books",books);
        return "BookList";
    }

    @GetMapping("/getAllBooks")
    @ResponseBody
    /*@RequestMapping("/getAllBooks")*/
    public List<Book> getAllBook(){
        List<Book> books = new ArrayList<>();
        Book b1 = new Book();
        b1.setId(1);
        b1.setName("三国演义");
        b1.setAuthor("罗贯中");

        books.add(b1);
        return books;
    }

    @GetMapping("/BookList")
    public ModelAndView getBookList(){
        List<Book> books = new ArrayList<>();
        Book b1 = new Book();
        b1.setId(1);
        b1.setName("三国演义");
        b1.setAuthor("罗贯中");

        books.add(b1);
        ModelAndView mv = new ModelAndView();
        mv.addObject("books",books);
        mv.setViewName("BookList");
        return mv;
    }

}
