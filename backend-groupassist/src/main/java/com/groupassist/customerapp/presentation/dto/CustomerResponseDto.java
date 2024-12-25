package com.groupassist.customerapp.presentation.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Schema(description = "Objeto de respuesta para la representación de un cliente")
public class CustomerResponseDto {

    @Schema(description = "ID único del cliente", example = "1")
    private Long id;
    @Schema(description = "Nombre completo del cliente", example = "Juan Pérez")
    private String fullName;
    @Schema(description = "Correo electrónico del cliente", example = "juan.perez@example.com")
    private String email;
    @Schema(description = "Género del cliente", example = "Masculino")
    private String gender;
    @Schema(description = "Dirección IP del cliente", example = "192.168.0.1")
    private String ipAddress;
    @Schema(description = "País del cliente", example = "Argentina")
    private String country;
}
