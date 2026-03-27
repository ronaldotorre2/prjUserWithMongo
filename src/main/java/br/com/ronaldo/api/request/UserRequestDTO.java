package br.com.ronaldo.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class UserRequestDTO {
    private String name;
    @JsonProperty(required = true)
    private String email;
    private String document;
    private AddressRequestDTO address;
}