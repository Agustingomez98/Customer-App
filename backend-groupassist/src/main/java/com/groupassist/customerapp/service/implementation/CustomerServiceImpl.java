package com.groupassist.customerapp.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.groupassist.customerapp.persistence.entity.CustomerEntity;
import com.groupassist.customerapp.persistence.repositoy.ICustomerRepository;
import com.groupassist.customerapp.presentation.dto.CustomerRequestDto;
import com.groupassist.customerapp.presentation.dto.CustomerResponseDto;
import com.groupassist.customerapp.service.interfaz.ICustomerService;
import com.groupassist.customerapp.util.mapper.CustomerMapper;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository repository;
    @Autowired
    private CustomerMapper mapper;

    @Override
    public CustomerResponseDto saveCustomer(CustomerRequestDto customer) {
        CustomerEntity customerEntity = mapper.dtoToEntity(customer);
        return mapper.entityToDto(repository.save(customerEntity));
    }

    @Override
    public Page<CustomerEntity> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public CustomerResponseDto findById(Long id) {
        return repository.findById(id)
                .map(mapper::entityToDto)
                .orElseThrow(()-> new EntityNotFoundException("Customer with ID " + id + " was not found."));
    }

    @Override
    public CustomerResponseDto updateCustomer(Long id,CustomerRequestDto customer) {
        
        CustomerEntity customerEntity = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Customer with ID " + id + " was not found."));

        System.out.println("customer crack: "+customer.toString());
        customerEntity.setFirstName(customer.getFirstName());
        customerEntity.setLastName(customer.getLastName());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setGender(customer.getGender());
        customerEntity.setIpAddress(customer.getIpAddress());
        customerEntity.setCountry(customer.getCountry());
        
        return mapper.entityToDto(repository.save(customerEntity));
    }

    @Override
    public void deleteCustomer(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
        }else {
            throw new EntityNotFoundException("Customer with ID " + id + " was not found.");
        }
    }

    @Override
    public Page<CustomerEntity> findByArgument(String field, String value, Pageable pageable) {
        
        switch (field) {
            case "firstName":
                return repository.findByFirstNameStartingWith(value, pageable);
            case "lastName":
                return repository.findByLastNameStartingWith(value, pageable);
            case "email":
                return repository.findByEmailStartingWith(value, pageable);
            case "gender":
                return repository.findByEmailStartingWith(value, pageable);
            case "ipAddress":
                return repository.findByIpAddressStartingWith(value, pageable);
            case "country":
                return repository.findByCountryStartingWith(value, pageable);
            default:
                throw new IllegalArgumentException("Invalid field: " + field);
        }
    }
}