package lk.ijse.gdse66.SpringBoot.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {

    private int id;

    @Pattern(regexp = "^[A-Za-z\\s'-]{4,}$", message = "Name must contain at least 4 letters!")
    private String name;

    @Pattern(regexp = "^[A-Za-z\\s'-]{4,}$", message = "Address must contain at least 4 letters!")
    private String address;

    @Min(value = 1000, message = "Salary must be at least 4 digits!")
    private double salary;
}