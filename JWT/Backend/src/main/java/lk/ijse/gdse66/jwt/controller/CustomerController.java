package lk.ijse.gdse66.jwt.controller;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @PostMapping
    public String save() {
        return "Customer saved successfully!";
    }
}