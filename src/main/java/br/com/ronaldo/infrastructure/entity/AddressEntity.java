package br.com.ronaldo.infrastructure.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "Address")
public class AddressEntity {
    @Id
    private String id;
    private String userId;
    private String local;
    private Long number;
    private String district;
    private String complement;
    private String city;
    private String zipcode;
}