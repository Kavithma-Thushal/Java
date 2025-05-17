package lk.ijse.gdse66.jwt.auth.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SigninRequest {
    private String email;
    private String password;
}