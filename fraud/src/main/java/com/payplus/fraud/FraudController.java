package com.payplus.fraud;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {
    private final FraudCheckService fraudCheckService;

    @GetMapping("/health")
    public String hello() {
        return String.format("fraud service is running");
    }

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudseter(@PathVariable("customerId") Long customerId){
       boolean isFradulentCustomer = fraudCheckService.isFradulantCustomer(customerId);
       return  new FraudCheckResponse(isFradulentCustomer);
    }
}
