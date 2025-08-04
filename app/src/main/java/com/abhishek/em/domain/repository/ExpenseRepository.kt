package com.abhishek.em.domain.repository

import com.abhishek.em.data.local.Expense
import com.abhishek.em.domain.model.PostDto
import com.abhishek.em.utils.Network
import kotlinx.coroutines.flow.Flow

interface ExpenseRepository {
    suspend fun getExpenses(): Flow<Network<List<Expense>>>
    suspend fun saveExpense(expense: Expense)
}