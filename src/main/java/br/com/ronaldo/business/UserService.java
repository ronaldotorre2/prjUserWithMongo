package br.com.ronaldo.business;

import br.com.ronaldo.api.converter.UserConverter;
import br.com.ronaldo.api.converter.UseMapper;
import br.com.ronaldo.api.request.UserRequestDTO;
import br.com.ronaldo.api.response.UserResponseDTO;
import br.com.ronaldo.infrastructure.entity.AddressEntity;
import br.com.ronaldo.infrastructure.entity.UserEntity;
import br.com.ronaldo.infrastructure.exceptions.BusinessException;
import br.com.ronaldo.infrastructure.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.util.Assert.notNull;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final UseMapper userMapper;
    private final AddressService addressService;

    public UserEntity saveUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public UserResponseDTO saveUsers(UserRequestDTO userRequestDTO) {
        try {
            notNull(userRequestDTO, "Os dados do usuário são obrigatórios");
            UserEntity userEntity = saveUser(userConverter.toUserEntity(userRequestDTO));
            AddressEntity addressEntity = addressService.saveAddress(
                    userConverter.toAddressEntity(userRequestDTO.getAddress(), userEntity.getId()));
            return userMapper.toUserResponseDTO(userEntity, addressEntity);
        } catch (Exception e) {
            throw new BusinessException("Erro ao gravar dados de usuário", e);
        }
    }

    public UserResponseDTO searchUserByEmail(String email) {
        try {
            UserEntity entity = userRepository.findByEmail(email);
            notNull(entity, "Usuário não encontrado");
            AddressEntity addressEntity = addressService.findByUserId(entity.getId());

            return userMapper.toUserResponseDTO(entity, addressEntity);
        } catch (Exception e) {
            throw new BusinessException("Erro ao buscar dados de usuário", e);
        }
    }

    @Transactional
    public void deleteUser(String email) {
        UserEntity entity = userRepository.findByEmail(email);
        userRepository.deleteByEmail(email);
        addressService.deleteByUserId(entity.getId());
    }
}