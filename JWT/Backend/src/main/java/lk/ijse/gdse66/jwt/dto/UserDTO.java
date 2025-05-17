package lk.ijse.gdse66.jwt.dto;

import lk.ijse.gdse66.jwt.util.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {
    private int id;
    private String name;
    private String email;
    private String password;
    private Role role;
}