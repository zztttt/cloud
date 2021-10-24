package app.controller;

import app.entity.Book;
import app.service.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RequestMapping("/bookstore")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/getBooks")
    public List<Book> getBooks(HttpSession session) {
        log.info("current session id: {}", session.getId());
        List<Book> ret = bookService.getBooks();
        log.info("getBooks count:{}", ret.size());
        return ret;
    }

    @GetMapping("/getBook")
    public Book getBook(@RequestParam("id") Integer id, HttpSession session){
        log.info("current session id: {}", session.getId());
        Book book = bookService.findBookById(id);
        return book;
    }
}
