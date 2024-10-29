package screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import models.Character
import models.CharactersModel

@Composable
fun CharacterInfo(characterId: Int, navController: NavHostController){
    val characterInfo = CharactersModel().characterInfo(characterId)
    Column {
    Button(
        onClick = { navController.popBackStack() },
        modifier = Modifier
    ) {
        Text(
            text = "Назад",
            color = Color.Black
        )}
        Text(text = characterInfo.name)
        Text(text = characterInfo.status)
    }
}