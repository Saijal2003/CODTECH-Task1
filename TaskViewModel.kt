package com.example.to_doapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {
    private val _tasks = MutableLiveData<List<Task>>()
    val tasks: LiveData<List<Task>> get() = _tasks

    private var taskId = 0L

    init {
        _tasks.value = emptyList()
    }

    fun addTask(name: String) {
        val newTask = Task(taskId++, name)
        _tasks.value = _tasks.value?.plus(newTask)
    }

    fun updateTask(task: Task) {
        _tasks.value = _tasks.value?.map {
            if (it.id == task.id) it.copy(isComplete = task.isComplete) else it
        }
    }

    fun deleteTask(task: Task) {
        _tasks.value = _tasks.value?.filter { it.id != task.id }
    }
}
