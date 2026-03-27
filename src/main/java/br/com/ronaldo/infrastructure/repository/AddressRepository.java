package br.com.ronaldo.infrastructure.repository;

import br.com.ronaldo.infrastructure.entity.AddressEntity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

public interface AddressRepository extends MongoRepository<AddressEntity, String> {
    AddressEntity findByUserId(String userId);
    @Transactional
    void deleteByUserId(String userId);
}