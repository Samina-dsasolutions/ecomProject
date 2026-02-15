package com.alibou.ecommerce.payment;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record Customer(
      String id,
      @NotNull(message = "FirstName is require")
      String firstName,
      @NotNull(message = "LastName is is require")
      String lastName,
      @NotNull(message = "email is require")
      @Email(message = "the customer is not correctly formatted")
      String email
) {


}
