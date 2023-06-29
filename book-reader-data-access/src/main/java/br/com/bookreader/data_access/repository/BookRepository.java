package br.com.bookreader.data_access.repository;


import br.com.bookreader.domain.entity.BookFileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookFileEntity, Integer> {

//    Page<BookModel> findByStatus(BookStatus name, Pageable pageable);
//
//    List<BookEntity> findByCustomer(CustomerModel name);

//    List<BookFileEntity> findAllByCustomerId(String customerId);
//    List<BookFileEntity> findAllByStatus(String customerId);
}