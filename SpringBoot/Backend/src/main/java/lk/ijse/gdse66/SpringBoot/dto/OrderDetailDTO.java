package lk.ijse.gdse66.SpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailDTO {
    private int id;
    private int itemId;
    private int quantity;
    private double unitPrice;
    private double total;
    private int orderId;
}