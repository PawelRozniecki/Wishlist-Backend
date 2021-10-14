package com.wishlist.repositories;

import com.wishlist.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface BudgetRepository extends JpaRepository<Budget,Long> {
//
//    @Modifying
//    @Query("Update Budget as b SET b.income  = :expense")
//    BigDecimal updateExpense(@Param("expense"));


}
