package lk.ijse.gdse66.SpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {
    private int id;
    private int customerId;
    private LocalDate date;
    private List<OrderDetailDTO> orderDetails;
}