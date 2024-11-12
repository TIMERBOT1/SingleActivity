package screens

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import models.CharactersModel

@Composable
fun ListScreen(navController: NavController){
    Column {
        val itemsList = CharactersModel().charactersList
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 15.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
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