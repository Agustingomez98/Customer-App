package com.groupassist.customerapp.persistence.repositoy;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groupassist.customerapp.persistence.entity.CustomerEntity;

@Repository
public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {

    Page<CustomerEntity> findAll(Pageable pageable);

    Page<CustomerEntity> findByFirstNameStartingWith(String firstName, Pageable pageable);

    Page<CustomerEntity> findByLastNameStartingWith(String lastName, Pageable pageable);

    Page<CustomerEntity> findByEmailStartingWith(String email, Pageable pageable);

    Page<CustomerEntity> findByGenderStartingWith(String gender, Pageable pageable);

    Page<CustomerEntity> findByIpAddressStartingWith(String firstName, Pageable pageable);

    Page<CustomerEntity> findByCountryStartingWith(String country, Pageable pageable);
}
