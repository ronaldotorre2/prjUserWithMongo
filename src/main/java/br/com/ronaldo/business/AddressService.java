package br.com.ronaldo.business;

import br.com.ronaldo.infrastructure.entity.AddressEntity;
import br.com.ronaldo.infrastructure.repository.AddressRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressEntity saveAddress(AddressEntity addressEntity) {
        return addressRepository.save(addressEntity);
    }

    public AddressEntity findByUserId(String userId) {
        return addressRepository.findByUserId(userId);
    }

    public void deleteByUserId(String userId) {
        addressRepository.deleteByUserId(userId);
    }

}