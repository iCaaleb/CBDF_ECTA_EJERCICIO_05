package com.upiiz.expenses.services;

import com.upiiz.expenses.models.Expense;
import com.upiiz.expenses.repository.ExpensesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpensesService {

    ExpensesRepository expensesRepository;

    public ExpensesService(ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }

    public List<Expense> getExpenses(){
        return expensesRepository.getExpenses();
    }

    public Expense getExpenseById(Long id){
        return expensesRepository.getExpenseById(id);
    }

    public Expense createExpense(Expense expense){
        return expensesRepository.postExpense(expense);
    }

    public Expense updateExpense(Expense expense){
        return expensesRepository.updateExpense(expense);
    }

    public void deleteExpense(Long id){
        expensesRepository.deleteExpense(id);
    }
}
