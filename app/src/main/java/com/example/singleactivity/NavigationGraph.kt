package com.example.singleactivity

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun NavigationGraph(navController: NavHostController, onBottomBarVisbilityChanged: (Boolean) -> Unit){
    NavHost(navController, startDestination = Routes.Welcome.route) {
        composable(Routes.Welcome.route){
            onBottomBarVisbilityChanged(true)
            screens.ListScreen(navController = navController)
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
            screens.CharacterInfo(id, navController)
        }
    }

}
