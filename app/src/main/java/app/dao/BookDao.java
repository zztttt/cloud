package app.dao;

import app.entity.Book;
import java.util.List;

public interface BookDao {
    Book findOne(Integer id);

    List<Book> getBooks();
}
