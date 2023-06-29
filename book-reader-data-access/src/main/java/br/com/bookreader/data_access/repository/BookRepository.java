package br.com.bookreader.data_access.repository;


import br.com.bookreader.domain.entity.BookFileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookFileEntity, Integer> {

    List<BookFileEntity> findAllByCustomerId(String customerId); //retorna uma lista de livros que pertencem a um determinado cliente

}