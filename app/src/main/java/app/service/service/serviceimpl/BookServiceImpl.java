package app.service.service.serviceimpl;

import app.dao.BookDao;
import app.entity.Book;
import app.service.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Book findBookById(Integer id){
        return bookDao.findOne(id);
    }

    @Override
    public List<Book> getBooks() {
        List<Book> books = bookDao.getBooks();
        //log.info("books count: {}", books.size());
        return books;
    }
}
