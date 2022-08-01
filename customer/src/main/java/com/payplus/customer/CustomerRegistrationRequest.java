package com.payplus.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
}
