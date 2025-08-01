package com.example.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todo.ui.theme.DeftBlue
import com.example.todo.ui.theme.Perwinkle


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
    val taskList = remember { mutableStateListOf<String>() }
    Column (
        modifier = Modifier
        .background(color = DeftBlue)
        .fillMaxSize()
        .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        LazyColumn {
            items(taskList) { task ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        task,
                        color = Perwinkle
                    )
                    IconButton(onClick = { taskList.remove(task)}) {
                        Icon(

                            Icons.Default.Delete,
                            contentDescription = "Delete task"
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        TextField(
            modifier = Modifier,
            shape = RoundedCornerShape(16.dp),
            value = taskText,
            onValueChange = {newText -> taskText = newText}
        )

        Button (onClick = {
            if (taskText.isNotBlank()){
                println(taskText)
                taskList.add(taskText)
                taskText = ""
            }
        }){
            Text(text = "Add a task", color = Perwinkle)
        }

    }
}

