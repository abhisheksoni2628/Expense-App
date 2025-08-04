package com.abhishek.em.domain.repository

import com.abhishek.em.data.local.Expense
import com.abhishek.em.data.local.ExpenseDao
import com.abhishek.em.data.remote.ApiService
import com.abhishek.em.domain.model.PostDto
import com.abhishek.em.utils.Network
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import javax.inject.Inject

class ExpenseRepositoryImpl @Inject constructor (
    private val dao: ExpenseDao
) : ExpenseRepository {
    override suspend fun getExpenses(): Flow<Network<List<Expense>>> = flow {
        val localPosts = dao.getAllExpenses()
        emit(Network.Success(localPosts))

    }.flowOn(Dispatchers.IO)

    override suspend fun saveExpense(expense: Expense) {
        dao.insertExpense(expense)
    }

}