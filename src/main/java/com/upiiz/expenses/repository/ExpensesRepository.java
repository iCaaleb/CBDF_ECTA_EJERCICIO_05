package com.upiiz.expenses.repository;

import com.upiiz.expenses.models.Expense;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

@Repository
public class ExpensesRepository {
    private final List<Expense> expenses = new ArrayList<Expense>();
    private final AtomicLong id = new AtomicLong();

    public Expense postExpense(Expense expense) {
        expense.setId(id.incrementAndGet());
        expenses.add(expense);
        return expense;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public Expense getExpenseById(Long id) {
        return expenses.stream().filter(expense -> expense.getId().equals(id)).findFirst().orElse(null);
    }

    public Expense updateExpense(Expense expense){
        deleteExpense(expense.getId());
        expenses.add(expense);
        return expense;
    }

    public void deleteExpense(Long id) {
        expenses.removeIf(expense -> expense.getId().equals(id));
    }
}
