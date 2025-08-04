package com.abhishek.em.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhishek.em.domain.repository.ExpenseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FlowViewModel @Inject constructor(
    private val repository: ExpenseRepository
) : ViewModel() {
    fun numbersFlow(): Flow<Int> = flow {
        for (i in 1..3) {
            delay(1000) // pretend it's a long computation
            emit(i)
        }
    }

    val sharedFlow = MutableSharedFlow<Int>()


    init {
        viewModelScope.launch {
           /* numbersFlow().collect {
                println("NUMBER -> $it")
            }*/
            coldFlow().collect { println(it) }
            /*coldFlow().collect { println(it) }*/
            /*var counter = 0
            while (true) {
                delay(1000)
                sharedFlow.emit(counter++)
            }*/
        }

        /*viewModelScope.launch {
            sharedFlow.collect {
                println("Hot Received: $it")
            }
        }*/
    }

    fun coldFlow(): Flow<Int> = flow {
       /* println("Flow started")
        emit("🍎 Apple")
        emit("🍌 Banana")
        emit("🍇 Grape")*/
        var counter = 0
        while (true) {
            delay(1000)
            emit(counter++)
        }
    }



}