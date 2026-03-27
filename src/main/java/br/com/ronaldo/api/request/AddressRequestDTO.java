package br.com.ronaldo.api.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class AddressRequestDTO {
    private String local;
    private Long number;
    private String district;
    private String complement;
    private String city;
    private String zipcode;
}