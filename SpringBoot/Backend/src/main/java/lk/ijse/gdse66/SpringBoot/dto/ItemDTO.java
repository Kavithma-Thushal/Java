package lk.ijse.gdse66.SpringBoot.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO {

    private int id;

    @Pattern(regexp = "^[A-Za-z0-9\\s'-]{2,}$", message = "Description must contain at least 2 letters!")
    private String description;

    @Min(value = 10, message = "Quantity must contain at least 2 digits!")
    private int quantity;

    @Min(value = 100, message = "Unit Price must contain at least 3 digits!")
    private double unitPrice;
}