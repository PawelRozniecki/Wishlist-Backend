package com.wishlist.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name= "Budget")
@Data
@Transactional
@Entity

public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal expenses;
    private BigDecimal income;
    private BigDecimal savings;
    private BigDecimal targetExpense;
    private BigDecimal targetIncome;
}
