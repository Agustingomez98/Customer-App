package com.groupassist.customerapp.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.groupassist.customerapp.persistence.entity.CustomerEntity;
import com.groupassist.customerapp.presentation.dto.CustomerRequestDto;
import com.groupassist.customerapp.presentation.dto.CustomerResponseDto;
import com.groupassist.customerapp.service.implementation.CustomerServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
@Tag(name = "Customer", description = "API for customer management")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl service;
    @Autowired
    private PagedResourcesAssembler<CustomerEntity> pagedResourcesAssembler;

    @PostMapping()
    @Operation(summary = "Crear un nuevo cliente", description = "Guarda un nuevo cliente con los datos proporcionados.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Cliente creado exitosamente", content = @Content(schema = @Schema(implementation = CustomerResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Datos de solicitud inválidos", content = @Content)
    })
    public ResponseEntity<?> saveCustomer(@Valid @RequestBody CustomerRequestDto customerRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveCustomer(customerRequestDto));
    }

    @GetMapping()
    @Operation(summary = "Obtener todos los clientes", description = "Obtiene una lista paginada de todos los clientes.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Clientes obtenidos correctamente", content = @Content(schema = @Schema(implementation = Page.class))),
            @ApiResponse(responseCode = "400", description = "Parámetros de paginación inválidos", content = @Content)
    })
    public ResponseEntity<PagedModel<?>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size); // Crear Pageable manualmente
        Page<CustomerEntity> customerPage = service.findAll(pageable);
        PagedModel<?> pagedModel = pagedResourcesAssembler.toModel(customerPage);
        return ResponseEntity.ok(pagedModel);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener cliente por ID", description = "Recupera un cliente utilizando su ID único.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente encontrado", content = @Content(schema = @Schema(implementation = CustomerResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado", content = @Content)
    })
    public ResponseEntity<CustomerResponseDto> findById(
            @Parameter(description = "ID del cliente a recuperar", example = "1") @PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/search")
    @Operation(summary = "Buscar clientes por campo", description = "Busca clientes según un campo y valor especificado.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Clientes encontrados correctamente", content = @Content(schema = @Schema(implementation = Page.class))),
            @ApiResponse(responseCode = "400", description = "Parámetros de búsqueda inválidos", content = @Content)
    })
    public ResponseEntity<PagedModel<?>> searchCustomers(
            @Parameter(description = "Campo por el cual buscar", example = "email") @RequestParam String field,
            @Parameter(description = "Valor del campo a buscar", example = "ejemplo@correo.com") @RequestParam String value,
            @Parameter(description = "Parámetros de paginación", example = "page=0&size=10&sort=firstName,asc") Pageable pageable) {

        try {
            Page<CustomerEntity> customers = service.findByArgument(field, value, pageable);
            PagedModel<?> pagedModel = pagedResourcesAssembler.toModel(customers);
            return ResponseEntity.ok(pagedModel);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un cliente", description = "Actualiza los datos de un cliente existente.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente actualizado exitosamente", content = @Content(schema = @Schema(implementation = CustomerResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado", content = @Content),
            @ApiResponse(responseCode = "400", description = "Datos de solicitud inválidos", content = @Content)
    })
    public ResponseEntity<?> updateCustomer(
            @Parameter(description = "ID del cliente a actualizar", example = "1") @PathVariable Long id,
            @Valid @RequestBody CustomerRequestDto customerRequestDto) {
        return ResponseEntity.ok().body(service.updateCustomer(id, customerRequestDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un cliente", description = "Elimina un cliente utilizando su ID único.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Cliente eliminado exitosamente", content = @Content),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado", content = @Content)
    })
    public ResponseEntity<?> deleteCustomer(
            @Parameter(description = "ID del cliente a eliminar", example = "1") @PathVariable Long id) {
        service.deleteCustomer(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
