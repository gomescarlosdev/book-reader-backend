package br.com.bookreader.service;

import br.com.bookreader.domain.entity.BookFileEntity;

import java.util.List;

public interface IBookService {

    List<BookFileEntity> findAll(String customerId);

    List<BookFileEntity> findAllByIsFavorite(String customerId);

    void create(int customerId, BookFileEntity book);

    void delete(int bookFileId);
}
