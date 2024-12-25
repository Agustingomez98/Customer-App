package com.groupassist.customerapp.presentation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Schema(description = "Objeto de solicitud para crear o actualizar un cliente")
public class CustomerRequestDto {

    @NonNull
    @Schema(description = "ID único del cliente", example = "1")
    private Long id;
    @NotBlank(message = "Name field is mandatory")
    @Schema(description = "Nombre del cliente", example = "Juan", required = true)
    private String firstName;
    @NotBlank(message = "Lastname field is mandatory")
    @Schema(description = "Apellido del cliente", example = "Pérez", required = true)
    private String lastName;
    @NotBlank(message = "Email field is mandatory")
    @Email(message = "Invalid email format")
    @Schema(description = "Correo electrónico del cliente", example = "juan.perez@example.com", required = true)
    private String email;
    @NotBlank(message = "Gender field is mandatory")
    @Schema(description = "Género del cliente", example = "Masculino", required = true)
    private String gender;
    @NotBlank(message = "IpAddress field is mandatory")
    @Schema(description = "Dirección IP del cliente", example = "192.168.0.1", required = true)
    private String ipAddress;
    @NotBlank(message = "Country field is mandatory")
    @Schema(description = "País del cliente", example = "Argentina", required = true)
    private String country;
}