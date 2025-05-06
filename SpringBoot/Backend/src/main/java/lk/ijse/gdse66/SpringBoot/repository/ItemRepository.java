package lk.ijse.gdse66.SpringBoot.repository;

import lk.ijse.gdse66.SpringBoot.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}