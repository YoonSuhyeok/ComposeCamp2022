package com.codelabs.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
//        val count: MutableState<Int> = remember { mutableStateOf(0) }
//        by 사용 시 .value 삭제할 수 있음
//        var count by remember { mutableStateOf(0) }
    var count by rememberSaveable { mutableStateOf(0) }

    StatelessCounter(count = count, onIncrement = { count++ }, modifier = modifier)
}

@Composable
private fun StatelessCounter(count: Int,
                             onIncrement: () -> Unit,
                             modifier: Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text(text = "You've had $count glassess.")
        }
        Button(
            onClick = onIncrement,
            enabled = count < 10,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Add one")
        }
    }
}
