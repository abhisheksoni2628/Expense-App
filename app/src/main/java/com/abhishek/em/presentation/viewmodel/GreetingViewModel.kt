package com.abhishek.em.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhishek.em.data.local.Expense
import com.abhishek.em.domain.model.UserRequest
import com.abhishek.em.domain.repository.ExpenseRepository
import com.abhishek.em.domain.repository.PostRepository
import com.abhishek.em.utils.Network
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GreetingViewModel @Inject constructor(
    private val repository: ExpenseRepository,
    private val postRepository: PostRepository
) : ViewModel() {

    private val _greeting = MutableStateFlow("")
    val greeting: StateFlow<String> = _greeting

    var expenses by mutableStateOf<List<Expense>>(emptyList())
        private set

//    init {
//        getExpenses()
//    }

   /* private val _counterFlow = flow {
        var counter = 0
        while (true) {
            emit(counter++)
            Log.d("CounterFlow", "Emitting value: $counter")
            delay(1000)
        }
    }

    val sharedCounter = _counterFlow
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = 0
        )*/

    private val _counterFlow = MutableStateFlow(0)
    val sharedCounter = _counterFlow
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = _counterFlow.value
        )

    init {
        startCounter()
    }

    private fun startCounter() {
        viewModelScope.launch {
            var counter = 0
            while (true) {
                _counterFlow.emit(counter++)
                Log.d("CounterFlow", "Emitting value: $counter")
                delay(1000)
            }
        }
    }

    fun saveExpense(expense: Expense) {
        viewModelScope.launch {
            repository.saveExpense(expense)
        }
    }

    fun getExpenses() = viewModelScope.launch {
        repository.getExpenses().collect { result ->
            when (result) {
                is Network.Loading -> {
                }

                is Network.Success -> {
                    expenses = result.data
                }

                is Network.Error -> {
                }
            }
        }
    }

    fun registerUser(user: UserRequest) = viewModelScope.launch {
        postRepository.registerUser(user).collect { result ->
            when (result) {
                is Network.Loading -> {

                }

                is Network.Success -> {
                    Log.e("TAG", "Saved Response: ${result.data}", )
                }

                is Network.Error -> {
                    Log.e("TAG", "Errr Response: ${result.message}", )
                }
            }
        }
    }


}