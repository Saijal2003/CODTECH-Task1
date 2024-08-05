package com.example.to_doapp

data class Task(
        val id: Long,
        val name: String,
        var isComplete: Boolean = false
)