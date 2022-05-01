package insa.smart.smart_back.service.abstraction;

import insa.smart.smart_back.dto.UserDTO;
import insa.smart.smart_back.entity.UserEntity;

public interface UserService {

    UserEntity registerNewUserAccount(UserDTO userDTO);
}
