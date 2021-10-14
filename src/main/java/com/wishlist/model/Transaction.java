package com.wishlist.model;

import com.wishlist.enums.TransactionType;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;


@Data
@Entity
@Table(name = "transactions")

public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime transactionDate;
    private String title;
    private BigDecimal amount;
    private TransactionType transactionType;
    private int categoryId;
    private String comment;






}
