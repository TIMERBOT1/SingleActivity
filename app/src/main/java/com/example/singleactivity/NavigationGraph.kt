package com.example.singleactivity

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import models.CharactersModel

@Composable
fun NavigationGraph(navController: NavHostController, CharsModel: CharactersModel, onBottomBarVisbilityChanged: (Boolean) -> Unit){
    NavHost(navController, startDestination = Routes.Welcome.route) {
        composable(Routes.Welcome.route){
            onBottomBarVisbilityChanged(true)
            screens.ListScreen(navController = navController, CharsModel)
        }
        composable(BottomNavigationItems.HomeScreen.route){
            onBottomBarVisbilityChanged(true)
            screens.HomeScreen()
        }
        composable(BottomNavigationItems.ContentScreen.route){
            onBottomBarVisbilityChanged(true)
            screens.ContentScreen()
        }
        composable(BottomNavigationItems.NotificationScreen.route){
            onBottomBarVisbilityChanged(true)
            screens.NotificationScreen()
        }
        composable("characterInfo/{characterId}"){entry ->
            val id = entry.arguments?.getString("characterId")?.toInt() ?: 0
            screens.CharacterInfo(CharsModel, id, navController)
        }
    }

}
