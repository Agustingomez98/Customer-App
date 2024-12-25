package com.groupassist.customerapp.util.mapper;

import org.springframework.stereotype.Component;

import com.groupassist.customerapp.persistence.entity.CustomerEntity;
import com.groupassist.customerapp.presentation.dto.CustomerRequestDto;
import com.groupassist.customerapp.presentation.dto.CustomerResponseDto;

@Component
public class CustomerMapper {
    
    public CustomerEntity dtoToEntity (CustomerRequestDto dto){
        return CustomerEntity.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .gender(dto.getGender())
                .ipAddress(dto.getIpAddress())
                .country(dto.getCountry())
                .build();
    }

    public CustomerResponseDto entityToDto(CustomerEntity entity){
        return CustomerResponseDto.builder()
                .id(entity.getId())
                .fullName(entity.getFirstName()+" "+entity.getLastName())
                .email(entity.getEmail())
                .gender(entity.getGender())
                .ipAddress(entity.getIpAddress())
                .country(entity.getCountry())
                .build();
    }
}
