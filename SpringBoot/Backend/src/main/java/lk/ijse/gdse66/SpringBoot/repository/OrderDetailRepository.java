package lk.ijse.gdse66.SpringBoot.repository;

import lk.ijse.gdse66.SpringBoot.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}