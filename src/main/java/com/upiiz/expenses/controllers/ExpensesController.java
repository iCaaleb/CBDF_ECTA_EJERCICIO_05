package com.upiiz.expenses.controllers;

import com.upiiz.expenses.models.Expense;
import com.upiiz.expenses.services.ExpensesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/expenses")
@RestController
public class ExpensesController {
    ExpensesService expensesService;

    public ExpensesController(ExpensesService expensesService){
        this.expensesService = expensesService;
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getExpenses(){
        return ResponseEntity.ok(expensesService.getExpenses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id){
        return ResponseEntity.ok(expensesService.getExpenseById(id));
    }

    @PostMapping
    public ResponseEntity<Expense> postExpense(@RequestBody Expense expense){
        return ResponseEntity.ok(expensesService.createExpense(expense));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expense> putExpense(@RequestBody Expense expense, @PathVariable Long id){
        expense.setId(id);
        return ResponseEntity.ok(expensesService.updateExpense(expense));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id){
        expensesService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }
}
