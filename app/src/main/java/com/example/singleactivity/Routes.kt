package com.example.singleactivity

sealed class Routes(val route: String) {
    object Welcome : Routes("ListScreen")
}