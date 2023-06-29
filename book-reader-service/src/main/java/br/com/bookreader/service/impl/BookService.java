package br.com.bookreader.service.impl;

import br.com.bookreader.domain.entity.BookFileEntity;
import br.com.bookreader.data_access.repository.BookRepository;
import br.com.bookreader.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookFileEntity> findAllByCustomerId(String customerId) {
        return bookRepository.findAllByCustomerId(customerId);
    }

    public void create(String customerId, BookFileEntity book) {
        book.setCustomerId(customerId);
        bookRepository.save(book);
    }

    public void delete(int bookFileId) {
        if(bookRepository.existsById(bookFileId)){
            bookRepository.deleteById(bookFileId);
        }
    }

}
