package br.com.bookreader.data_access.repository;

import br.com.bookreader.domain.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {

    CustomerEntity findByNameContaining(String name);

}