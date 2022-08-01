package com.payplus.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class FraudCheckService {
    private  final  FraudCheckHistoryRepository fraudCheckHistoryRepository;
    public  boolean isFradulantCustomer(Long customerId){
        //throw new IllegalStateException("invalid request");
        fraudCheckHistoryRepository.save(FraudCheckHistory.builder()
                .customerId(customerId)
                .isFraudster(false)
                .createdAt(LocalDateTime.now())
                .build());
        log.error("Fraudster found");
        return  false;
    }
}
