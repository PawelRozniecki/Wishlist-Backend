package com.wishlist.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "balance")
public class Balance {
    @Id
    Long id;
    BigDecimal balance;



}
