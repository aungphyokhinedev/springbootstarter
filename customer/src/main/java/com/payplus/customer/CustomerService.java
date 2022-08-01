package com.payplus.customer;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.payplus.customer.Customer.*;

@Service
@AllArgsConstructor
public class CustomerService {

    private  final CustomerRepository repository;

    private  final RestTemplate restTemplate;


    public void registerCustomer(CustomerRegistrationRequest customerRegisterationRequest) {
        Customer customer = builder()
                .firstName(customerRegisterationRequest.firstName())
                .lastName(customerRegisterationRequest.lastName())
                .email(customerRegisterationRequest.email())
                .build();
        repository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://fraud/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()

        );
        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }

    }
}
