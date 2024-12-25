package com.groupassist.customerapp.service.interfaz;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.groupassist.customerapp.persistence.entity.CustomerEntity;
import com.groupassist.customerapp.presentation.dto.CustomerRequestDto;
import com.groupassist.customerapp.presentation.dto.CustomerResponseDto;

public interface ICustomerService {

    CustomerResponseDto saveCustomer(CustomerRequestDto customer);

    Page<CustomerEntity> findAll (Pageable pageable);

    Page<CustomerEntity> findByArgument(String field, String value, Pageable pageable);

    CustomerResponseDto findById(Long id);

    CustomerResponseDto updateCustomer(Long id, CustomerRequestDto customer);

    void deleteCustomer(Long id);

}
