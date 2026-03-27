package br.com.ronaldo.api.converter;

import br.com.ronaldo.api.request.AddressRequestDTO;
import br.com.ronaldo.api.request.UserRequestDTO;
import br.com.ronaldo.infrastructure.entity.AddressEntity;
import br.com.ronaldo.infrastructure.entity.UserEntity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserConverter {
    public UserEntity toUserEntity(UserRequestDTO userDTO) {
        return UserEntity.builder()
                .id(UUID.randomUUID().toString())
                .name(userDTO.getName())
                .document(userDTO.getDocument())
                .email(userDTO.getEmail())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public AddressEntity toAddressEntity(AddressRequestDTO addressDTO, String userId) {
        return AddressEntity.builder()
                .userId(userId)
                .local(addressDTO.getLocal())
                .number(addressDTO.getNumber())
                .complement(addressDTO.getComplement())
                .district(addressDTO.getDistrict())
                .city(addressDTO.getCity())
                .zipcode(addressDTO.getZipcode())
                .build();
    }

}