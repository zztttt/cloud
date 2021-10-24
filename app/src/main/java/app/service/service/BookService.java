package app.service.service;

import app.entity.Book;
import java.util.List;

public interface BookService {

    Book findBookById(Integer id);

    List<Book> getBooks();
}
