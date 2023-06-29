package br.com.bookreader.domain.repository;


import br.com.bookreader.data_access.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer> {

//    Page<BookModel> findByStatus(BookStatus name, Pageable pageable);
//
//    List<BookEntity> findByCustomer(CustomerModel name);

    List<BookEntity> findAllByCustomerId(String customerId);
    List<BookEntity> findAllByStatus(String customerId);
}