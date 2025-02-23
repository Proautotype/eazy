package com.eazybytes.cards.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor @NoArgsConstructor
@Table(name = "cards")
public class Card extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String cardId;

    @NotNull
    private String mobileNumber;

    @NotNull
    private String cardNumber;

    @NotNull
    private String cardType;

    @NotNull
    private int totalLimit;

    @NotNull
    private int amountUsed;

    @NotNull
    private int availableAmount;
}
