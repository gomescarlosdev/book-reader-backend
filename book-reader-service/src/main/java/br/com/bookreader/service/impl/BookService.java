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
//    private final CustomerService customerService;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
//        this.customerService = customerService;
    }

    public List<BookFileEntity> findAll(String customerId) {
//        return bookRepository.findAllByCustomerId(customerId);
        return null;
    }

    public List<BookFileEntity> findAllByIsFavorite(String customerId) {
//        return bookRepository.findAllByStatus(customerId);
        return null;
    }
//
//    public BookEntity findById(int id) {
//        Optional<BookEntity> book = bookRepository.findById(id);
//        if (book.isEmpty()) {
//            throw new NotFoundException(String.format(Errors.BM_1001.getMessage(), id), Errors.BM_1001.getCode());
//        }
//        return book.get();
//    }
//
    public void create(int customerId, BookFileEntity book) {
        book.setCustomerId(customerId);
        bookRepository.save(book);
    }
//
//    public void update(BookEntity book) {
//        if (book.getStatus() == BookStatus.DELETED) {
//            throw new BadRequestException(String.format(Errors.BM_1002.getMessage(), "UPDATE", book.getStatus()), Errors.BM_1002.getCode());
//        }
//        bookRepository.save(book);
//    }
//
//    public void delete(int id) {
//        BookEntity book = findById(id);
//        if (book.getStatus() == BookStatus.DELETED) {
//            throw new BadRequestException(String.format(Errors.BM_1002.getMessage(), "DELETE", book.getStatus()), Errors.BM_1002.getCode());
//        }
//        book.setStatus(BookStatus.DELETED);
//        bookRepository.save(book);
//    }
//
//    @Transactional
//    public void deleteAllBooks(CustomerEntity customer) {
//        List<BookEntity> books = bookRepository.findAll();
//        for (BookEntity book : books) {
//            book.setStatus(BookStatus.DELETED);
//        }
//        bookRepository.saveAll(books);
//    }

}
