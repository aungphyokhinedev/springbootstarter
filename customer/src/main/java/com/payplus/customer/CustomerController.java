package com.payplus.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) {

    @GetMapping("/health")
    public String hello() {
        return String.format("customer service is running");
    }

    @PostMapping()
    public  void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegisterationRequest){
        log.info("new customer registeration {}", customerRegisterationRequest);
        customerService.registerCustomer(customerRegisterationRequest);
    }
}
