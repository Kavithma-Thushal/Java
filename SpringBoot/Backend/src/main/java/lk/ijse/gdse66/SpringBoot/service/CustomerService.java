package lk.ijse.gdse66.SpringBoot.service;

import lk.ijse.gdse66.SpringBoot.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO save(CustomerDTO dto);

    List<CustomerDTO> getAll();

    CustomerDTO getById(Integer id);
}