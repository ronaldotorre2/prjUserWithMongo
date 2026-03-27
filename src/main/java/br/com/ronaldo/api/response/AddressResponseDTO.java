package br.com.ronaldo.api.response;

public record AddressResponseDTO(String local,
                                 Long number,
                                 String district,
                                 String complement,
                                 String city,
                                 String zipcode) {
}