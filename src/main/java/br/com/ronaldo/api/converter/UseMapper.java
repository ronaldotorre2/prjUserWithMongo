package br.com.ronaldo.api.converter;

import br.com.ronaldo.api.response.UserResponseDTO;
import br.com.ronaldo.infrastructure.entity.AddressEntity;
import br.com.ronaldo.infrastructure.entity.UserEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UseMapper {
    @Mapping(target = "id", source = "UserEntity.id")
    @Mapping(target = "name", source = "UserEntity.name")
    @Mapping(target = "document", source = "UserEntity.document")
    @Mapping(target = "addressDto", source = "addressEntity")
    UserResponseDTO toUserResponseDTO(UserEntity UserEntity, AddressEntity addressEntity);
}