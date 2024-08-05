package com.example.to_doapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var taskViewModel: TaskViewModel
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        taskAdapter = TaskAdapter(emptyList(), this::onTaskChecked, this::onTaskDeleted)

        val recyclerView = findViewById<RecyclerView>(R.id.rvTasks)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = taskAdapter

        taskViewModel.tasks.observe(this, Observer {
            taskAdapter.updateTasks(it)
        })

        val addTaskButton = findViewById<Button>(R.id.btnAddTask)
        addTaskButton.setOnClickListener {
            val taskName = findViewById<EditText>(R.id.etTask).text.toString()
            if (taskName.isNotBlank()) {
                taskViewModel.addTask(taskName)
                findViewById<EditText>(R.id.etTask).text.clear()
            }
        }
    }

    private fun onTaskChecked(task: Task, isChecked: Boolean) {
        taskViewModel.updateTask(task.copy(isComplete = isChecked))
    }

    private fun onTaskDeleted(task: Task) {
        taskViewModel.deleteTask(task)
    }
}
