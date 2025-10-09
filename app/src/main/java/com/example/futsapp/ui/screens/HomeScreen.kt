package com.example.futsapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    var showFilters by remember { mutableStateOf(false) }
    var selectedProvincia by remember { mutableStateOf("") }
    var selectedCategoria by remember { mutableStateOf("") }
    var selectedAnio by remember { mutableStateOf("") }

    val provincias = listOf("Palencia")
    val categorias = listOf("2ª División", "1ª División", "División de Honor")
    val anios = (2023..2025).map { it.toString() }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "⚽ Bienvenido a FutsApp ⚽",
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { showFilters = !showFilters },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (showFilters) "Ocultar filtros" else "Buscar Torneo")
            }

            if (showFilters) {
                Spacer(modifier = Modifier.height(24.dp))

                // Provincia
                DropdownMenuBox(
                    label = "Provincia",
                    options = provincias,
                    selectedOption = selectedProvincia,
                    onOptionSelected = { selectedProvincia = it }
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Categoría
                DropdownMenuBox(
                    label = "Categoría",
                    options = categorias,
                    selectedOption = selectedCategoria,
                    onOptionSelected = { selectedCategoria = it }
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Año
                DropdownMenuBox(
                    label = "Año",
                    options = anios,
                    selectedOption = selectedAnio,
                    onOptionSelected = { selectedAnio = it }
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        // Futuro: navegar a la lista de torneos
                        navController.navigate("tournaments")
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Ver Torneos")
                }
            }
        }
    }
}

@Composable
fun DropdownMenuBox(
    label: String,
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Column {
        Text(text = label, fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.height(4.dp))

        OutlinedButton(
            onClick = { expanded = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (selectedOption.isEmpty()) "Seleccionar $label" else selectedOption)
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onOptionSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}
