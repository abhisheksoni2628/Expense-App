package com.abhishek.em.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expense")
data class Expense(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val amount: Long,
    val description: String
)