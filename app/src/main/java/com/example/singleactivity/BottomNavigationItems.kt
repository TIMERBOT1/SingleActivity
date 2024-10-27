package com.example.singleactivity

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationItems(
    val route: String,
    val title: String? = null,
    val icon: ImageVector? = null
){
    object HomeScreen: BottomNavigationItems(
        route = "HomeScreen",
        title = "Home",
        icon = Icons.Outlined.Home
    )
    object ListScreen: BottomNavigationItems(
        route = "ListScreen",
        title = "List",
        icon = Icons.Outlined.List
    )
    object ContentScreen: BottomNavigationItems(
        route = "ContentScreen",
        title = "content",
        icon = Icons.Outlined.ShoppingCart
    )
    object NotificationScreen: BottomNavigationItems(
        route = "NotificationScreen",
        title = "Notification",
        icon = Icons.Filled.Notifications
    )
}