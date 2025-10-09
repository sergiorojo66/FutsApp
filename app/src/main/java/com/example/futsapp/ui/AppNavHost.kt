package com.example.futsapp.ui


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.example.futsapp.ui.screens.HomeScreen
import com.example.futsapp.ui.screens.LoginScreen
import com.example.futsapp.ui.screens.RegisterScreen
import com.example.futsapp.ui.screens.TournamentListScreen


@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("register") { RegisterScreen(navController) }
        composable("tournaments") { TournamentListScreen(navController) }
    }
}