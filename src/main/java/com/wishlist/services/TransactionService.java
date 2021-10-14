package com.wishlist.services;

import com.wishlist.enums.TransactionType;
import com.wishlist.model.Budget;
import com.wishlist.model.Transaction;
import com.wishlist.repositories.BudgetRepository;
import com.wishlist.repositories.CategoryRepository;
import com.wishlist.repositories.TransactionRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

@Data
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BudgetRepository budgetRepository;
    @Autowired
    CategoryRepository categoryRepository;

    // Save the transaction and depending on the transaction type adjust budget accordingly
    public void addTransaction(Transaction transaction){

        Budget budget = budgetRepository.getById(1L);
        // look up category type
       if(transaction.getTransactionType().equals(TransactionType.INCOME)){
            BigDecimal amount = budget.getIncome().add(transaction.getAmount());

       }
       if(transaction.getTransactionType().equals(TransactionType.EXPENSE)){
           budget.getExpenses().add(transaction.getAmount());
       }



        transactionRepository.save(transaction);
    }


}
