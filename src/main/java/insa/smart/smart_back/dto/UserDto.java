package insa.smart.smart_back.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {

    private String username;
    private String email;
    private String password;


}
