package br.com.bookreader.service;

import br.com.bookreader.domain.entity.BookFileEntity;

import java.util.List;

public interface IBookService {

    List<BookFileEntity> findAllByCustomerId(String customerId);

    void create(String customerId, BookFileEntity book);

    void delete(int bookFileId);
}
