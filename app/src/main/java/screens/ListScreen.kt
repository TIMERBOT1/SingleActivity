package screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.navArgument
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import models.CharactersModel


@Composable
fun ListScreen(navController: NavController, model: CharactersModel){
    LaunchedEffect(Unit, block = {
        model.getChars()
    })
    val itemsList = model.todoList
    if (model.errorMessage.isEmpty()) {
        Column {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 15.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            )
            {
                items(itemsList){ item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(50.dp)
                            .padding(horizontal = 15.dp)
                            .clickable { navController.navigate("characterInfo/${item.id}") }
                    ) { Text(text = item.name, fontSize = 24.sp) }
                }
            }
        }
    }
    else{
        Text(model.errorMessage)
    }
}