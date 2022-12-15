package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;


import put.io.students.fancylibrary.database.IFancyDatabase;

public class ExpenseRepositoryTest {


    @Test
    void testLoadExpenses() {
        IFancyDatabase mockObject = mock(IFancyDatabase.class);
        when(mockObject.queryAll()).thenReturn(Collections.emptyList());

        ExpenseRepository expenseRepo = new ExpenseRepository(mockObject);
        expenseRepo.loadExpenses();
        List<Expense> list = expenseRepo.getExpenses();


        verify(mockObject).connect();
        verify(mockObject).queryAll();
        verify(mockObject).close();

        InOrder inOrder = inOrder(mockObject);
        inOrder.verify(mockObject).connect();
        inOrder.verify(mockObject).queryAll();
        inOrder.verify(mockObject).close();

        assertEquals(list.size(), 0);
    }

    @Test
    void testSaveExpenses() {
        IFancyDatabase mockObject = mock(IFancyDatabase.class);
        when(mockObject.queryAll()).thenReturn(Collections.emptyList());

        ExpenseRepository expenseRepo = new ExpenseRepository(mockObject);
        Expense expense = new Expense();

        for(int i=0; i<5; i++){
            expenseRepo.addExpense(expense);
        }
        List<Expense> list = expenseRepo.getExpenses();
        expenseRepo.saveExpenses();

        verify(mockObject, times(5)).persist(any(Expense.class));

        assertEquals(list.size(), 5);
    }
}
