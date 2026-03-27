package br.com.ronaldo.infrastructure.repository;

import br.com.ronaldo.infrastructure.entity.UserEntity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends MongoRepository<UserEntity, String> {
    UserEntity findByEmail(String email);
    @Transactional
    void deleteByEmail(String email);
}