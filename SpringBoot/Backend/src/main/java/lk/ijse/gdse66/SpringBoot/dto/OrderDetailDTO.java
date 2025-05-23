package lk.ijse.gdse66.SpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDTO {
    private int id;
    private int orderId;
    private int itemId;
    private int quantity;
    private double unitPrice;
    private double total;
}