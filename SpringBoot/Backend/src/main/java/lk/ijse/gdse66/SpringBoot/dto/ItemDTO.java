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

    @Min(value = 1, message = "Quantity must be at least 1 digit!")
    private int quantity;

    @Min(value = 10, message = "Unit Price must be at least 2 digits!")
    private double unitPrice;
}