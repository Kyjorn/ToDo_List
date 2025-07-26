package com.example.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.todo.ui.theme.Licorice


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDoInput()
        }
    }
}

@Composable
fun ToDoInput() {
    var taskText by remember { mutableStateOf("") }
    Column (
        modifier = Modifier
        .background(color = Licorice)
        .fillMaxSize()
        .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally)
    {

        TextField(
            modifier = Modifier,
            value = taskText,
            onValueChange = {newText -> taskText = newText}
        )
        Button (onClick = {
            println(taskText)
            taskText = ""
        }) {
            Text(text = "Add a task")
        }
    }
}

