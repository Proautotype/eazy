package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "CustomerDetailis",
        description = "Schema to hold Customer and Account, Cards and Loans information"
)
public class CustomerDetailsDto {


    @Schema(
            description = "Name of the customer", example = "John Doe"
    )
    @NotEmpty(message = "Name cannot be null or empty")
    @Size(min = 5, max = 30, message = "Length should be btn 5 and 30")
    private String name;

    @Schema(
            description = "Email of the customer", example = "john@example.com"
    )
    @NotEmpty(message = "Email address cannot be a null or empty")
    @Email(message = "Email address should be a valid value")
    private String email;

    @Schema(
            description = "Phone number of the customer", example = "1234567890"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Account details of the customer"
    )
    private AccountsDto accountsDto;
    @Schema(
            description = "Card details of the customer"
    )
    private CardDto cardDto;

    @Schema(
            description = "Loans details of the customer"
    )
    private LoansDto loansDto;

}
