package br.com.bookreader.domain.repository;

import br.com.bookreader.data_access.entity.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<CustomerEntity, Integer> {

    Page<CustomerEntity> findByNameContaining(String name, Pageable pageable);
}