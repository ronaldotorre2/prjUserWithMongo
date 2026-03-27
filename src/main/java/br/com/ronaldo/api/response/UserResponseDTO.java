package br.com.ronaldo.api.response;

public record UserResponseDTO(String id,
                              String name,
                              String email,
                              String document,
                              AddressResponseDTO addressDto) {
}
